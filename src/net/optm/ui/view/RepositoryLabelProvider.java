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

import java.net.URL;

import net.optm.Icons;
import net.optm.model.BettingSchedule;
import net.optm.model.BettingSchedules;
import net.optm.model.Player;
import net.optm.model.Players;
import net.optm.model.RepositoryItem;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class RepositoryLabelProvider extends LabelProvider {

    @Override
    public String getText(final Object element) {
        RepositoryItem component = (RepositoryItem) element;
        String name = component.getName();
        return name;
    }

    @Override
    public Image getImage(final Object element) {
        if (element instanceof BettingSchedules) {
            return getImageFromPlugin(Icons.BettingSchedules_1);
        } else if (element instanceof BettingSchedule) {
            return getImageFromPlugin(Icons.BettingSchedules_1);
        } else if (element instanceof Players) {
            return getImageFromPlugin(Icons.Players_1);
        } else if (element instanceof Player) {
            return getImageFromPlugin(Icons.Players_1);
        }
        return null;
    }

    // Helper Method to load the images
    private Image getImageFromPlugin(final String file) {
        Bundle bundle = FrameworkUtil.getBundle(RepositoryLabelProvider.class);
        URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
        ImageDescriptor image = ImageDescriptor.createFromURL(url);
        return image.createImage();
    }
}
