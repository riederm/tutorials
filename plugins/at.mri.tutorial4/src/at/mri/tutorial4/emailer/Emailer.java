package at.mri.tutorial4.emailer;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;

import at.mri.tutorial4.editor.TextEditor;
import at.mri.tutorial4.spellchecker.SpellChecker;

@SuppressWarnings("restriction")
@Creatable
public class Emailer {
	
	private SpellChecker spellChecker;
	private TextEditor editor;
	
	@Inject
	public Emailer(SpellChecker spellChecker, TextEditor editor) {
		super();
		this.spellChecker = spellChecker;
		this.editor = editor;
	}

	public void send(){
		String message = editor.getText();
		String checkedMessage = spellChecker.check(message);
		System.out.println("Message: " + checkedMessage);
	}
}
