// a simple countdown timer as seen in the "Threads" slides

public class CountDown implements Runnable {

    // attributes

    Thread counter; // does most of the work
    int i;
    String tName;
    final static int N = 3; // 3 ticks

    // constructor

    CountDown(String name) {

	tName = name;
	System.out.println("creating " + tName);
    }

    // methods

    public void start() {

	System.out.println("starting " + tName);

	counter = new Thread(this);
	i = N;

	counter.start(); // start the thread
    }

    public void stop() {

	counter = null;
    }

    public void run() {

	System.out.println("running " + tName);

	while(true) {

	    if (counter == null)
		break;

	    if (i>0)  {

		tick();
		i--;
	    }

	    if (i==0) {

		beep();
		break;
	    }
	}

	System.out.println("thread " + tName + " exiting");
    }

    private void tick() {

	System.out.println("tick! " + i);

	try {

	    Thread.sleep(1000); // milliseconds
	}
	
	catch (InterruptedException e) {} }

    private void beep() {

	System.out.println("beep!");
    }
}
