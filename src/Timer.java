
public class Timer {

	private static long startTime;
	private static long endTime;
	
	public Timer() {
	}
	
	public void startTime() {
		startTime = System.nanoTime();
	}
	
	public void endTime() {
		endTime = System.nanoTime();
		long timed = startTime - endTime;
		System.out.println(String.format("Execution Time: %s ns \n", timed));
	}
	
	public void restart() {
		endTime = System.nanoTime();
		long timed = endTime - startTime;
		System.out.println(String.format("Execution Time: %s ns \n", timed));
		startTime = System.nanoTime();
	}
}
