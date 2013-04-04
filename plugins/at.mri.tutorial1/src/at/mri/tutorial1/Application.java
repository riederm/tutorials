package at.mri.tutorial1;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.InjectorFactory;


@SuppressWarnings("restriction")
public class Application {

	
	public void main(){
		IInjector injector = InjectorFactory.getDefault();
		initializeInjector(injector);
		
		IEclipseContext injectionContext = EclipseContextFactory.create();
		Emailer emailer = ContextInjectionFactory.make(Emailer.class, injectionContext);
		
		emailer.send("hello world");
	}
	
	private void initializeInjector(IInjector injector){
		//no initialization needed
	}
	
}
