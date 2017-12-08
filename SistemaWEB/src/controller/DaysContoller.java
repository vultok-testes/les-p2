package controller;

public class DaysContoller {
	private int currentDay;
	
	public DaysContoller() {
		currentDay = 0;
	}

	public int nextDay() {
		currentDay++;
		
		
		return currentDay;
	}
	
	public int getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
}
