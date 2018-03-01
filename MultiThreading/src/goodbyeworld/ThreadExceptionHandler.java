package goodbyeworld;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutionException;

public class ThreadExceptionHandler implements UncaughtExceptionHandler {

	private ExecutionException exception; 
	
	public ExecutionException getException() {
		return exception;
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		exception = new ExecutionException(e);
	}

}
