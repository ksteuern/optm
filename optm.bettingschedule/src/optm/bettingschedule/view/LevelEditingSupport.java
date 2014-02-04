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

package optm.bettingschedule.view;

import optm.bettingschedule.Messages;
import optm.bettingschedule.model.Level;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

/**
 * @author ksteuern
 * 
 */
public class LevelEditingSupport extends EditingSupport {

    private final TableViewer viewer;

    private final CellEditor editor;

    /**
     * @param viewer
     */
    public LevelEditingSupport(final TableViewer viewer) {
        super(viewer);
        this.viewer = viewer;
        this.editor = new TextCellEditor(viewer.getTable());
        this.editor.setValidator(new ICellEditorValidator() {

            @Override
            public String isValid(final Object value) {
                if (value instanceof String) {
                    try {
                        Integer valueOf = Integer.valueOf((String) value);
                        if (valueOf.compareTo(Integer.valueOf(0)) <= 0) {
                            return Messages.LevelEditingSupport_0;
                        }
                    } catch (NumberFormatException e) {
                        return Messages.LevelEditingSupport_1;
                    }
                }
                return null;
            }
        });
        editor.addListener(new ICellEditorListener() {

            @Override
            public void editorValueChanged(final boolean oldValidState, final boolean newValidState) {
            }

            @Override
            public void cancelEditor() {
            }

            @Override
            public void applyEditorValue() {
                if (!editor.isValueValid()) {
                    MessageDialog.openError(viewer.getControl().getShell(), "No did not work", editor.getErrorMessage()); //$NON-NLS-1$
                }
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
     */
    @Override
    protected CellEditor getCellEditor(final Object element) {
        return this.editor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
     */
    @Override
    protected boolean canEdit(final Object element) {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
     */
    @Override
    protected Object getValue(final Object element) {
        return ((Level) element).getName();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    protected void setValue(final Object element, final Object value) {
        ((Level) element).setName(String.valueOf(value));
        viewer.update(element, null);
    }

}
