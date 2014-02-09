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

import optm.bettingschedule.service.IBettingScheduleService;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;

/**
 * @author ksteuern
 * 
 */
public class BettingScheduleServiceContextFunction extends ContextFunction {

    @Override
    public Object compute(final IEclipseContext context, final String contextKey) {
        // delegate to ContextInjectionFactory
        // instead of creating a new MyTodoServiceImpl with the new operator.
        // because MyTodoServiceImpl itself uses injection
        IBettingScheduleService todoService = ContextInjectionFactory.make(BettingScheduleService.class, context);

        // cache the newly created todoService in the application context for
        // the next time somebody requests it (this prevents this
        // ContextFunction
        // from being called again).

        // get application ctx (to make it available to all parts)
        // and register todoService obj with appCtx
        MApplication app = context.get(MApplication.class);
        IEclipseContext appCtx = app.getContext();
        appCtx.set(IBettingScheduleService.class, todoService);

        // return model for current invocation
        // next invocation uses object from application context
        return todoService;
    }
}
