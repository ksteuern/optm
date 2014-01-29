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

/**
 * @author ksteuern
 * 
 */
public class Level {

    private String name;

    private int smallBlind;

    private int bigBlind;

    private int ante;

    private int duration;

    public Level() {
    }

    public Level(final String name, final int smallBlind, final int bigBlind, final int ante, final int duration) {
        super();
        this.name = name;
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        this.ante = ante;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(final int smallBlind) {
        this.smallBlind = smallBlind;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public void setBigBlind(final int bigBlind) {
        this.bigBlind = bigBlind;
    }

    public int getAnte() {
        return ante;
    }

    public void setAnte(final int ante) {
        this.ante = ante;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

}
