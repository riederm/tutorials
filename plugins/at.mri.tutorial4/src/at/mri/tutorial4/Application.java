package at.mri.tutorial4;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.InjectorFactory;

import at.mri.tutorial4.editor.TextEditor;
import at.mri.tutorial4.editor.impl.MockedEditor;
import at.mri.tutorial4.emailer.Emailer;
import at.mri.tutorial4.spellchecker.SpellChecker;
import at.mri.tutorial4.spellchecker.impl.EnglishSpellChecker;
import at.mri.tutorial4.spellchecker.impl.GermanSpellChecker;


@SuppressWarnings("restriction")
public class Application {

	
	public void main(){
		IInjector injector = InjectorFactory.getDefault();
		IEclipseContext injectionContext = EclipseContextFactory.create();
		
		initializeInjector(injector);
		initializeContext(injectionContext);
		
		System.out.println("English Emailer");
		Emailer englishEmailer = (Emailer) injectionContext.get("emailer.english");
		englishEmailer.send();
		
		System.out.println("German Emailer");
		Emailer germanEmailer = (Emailer) injectionContext.get("emailer.german");
		germanEmailer.send();
	}
	
	private void initializeInjector(IInjector injector){
		injector.addBinding(SpellChecker.class)
				.implementedBy(EnglishSpellChecker.class);
	}
	
	private void initializeContext(IEclipseContext context){
		TextEditor editor = new MockedEditor("Hello world");
		
		//set the mocked instance as our TextEditor of choice
		context.set(TextEditor.class, editor);
		context.set("emailer.german", new EmailerContextFunction(GermanSpellChecker.class));
		context.set("emailer.english", new EmailerContextFunction(EnglishSpellChecker.class));
	}
	
}
