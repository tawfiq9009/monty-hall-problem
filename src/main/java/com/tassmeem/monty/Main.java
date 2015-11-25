package com.tassmeem.monty;

public class Main {

	public static void main(String[] args) {

		MontyHall montyHall = new MontyHall();
		Result result = montyHall.playGame(3);
		System.out.println(result.getResultMessage().getMessage());
		
	}

}
