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
package net.optm.ui.view;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import net.optm.model.BettingSchedule;
import net.optm.model.Player;
import net.optm.model.Repository;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class RepositoryView {

    public RepositoryView() {
    }

    /**
     * Create contents of the view part.
     */
    @PostConstruct
    public void createControls(final Composite parent) {

        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new TreeColumnLayout());

        TreeViewer treeViewer = new TreeViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);

        Repository repo = new Repository();
        repo.getBettingSchedules().add(new BettingSchedule("first"));
        repo.getBettingSchedules().add(new BettingSchedule("second"));
        repo.getPlayers().add(new Player("heinz"));

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
