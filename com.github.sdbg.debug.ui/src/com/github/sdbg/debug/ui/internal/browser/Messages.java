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
package com.github.sdbg.debug.ui.internal.browser;

import org.eclipse.osgi.util.NLS;

/**
 *
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "com.github.sdbg.debug.ui.internal.browser.messages"; //$NON-NLS-1$
  public static String BrowserLaunchConfigurationDelegate_BrowserNotFound;
  public static String BrowserLaunchConfigurationDelegate_DefaultBrowserNotFound;
  public static String BrowserLaunchConfigurationDelegate_HtmlFileNotFound;
  public static String BrowserLaunchConfigurationDelegate_UrlError;
  public static String BrowserLaunchConfigurationDelegate_NoDebugSupportMessage;
  public static String BrowserLaunchConfigurationDelegate_NoJavascriptErrorMessage;
  public static String BrowserLaunchShortcut_NoJavascriptErrorMessage;
  public static String BrowserLaunchShortcut_NotHtmlFileErrorMessage;
  public static String BrowserLaunchShortcut_NotInLibraryErrorMessage;

  public static String BrowserMainTab_BrowserNotSpecifiedErrorMessage;
  public static String BrowserMainTab_Description;
  public static String BrowserMainTab_LaunchTarget;
  public static String BrowserMainTab_Name;
  public static String BrowserMainTab_Select;
  public static String BrowserMainTab_DialogTitle;
  public static String BrowserMainTab_DialogMessage;
  public static String BrowserMainTab_Dart2js;

  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
  }
}
