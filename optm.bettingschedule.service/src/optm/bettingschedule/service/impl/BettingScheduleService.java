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

package optm.bettingschedule.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import optm.bettingschedule.model.BettingSchedule;
import optm.bettingschedule.model.BettingSchedules;
import optm.bettingschedule.service.IBettingScheduleService;
import optm.core.service.IRepositoryService;

/**
 * @author ksteuern
 * 
 */
public class BettingScheduleService implements IBettingScheduleService {

    private final IRepositoryService repositoryService;

    private final List<BettingSchedule> bettingSchedules;

    /**
     * 
     */
    @Inject
    public BettingScheduleService(final IRepositoryService repositoryService) {
        this.repositoryService = repositoryService;
        bettingSchedules = createInitialModel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * optm.bettingschedule.service.IBettingScheduleService#getBettingSchedules
     * ()
     */
    @Override
    public List<BettingSchedule> getBettingSchedules() {
        return bettingSchedules;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * optm.bettingschedule.service.IBettingScheduleService#getBettingSchedule
     * (java.lang.String)
     */
    @Override
    public BettingSchedule getBettingSchedule(final String name) {
        return find(name);
    }

    /**
     * @param name
     */
    private BettingSchedule find(final String name) {
        for (BettingSchedule bettingSchedule : bettingSchedules) {
            if (bettingSchedule.getName().equals(name)) {
                return bettingSchedule;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * optm.bettingschedule.service.IBettingScheduleService#addBettingSchedule
     * (optm.bettingschedule.model.BettingSchedule)
     */
    @Override
    public void addBettingSchedule(final BettingSchedule bettingSchedule) {
        this.bettingSchedules.add(bettingSchedule);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * optm.bettingschedule.service.IBettingScheduleService#deleteBettingSchedule
     * (java.lang.String)
     */
    @Override
    public void deleteBettingSchedule(final String name) {
        BettingSchedule find = find(name);
        this.bettingSchedules.remove(find);
    }

    /**
     * @return
     */
    private List<BettingSchedule> createInitialModel() {
        List<BettingSchedule> bettingSchedules = new ArrayList<>();
        bettingSchedules.add(new BettingSchedule("first"));
        bettingSchedules.add(new BettingSchedule("second"));
        BettingSchedules bettingSchedules2 = new BettingSchedules();
        bettingSchedules2.addAll(bettingSchedules);
        repositoryService.addItem(bettingSchedules2);
        return bettingSchedules;
    }

}
