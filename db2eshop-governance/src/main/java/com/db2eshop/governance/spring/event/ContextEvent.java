package com.db2eshop.governance.spring.event;

public class ContextEvent {

	private String message; 
	private State state = State.MARKER;
	
	public ContextEvent(String message){
		this.message = message;
	}
	
	public ContextEvent(State state){
		this.state = state;
	}
	
	public enum State{
		MARKER,
		FINISHED;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
