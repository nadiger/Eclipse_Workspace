package CHAPTER_9_THREADS;

public class RunnableThreadName implements Runnable {

	public void run() {
		System.out.println("RunnableThreadName is running");
		System.out.println("Run By "+Thread.currentThread().getName());
	}

}
