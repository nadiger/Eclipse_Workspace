package CHAPTER_9_THREADS;

public class ThreadExtendsThread extends Thread {

	public void run() {
		System.out.println("Thread is Running");
		System.out.println("Things to remember: This Thread is running by Extending Thread Class");
	}
}
