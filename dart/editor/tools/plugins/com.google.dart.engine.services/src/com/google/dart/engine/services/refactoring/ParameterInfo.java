/*
 * Copyright (c) 2012, the Dart project authors.
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
package com.google.dart.engine.services.refactoring;

import com.google.dart.engine.element.VariableElement;
import com.google.dart.engine.services.internal.correction.CorrectionUtils;

/**
 * Information about method parameter.
 */
public class ParameterInfo {
  private final String oldName;
  private String newName;
  private String newTypeName;

  public ParameterInfo(VariableElement variable) {
    oldName = variable.getName();
    newName = oldName;
    newTypeName = CorrectionUtils.getTypeSource(variable.getType());
  }

  public String getNewName() {
    return newName;
  }

  public String getNewTypeName() {
    return newTypeName;
  }

  public String getOldName() {
    return oldName;
  }

  public boolean isRenamed() {
    return !oldName.equals(newName);
  }

  public void setNewName(String newName) {
    this.newName = newName;
  }

  public void setNewTypeName(String newTypeName) {
    this.newTypeName = newTypeName;
  }
}
