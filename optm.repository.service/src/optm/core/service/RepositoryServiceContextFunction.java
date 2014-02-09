package optm.core.service;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;

public class RepositoryServiceContextFunction extends ContextFunction {

    @Override
    public Object compute(final IEclipseContext context, final String contextKey) {
        // delegate to ContextInjectionFactory
        // instead of creating a new MyTodoServiceImpl with the new operator.
        // because MyTodoServiceImpl itself uses injection
        IRepositoryService todoService = ContextInjectionFactory.make(RepositoryService.class, context);

        // cache the newly created todoService in the application context for
        // the next time somebody requests it (this prevents this
        // ContextFunction
        // from being called again).

        // get application ctx (to make it available to all parts)
        // and register todoService obj with appCtx
        MApplication app = context.get(MApplication.class);
        IEclipseContext appCtx = app.getContext();
        appCtx.set(IRepositoryService.class, todoService);

        // return model for current invocation
        // next invocation uses object from application context
        return todoService;
    }
}
