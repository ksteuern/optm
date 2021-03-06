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

package optm.bettingschedule;

import org.eclipse.osgi.util.NLS;

/**
 * @author ksteuern
 * 
 */
public class Messages extends NLS {

    private static final String BUNDLE_NAME = "optm.bettingschedule.messages"; //$NON-NLS-1$

    public static String BettingScheduleView_ante;

    public static String BettingScheduleView_big_blind;

    public static String BettingScheduleView_duration;

    public static String BettingScheduleView_level;

    public static String BettingScheduleView_small_blind;

    public static String BettingScheduleView_tltmNewItem_toolTipText;

    public static String LevelEditingSupport_0;

    public static String LevelEditingSupport_1;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
