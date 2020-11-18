// a synchronized version of "Counter" that counts down using another
// object "Display", and also synchronizes via this (shared) object

class SynchronizedCounter extends Counter implements Runnable {

    // constructor

    SynchronizedCounter(String name, Display display) {

	super(name, display);
    }

    // methods

    public void run() {

	synchronized(disp) { // this ensures that only one thread can
			     // have access to display at a time
	    disp.displayCount(tName);
	}

	System.out.println("thread " + tName + " exiting");
    }
}
