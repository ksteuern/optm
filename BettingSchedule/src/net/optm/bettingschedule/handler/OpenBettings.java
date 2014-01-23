package net.optm.bettingschedule.handler;

import javax.inject.Named;

import net.optm.bettingschedule.model.BettingSchedule;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class OpenBettings {

    @Execute
    public void execute(final EPartService partService, @Optional @Named(IServiceConstants.ACTIVE_SELECTION) final BettingSchedule schedule) {
        if (schedule != null) {
            MPart part = partService.findPart("net.optm.bettingschedule.part.bettingSchedule");
            part.setVisible(true);
            partService.showPart(part, PartState.VISIBLE);
        }
    }

    @CanExecute
    public boolean canExecute() {
        return true;
    }
}
