package at.mri.tutorial3;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.InjectorFactory;

import at.mri.tutorial3.editor.TextEditor;
import at.mri.tutorial3.editor.impl.MockedEditor;
import at.mri.tutorial3.emailer.Emailer;
import at.mri.tutorial3.spellchecker.SpellChecker;
import at.mri.tutorial3.spellchecker.impl.GermanSpellChecker;


@SuppressWarnings("restriction")
public class Application {

	
	public void main(){
		IInjector injector = InjectorFactory.getDefault();
		IEclipseContext injectionContext = EclipseContextFactory.create();
		
		initializeInjector(injector);
		initializeContext(injectionContext);
		
	
		Emailer emailer = ContextInjectionFactory.make(Emailer.class, injectionContext);
		emailer.send();
	}
	
	private void initializeInjector(IInjector injector){
		injector.addBinding(SpellChecker.class)
				//.implementedBy(EnglishSpellChecker.class);
				.implementedBy(GermanSpellChecker.class);
	}
	
	private void initializeContext(IEclipseContext context){
		TextEditor editor = new MockedEditor("Hello world");
		
		//set the mocked instance as our TextEditor of choice
		context.set(TextEditor.class, editor);
	}
	
}
