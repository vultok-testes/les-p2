package events;

public interface EventHandler {
	public void handleEvent(Event e);
	public void returnToDefault();
}
