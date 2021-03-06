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
package optm.bettingschedule.model;

import optm.core.Messages;
import optm.core.model.RepositoryGroup;

/**
 * @author ksteuern
 * 
 */
public class BettingSchedules extends RepositoryGroup<BettingSchedule> {

    public BettingSchedules() {
        super(Messages.BettingSchedules_0);
    }

}
