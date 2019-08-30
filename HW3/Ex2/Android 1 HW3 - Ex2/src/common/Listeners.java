package common;

import java.awt.Event;

import family.Subject;

public interface Listeners {
	public void care(Subject subj);
	public void listen(Event evt);
}
