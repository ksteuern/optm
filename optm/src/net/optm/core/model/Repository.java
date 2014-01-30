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

package net.optm.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksteuern
 * 
 */
public class Repository extends RepositoryGroup<RepositoryItem> {

    private BettingSchedules bettingSchedules;

    private Players players;

    public Repository() {
        super("Repository");
        bettingSchedules = new BettingSchedules();
        players = new Players();
    }

    public BettingSchedules getBettingSchedules() {
        return bettingSchedules;
    }

    public void setBettingSchedules(final BettingSchedules bettingSchedules) {
        this.bettingSchedules = bettingSchedules;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(final Players players) {
        this.players = players;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.optm.model.RepositoryGroup#getChildren()
     */
    @Override
    public List<RepositoryItem> getChildren() {
        List<RepositoryItem> children = new ArrayList<>();
        children.add(getBettingSchedules());
        children.add(getPlayers());
        return children;
    }
}
