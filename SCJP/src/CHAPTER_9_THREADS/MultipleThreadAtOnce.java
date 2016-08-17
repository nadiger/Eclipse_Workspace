package CHAPTER_9_THREADS;

public class MultipleThreadAtOnce implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <5; i++) {
			System.out.println("Run By "+Thread.currentThread().getName()+" at "+i);
		}
		
	}

}
