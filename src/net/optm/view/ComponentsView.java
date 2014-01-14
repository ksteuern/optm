package net.optm.view;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import net.optm.model.BettingSchedule;
import net.optm.model.Component;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class ComponentsView {

    public ComponentsView() {
    }

    /**
     * Create contents of the view part.
     */
    @PostConstruct
    public void createControls(final Composite parent) {

        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new TreeColumnLayout());

        TreeViewer treeViewer = new TreeViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);

        Component repo = new Component();
        repo.add(new BettingSchedule("first"));
        repo.add(new BettingSchedule("second"));
        treeViewer.setContentProvider(new ComponentsContentProvider());
        treeViewer.setLabelProvider(new ComponentsLabelProvider());
        treeViewer.setInput(repo);
    }

    @PreDestroy
    public void dispose() {
    }

    @Focus
    public void setFocus() {
        // TODO Set the focus to control
    }

}
