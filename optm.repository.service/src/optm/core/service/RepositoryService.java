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

import optm.core.model.BettingSchedule;
import optm.core.model.Player;
import optm.core.model.Repository;
import optm.core.view.RepositoryContentProvider;
import optm.core.view.RepositoryLabelProvider;

/**
 * @author ksteuern
 * 
 */
public class RepositoryService implements IRepositoryService {

    /*
     * (non-Javadoc)
     * 
     * @see optm.core.service.IRepositoryService#sayHello()
     */
    @Override
    public void sayHello() {
        System.out.println("Hallo Welt!");
    }

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
        return new RepositoryLabelProvider();
    }

    /*
     * (non-Javadoc)
     * 
     * @see optm.core.service.IRepositoryService#getRepository()
     */
    @Override
    public Repository getRepository() {
        Repository repo = new Repository();
        repo.getBettingSchedules().add(new BettingSchedule("first"));
        repo.getBettingSchedules().add(new BettingSchedule("second"));
        repo.getPlayers().add(new Player("heinz"));
        return repo;
    }

}
