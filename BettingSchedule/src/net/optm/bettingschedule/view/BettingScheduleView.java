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
package net.optm.bettingschedule.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.optm.bettingschedule.Messages;
import net.optm.bettingschedule.model.Level;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.ResourceManager;

public class BettingScheduleView {

    private Table table;

    private List<Level> levels;

    @Inject
    public BettingScheduleView() {
        // TODO Your code here
    }

    @PostConstruct
    public void createControls(final Composite parent) {
        levels = new ArrayList<>();
        levels.add(new Level("1", 5, 10, 0, 20)); //$NON-NLS-1$
        levels.add(new Level("2", 10, 20, 0, 20)); //$NON-NLS-1$

        parent.setLayout(new FormLayout());

        Composite composite = new Composite(parent, SWT.NONE);
        FormData fd_composite = new FormData();
        fd_composite.bottom = new FormAttachment(0, 298);
        fd_composite.right = new FormAttachment(0, 600);
        fd_composite.top = new FormAttachment(0);
        fd_composite.left = new FormAttachment(0);
        composite.setLayoutData(fd_composite);
        composite.setLayout(new GridLayout(1, false));

        ToolBar toolBar = new ToolBar(composite, SWT.FLAT | SWT.RIGHT);

        ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
        tltmNewItem.setImage(ResourceManager.getPluginImage("optm", "icons/add.png"));
        tltmNewItem.setToolTipText(Messages.BettingScheduleView_tltmNewItem_toolTipText);

        final TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
        table = tableViewer.getTable();
        tltmNewItem.addListener(SWT.Selection, new Listener() {

            @Override
            public void handleEvent(final Event event) {
                System.out.println("add new level"); //$NON-NLS-1$
                levels.add(new Level(Integer.toString(levels.size() + 1), 0, 0, 0, 0));
                tableViewer.refresh(true, true);
            }
        });
        GridData gd_table = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_table.heightHint = 400;
        // gd_table.widthHint = 390;
        table.setLayoutData(gd_table);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableViewerColumn colName = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn column = colName.getColumn();
        column.setText(Messages.BettingScheduleView_level);
        column.setAlignment(SWT.RIGHT);
        column.setWidth(50);
        colName.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(final Object element) {
                Level p = (Level) element;
                return p.getName();
            }
        });
        colName.setEditingSupport(new LevelEditingSupport(tableViewer));
        TableViewerColumn colSmall = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn column2 = colSmall.getColumn();
        column2.setText(Messages.BettingScheduleView_small_blind);
        column2.setAlignment(SWT.RIGHT);
        column2.setWidth(100);
        colSmall.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(final Object element) {
                Level p = (Level) element;
                return Integer.toString(p.getSmallBlind());
            }
        });
        TableViewerColumn colBig = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn column3 = colBig.getColumn();
        column3.setText(Messages.BettingScheduleView_big_blind);
        column3.setAlignment(SWT.RIGHT);
        column3.setWidth(100);
        colBig.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(final Object element) {
                Level p = (Level) element;
                return Integer.toString(p.getBigBlind());
            }
        });
        TableViewerColumn colAnte = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn column4 = colAnte.getColumn();
        column4.setText(Messages.BettingScheduleView_ante);
        column4.setAlignment(SWT.RIGHT);
        column4.setWidth(100);
        colAnte.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(final Object element) {
                Level p = (Level) element;
                return Integer.toString(p.getBigBlind());
            }
        });
        TableViewerColumn colDuration = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn column5 = colDuration.getColumn();
        column5.setText(Messages.BettingScheduleView_duration);
        column5.setAlignment(SWT.RIGHT);
        column5.setWidth(100);
        colDuration.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(final Object element) {
                Level p = (Level) element;
                return Integer.toString(p.getBigBlind());
            }
        });

        tableViewer.setContentProvider(ArrayContentProvider.getInstance());
        tableViewer.setInput(levels);

    }

    @Focus
    public void onFocus() {
        // TODO Your code here
    }

    @Persist
    public void save() {
        // TODO Your code here
    }
}
