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
package bettingschedule;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class BettingScheduleView {

    private final String[][] schedule = { {"1", "5", "10", "20"}, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            {"2", "10", "20", "20"}}; //$NON-NLS-1$ //$NON-NLS-2$

    private Table table;

    @Inject
    public BettingScheduleView() {
        // TODO Your code here
    }

    @PostConstruct
    public void createControls(final Composite parent) {

        Composite composite = new Composite(parent, SWT.NONE);
        TableColumnLayout tcl_composite = new TableColumnLayout();
        composite.setLayout(tcl_composite);

        TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
        table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
        tcl_composite.setColumnData(tblclmnNewColumn, new ColumnPixelData(150, true, true));
        tblclmnNewColumn.setText("Level");

        TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
        tcl_composite.setColumnData(tblclmnNewColumn_1, new ColumnPixelData(150, true, true));
        tblclmnNewColumn_1.setText("Small Blind");

        TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
        tcl_composite.setColumnData(tblclmnNewColumn_2, new ColumnPixelData(150, true, true));
        tblclmnNewColumn_2.setText("Big Blind");

        TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
        tcl_composite.setColumnData(tblclmnNewColumn_3, new ColumnPixelData(150, true, true));
        tblclmnNewColumn_3.setText("Dauer");

        for (String[] level : schedule) {
            TableItem tableItem = new TableItem(table, SWT.NONE);
            tableItem.setText(level);
        }
        final TableEditor editor = new TableEditor(table);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;
        editor.minimumWidth = 50;
        // editing the second column
        final int EDITABLECOLUMN = 1;

        table.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(final SelectionEvent e) {
                // Clean up any previous editor control
                Control oldEditor = editor.getEditor();
                if (oldEditor != null) {
                    oldEditor.dispose();
                }

                // Identify the selected row
                TableItem item = (TableItem) e.item;
                if (item == null) {
                    return;
                }

                // The control that will be the editor must be a child of the
                // Table
                Text newEditor = new Text(table, SWT.NONE);
                newEditor.setText(item.getText(EDITABLECOLUMN));
                newEditor.addModifyListener(new ModifyListener() {

                    @Override
                    public void modifyText(final ModifyEvent me) {
                        Text text = (Text) editor.getEditor();
                        editor.getItem().setText(EDITABLECOLUMN, text.getText());
                    }
                });
                newEditor.selectAll();
                newEditor.setFocus();
                editor.setEditor(newEditor, item, EDITABLECOLUMN);
            }
        });
        // TODO Your code here
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
