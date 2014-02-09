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
package optm.core.service;

import optm.core.model.Repository;
import optm.core.model.RepositoryItem;
import optm.core.view.RepositoryContentProvider;
import optm.core.view.RepositoryLabelProvider;

import org.eclipse.jface.viewers.LabelProvider;

/**
 * @author ksteuern
 * 
 */
public interface IRepositoryService {

    Repository getRepository();

    RepositoryContentProvider getContentProvider();

    RepositoryLabelProvider getLabelProvider();

    void addLabelProvider(LabelProvider labelProvider);

    void addItem(RepositoryItem item);
}
