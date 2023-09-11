package ua.com.snake;

public class Time {
//nano time in every moment 
	public static double timeStarted = System.nanoTime();
//how much time passed from timeStarted time
	public static double getTime() {
		return (System.nanoTime()-timeStarted)*1E-9;
	}
}
