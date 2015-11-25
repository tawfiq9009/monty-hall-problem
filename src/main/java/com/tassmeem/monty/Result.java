package com.tassmeem.monty;

public class Result {

	private ResultMessage resultMessage;
	private boolean win;
	
	public Result(ResultMessage resultMessage, boolean win) {
		
		this.resultMessage = resultMessage;
		this.win = win;
	}
	
	/**
	 * @return the resultMessage
	 */
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
	
	/**
	 * @param resultMessage the resultMessage to set
	 */
	public void setResultMessage(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	/**
	 * @return the win
	 */
	public boolean isWin() {
		return win;
	}
	
	/**
	 * @param win the win to set
	 */
	public void setWin(boolean win) {
		this.win = win;
	}

	@Override
	public String toString() {
		return "Result [resultMessage=" + resultMessage + ", win=" + win + "]";
	}
	
}
