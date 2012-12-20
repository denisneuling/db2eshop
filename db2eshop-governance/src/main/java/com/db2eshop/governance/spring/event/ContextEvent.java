package com.db2eshop.governance.spring.event;

/**
 * <p>ContextEvent class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class ContextEvent {

	private String message; 
	private State state = State.MARKER;
	
	/**
	 * <p>Constructor for ContextEvent.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 */
	public ContextEvent(String message){
		this.message = message;
	}
	
	/**
	 * <p>Constructor for ContextEvent.</p>
	 *
	 * @param state a {@link com.db2eshop.governance.spring.event.ContextEvent.State} object.
	 */
	public ContextEvent(State state){
		this.state = state;
	}
	
	public enum State{
		MARKER,
		FINISHED;
	}

	/**
	 * <p>Getter for the field <code>message</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <p>Setter for the field <code>message</code>.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * <p>Getter for the field <code>state</code>.</p>
	 *
	 * @return a {@link com.db2eshop.governance.spring.event.ContextEvent.State} object.
	 */
	public State getState() {
		return state;
	}

	/**
	 * <p>Setter for the field <code>state</code>.</p>
	 *
	 * @param state a {@link com.db2eshop.governance.spring.event.ContextEvent.State} object.
	 */
	public void setState(State state) {
		this.state = state;
	}
}
