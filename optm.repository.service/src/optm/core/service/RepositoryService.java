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

import javax.inject.Inject;

import optm.core.model.Repository;
import optm.core.model.RepositoryItem;
import optm.core.view.MyEventConstants;
import optm.core.view.RepositoryContentProvider;
import optm.core.view.RepositoryLabelProvider;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * @author ksteuern
 * 
 */
public class RepositoryService implements IRepositoryService {

    private final Repository repository = new Repository(null);

    private final RepositoryLabelProvider repositoryLabelProvider = new RepositoryLabelProvider();

    @Inject
    IEventBroker eventBroker;

    /*
     * (non-Javadoc)
     * 
     * @see optm.core.service.IRepositoryService#getContentProvider()
     */
    @Override
    public RepositoryContentProvider getContentProvider() {
        return new RepositoryContentProvider();
    }

    /*
     * (non-Javadoc)
     * 
     * @see optm.core.service.IRepositoryService#getLabelProvider()
     */
    @Override
    public RepositoryLabelProvider getLabelProvider() {
        return repositoryLabelProvider;
    }

    /*
     * (non-Javadoc)
     * 
     * @see optm.core.service.IRepositoryService#getRepository()
     */
    @Override
    public Repository getRepository() {
        return repository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * optm.core.service.IRepositoryService#addLabelProvider(optm.core.service
     * .LabelProvider)
     */
    @Override
    public void addLabelProvider(final LabelProvider labelProvider) {
        repositoryLabelProvider.addProvider(labelProvider);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * optm.core.service.IRepositoryService#addItem(optm.core.model.RepositoryItem
     * )
     */
    @Override
    public void addItem(final RepositoryItem item) {
        repository.add(item);
        eventBroker.send(MyEventConstants.TOPIC_REPOSITORY_UPDATE, item);
    }

}
