/**
 * 
 */
package net.optm.view;

import java.net.URL;

import net.optm.model.BettingSchedule;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

class ComponentsLabelProvider extends LabelProvider {

    @Override
    public String getText(final Object element) {
        BettingSchedule file = (BettingSchedule) element;
        String name = file.getName();
        return name;
    }

    @Override
    public Image getImage(final Object element) {
        return getImageFromPlugin("table.png");
    }
 // Helper Method to load the images
    private Image getImageFromPlugin(final String file) {
      Bundle bundle = FrameworkUtil.getBundle(ComponentsView.class);
      URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
      ImageDescriptor image = ImageDescriptor.createFromURL(url);
      return image.createImage();

    }
}