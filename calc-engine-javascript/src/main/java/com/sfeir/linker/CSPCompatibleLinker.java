package com.sfeir.linker;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.linker.CrossSiteIframeLinker;
import com.google.gwt.core.linker.DirectInstallLinker;

/**
 * This Linker doesn't create iframe it injects a script directly in the host page.
 * So the generated GWT application is compatible with the Chrome Apps CSP (Content Security Policy).
 *
 * Thanks to T. Broyer's answer to the question : http://stackoverflow.com/questions/12123178/can-not-make-gwt-application-work-as-chrome-packaged-app-probably-due-to-csp
 */
public class CSPCompatibleLinker extends DirectInstallLinker {

    @Override
    protected String getJsInstallLocation(LinkerContext context) {
        return "com/google/gwt/core/ext/linker/impl/installLocationMainWindow.js";
    }

}
