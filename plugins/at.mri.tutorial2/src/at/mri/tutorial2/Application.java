package at.mri.tutorial2;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.InjectorFactory;

import at.mri.tutorial2.emailer.Emailer;
import at.mri.tutorial2.spellchecker.SpellChecker;
import at.mri.tutorial2.spellchecker.impl.EnglishSpellChecker;
import at.mri.tutorial2.spellchecker.impl.GermanSpellChecker;


@SuppressWarnings("restriction")
public class Application {

	
	public void main(){
		IInjector injector = InjectorFactory.getDefault();
		initializeInjector(injector);
		
		IEclipseContext injectionContext = EclipseContextFactory.create();
		Emailer emailer = ContextInjectionFactory.make(Emailer.class, injectionContext);
		
		emailer.send("hello world");
		emailer.send("hallo welt");
	}
	
	private void initializeInjector(IInjector injector){
		injector.addBinding(SpellChecker.class)
				//.implementedBy(EnglishSpellChecker.class);
				.implementedBy(GermanSpellChecker.class);
	}
	
}
