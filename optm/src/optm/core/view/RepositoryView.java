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
package optm.core.view;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import optm.core.model.BettingSchedule;
import optm.core.model.Player;
import optm.core.model.Repository;
import optm.core.service.IRepositoryService;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

@SuppressWarnings("restriction")
public class RepositoryView {

    @Inject
    private EMenuService menuService;

    @Inject
    private ESelectionService service;

    @Inject
    private IRepositoryService repositoryService;

    // @Inject
    // IRepositoryService repositoryService;

    public RepositoryView() {
    }

    /**
     * Create contents of the view part.
     */
    @PostConstruct
    public void createControls(final Composite parent) {

        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new TreeColumnLayout());

        final TreeViewer treeViewer = new TreeViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        treeViewer.addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(final DoubleClickEvent event) {
                IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
                Object selectedNode = thisSelection.getFirstElement();
                if (selectedNode instanceof BettingSchedule) {
                    System.out.println("BettingSchedule: " + ((BettingSchedule) selectedNode).getName());
                } else if (selectedNode instanceof Player) {
                    System.out.println("Player: " + ((Player) selectedNode).getName());
                }
            }
        });
        treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(final SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
                service.setSelection(selection.getFirstElement());
            }
        });
        treeViewer.setContentProvider(new RepositoryContentProvider());
        treeViewer.setLabelProvider(new RepositoryLabelProvider());
        treeViewer.setInput(getDummyInput());
        Tree tree = treeViewer.getTree();
        menuService.registerContextMenu(tree, "optm.popupmenu.0");
        repositoryService.sayHello();
    }

    /**
     * @return
     */
    private Repository getDummyInput() {
        Repository repo = new Repository();
        repo.getBettingSchedules().add(new BettingSchedule("first"));
        repo.getBettingSchedules().add(new BettingSchedule("second"));
        repo.getPlayers().add(new Player("heinz"));
        return repo;
    }

    @PreDestroy
    public void dispose() {
    }

    @Focus
    public void setFocus() {
        // TODO Set the focus to control
    }

}
