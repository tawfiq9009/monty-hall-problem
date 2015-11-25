package com.tassmeem.monty;

/**
 * @author tawfiq
 *
 * This Enum for User Message
 *
 */
public enum ResultMessage {

	INPUT_OUT_OF_RANGE("Input out of Range"),
	INVALID_INPUT("Invalid Input"),
	WIN("Win"),
	LOST("Lost");
	
	private String message;
	
	private ResultMessage(String message){
		this.message = message;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}	
}
