/*
 * Copyright (c) 2013, the Dart project authors.
 * 
 * Licensed under the Eclipse Public License v1.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.sdbg.debug.ui.internal.objectinspector;

import com.github.sdbg.debug.ui.internal.SDBGDebugUIPlugin;
import com.github.sdbg.debug.ui.internal.util.SelectionUtil;
import com.github.sdbg.ui.instrumentation.UIInstrumentation;
import com.github.sdbg.ui.instrumentation.UIInstrumentationBuilder;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Open an object inspector on the given object selection.
 */
public class OpenInspectorAction implements IObjectActionDelegate {
  private ISelection selection;

  public OpenInspectorAction() {

  }

  @Override
  public void run(IAction action) {
    if (selection != null) {
      UIInstrumentationBuilder instrumentation = UIInstrumentation.builder(getClass());

      try {
        instrumentation.record(selection);

        Object obj = SelectionUtil.getSingleElement(selection);

        if (obj instanceof IVariable) {
          IVariable variable = (IVariable) obj;

          try {
            ObjectInspectorView.inspect(variable.getValue());
          } catch (DebugException e) {
            SDBGDebugUIPlugin.logError(e);
          }
        } else if (obj instanceof IValue) {
          IValue value = (IValue) obj;

          ObjectInspectorView.inspect(value);
        }

        instrumentation.metric("Inspect", "Completed");
      } finally {
        instrumentation.log();
      }
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    this.selection = selection;
  }

  @Override
  public void setActivePart(IAction action, IWorkbenchPart targetPart) {

  }

}
