/**
 *
 */
package net.optm.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;


/**
 * Handler for exit command.
 * Exits the application.
 *
 * @author ksteuern
 *
 */
public class ExitHandler {


    @Execute
    public void execute(final IWorkbench workbench) {
        System.out.println("called exit command");
        workbench.close();
    }

    @CanExecute
    public boolean canExecute() {
        return true;
    }

}
