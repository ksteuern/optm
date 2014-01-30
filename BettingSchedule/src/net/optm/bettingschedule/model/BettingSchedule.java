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
package net.optm.bettingschedule.model;

import java.util.ArrayList;
import java.util.List;

import net.optm.core.model.RepositoryItem;

/**
 * @author ksteuern
 * 
 */
public class BettingSchedule extends RepositoryItem {

    private List<Level> levels;

    public BettingSchedule(final String name) {
        super(name);
        levels = new ArrayList<>();
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(final List<Level> levels) {
        this.levels = levels;
    }

}
