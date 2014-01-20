package bettingschedule;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class OpenBettings {

    @Execute
    public void execute(final EPartService partService) {
        MPart mpart = partService.showPart("bettingschedule.part.0", PartState.ACTIVATE);
        System.out.println(mpart);
    }

    @CanExecute
    public boolean canExecute() {
        return true;
    }
}
