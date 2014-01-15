/*
 * (C) Copyright 2014 Kai Steuernagel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package net.optm.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler for exit command. Exits the application.
 * 
 * @author ksteuern
 * 
 */
public class ExitHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExitHandler.class);

    @Execute
    public void execute(final IWorkbench workbench) {
        System.out.println("called exit command");
        logger.debug("exit");
        workbench.close();
    }

    @CanExecute
    public boolean canExecute() {
        return true;
    }

}
