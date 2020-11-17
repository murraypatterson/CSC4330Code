import java.util.Random;

// a parameterized version of `CountDown` where we may vary the number
// of ticks and the time between ticks (see second constructor)

public class ParamCountDown implements Runnable {

    // attributes

    private Thread counter;
    private int i;
    private String tName;
    private int N = 3; // default is 3, but can be any int
    private boolean isRandom = false;
    private Random rGen;

    // constructor

    public ParamCountDown(String name) {

	tName = name;
	System.out.println("creating " + tName);
    }

    // were we may vary the number of ticks / time between ticks
    public ParamCountDown(String name, int ticks, boolean random) {

	tName = name;
	System.out.println("creating " + tName);
	N = ticks; // can be any number instead of just 3

	// random generation stuff
	isRandom = random;
	rGen = new Random();

	// above: pause between ticks is some random number between 0
	// and 999 milliseconds instead of 1000 milliseconds
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

	    if (i>0) {

		tick();
		i--; // decrement counter
	    }

	    if (i==0) {

		beep();
		break;
	    }
	}

	System.out.println("thread " + tName + " exiting");
    }

    private void tick() {

	System.out.println(tName + ": tick! " + i);

	try {

	    int lapse = 1000;
	    if(isRandom) {
		lapse = rGen.nextInt(1000);
		Thread.sleep(lapse);
	    }
	    else {
		Thread.sleep(lapse); // milliseconds
	    }
	    System.out.println("\t\t\t\t\t(" + tName + ": " + lapse + " milliseconds pause)");
	}
	catch (InterruptedException e) {}
    }

    private void beep() {

	System.out.println(tName + ": beep!");
    }
}
