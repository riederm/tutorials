package at.mri.tutorial2.emailer;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;

import at.mri.tutorial2.spellchecker.SpellChecker;

@SuppressWarnings("restriction")
@Creatable
public class Emailer {
	
	private SpellChecker spellChecker;
	
	@Inject
	public Emailer(SpellChecker spellChecker) {
		super();
		this.spellChecker = spellChecker;
	}

	public void send(String message){
		String checkedMessage = spellChecker.check(message);
		System.out.println("Message: " + checkedMessage);
	}
}
