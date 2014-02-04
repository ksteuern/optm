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

import net.optm.bettingschedule.model.Level;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;

/**
 * @author ksteuern
 * 
 */
public class MyDragListener implements DragSourceListener {

    private final TableViewer viewer;

    public MyDragListener(final TableViewer viewer) {
        this.viewer = viewer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.
     * DragSourceEvent)
     */
    @Override
    public void dragStart(final DragSourceEvent event) {
        System.out.println("Start Drag");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd
     * .DragSourceEvent)
     */
    @Override
    public void dragSetData(final DragSourceEvent event) {
        final IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        final Level firstElement = (Level) selection.getFirstElement();

        if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
            event.data = firstElement.toString();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd
     * .DragSourceEvent)
     */
    @Override
    public void dragFinished(final DragSourceEvent event) {
        System.out.println("Finshed Drag");
    }

}
