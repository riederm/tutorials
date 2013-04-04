package at.mri.tutorial1;

import org.eclipse.e4.core.di.annotations.Creatable;

@SuppressWarnings("restriction")
@Creatable
public class Emailer {
	
	public void send(String message){
		System.out.println("Message: " + message);
	}
}
