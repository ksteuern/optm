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

import java.util.List;

import net.optm.bettingschedule.model.Level;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

/**
 * @author ksteuern
 * 
 */
public class MyDropListener extends ViewerDropAdapter {

    private final Viewer viewer;

    private int indexOf;

    public MyDropListener(final Viewer viewer) {
        super(viewer);
        this.viewer = viewer;
    }

    @Override
    public void drop(final DropTargetEvent event) {
        int location = this.determineLocation(event);
        Level target = (Level) determineTarget(event);
        String translatedLocation = "";
        switch (location) {
        case 1:
            translatedLocation = "Dropped before the target ";
            break;
        case 2:
            translatedLocation = "Dropped after the target ";
            break;
        case 3:
            translatedLocation = "Dropped on the target ";
            break;
        case 4:
            translatedLocation = "Dropped into nothing ";
            break;
        }
        System.out.println(translatedLocation);
        System.out.println("The drop was done on the element: " + target);

        @SuppressWarnings("unchecked")
        List<Level> input = (List<Level>) viewer.getInput();
        indexOf = input.indexOf(target);
        super.drop(event);
    }

    @Override
    public boolean performDrop(final Object data) {
        @SuppressWarnings("unchecked")
        List<Level> input = (List<Level>) viewer.getInput();
        String[] split = ((String) data).split(",");
        Level level = new Level(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
        input.remove(level);
        if (indexOf == -1) {
            input.add(level);
        } else {
            input.add(indexOf, level);
        }
        viewer.setInput(input);
        return false;
    }

    @Override
    public boolean validateDrop(final Object target, final int operation, final TransferData transferType) {
        return true;

    }

}
