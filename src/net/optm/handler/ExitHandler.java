/**
 *
 */
package net.optm.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Handler for exit command.
 * Exits the application.
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
