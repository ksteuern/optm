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
package net.optm.view;

import java.net.URL;

import net.optm.model.Component;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class ComponentsLabelProvider extends LabelProvider {

    @Override
    public String getText(final Object element) {
        Component component = (Component) element;
        String name = component.getName();
        return name;
    }

    @Override
    public Image getImage(final Object element) {
        if (element instanceof Component) {
            Component component = (Component) element;
            if (component.getImageFileName() != null) {
                return getImageFromPlugin(component.getImageFileName());
            }
        }
        return null;
    }

    // Helper Method to load the images
    private Image getImageFromPlugin(final String file) {
        Bundle bundle = FrameworkUtil.getBundle(ComponentsLabelProvider.class);
        URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
        ImageDescriptor image = ImageDescriptor.createFromURL(url);
        return image.createImage();
    }
}
