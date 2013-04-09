package at.mri.tutorial4;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

import at.mri.tutorial4.emailer.Emailer;
import at.mri.tutorial4.spellchecker.SpellChecker;

public class EmailerContextFunction extends ContextFunction{
	private Class<? extends SpellChecker> spellCheckerType; 

	public EmailerContextFunction(
			Class<? extends SpellChecker> spellCheckerType) {
		this.spellCheckerType = spellCheckerType;
	}

	@Override
	public Object compute(IEclipseContext context) {
		//create a separate context for this specialized object-graph
		IEclipseContext concreteMailerContext = context.createChild();
		
		//choose the concrete spellchecker for the SpellChecker-dependencies
		SpellChecker concreteSpellChecker = ContextInjectionFactory.make(spellCheckerType, concreteMailerContext);
		concreteMailerContext.set(SpellChecker.class, concreteSpellChecker);
		
		//create the object under the newly defined context
		return ContextInjectionFactory.make(Emailer.class, concreteMailerContext);
	}
}