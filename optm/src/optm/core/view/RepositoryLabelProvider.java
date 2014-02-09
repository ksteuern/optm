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

import java.util.ArrayList;
import java.util.List;

import optm.core.model.RepositoryItem;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class RepositoryLabelProvider extends LabelProvider {

    private final List<LabelProvider> providers = new ArrayList<>();

    public void addProvider(final LabelProvider labelProvider) {
        providers.add(labelProvider);
    }

    @Override
    public String getText(final Object element) {
        RepositoryItem component = (RepositoryItem) element;
        String name = component.getName();
        return name;
    }

    @Override
    public Image getImage(final Object element) {
        for (LabelProvider labelProvider : providers) {
            Image image = labelProvider.getImage(element);
            if (image != null) {
                return image;
            }
        }
        return null;
    }

}
