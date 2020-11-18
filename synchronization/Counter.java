// a different kind of countdown timer that counts down using another
// object "Display"

class Counter implements Runnable {

    // attributes

    protected Thread t;
    protected String tName;
    protected Display disp;

    // constructor

    Counter(String name, Display display) {

	tName = name;
	disp = display;
    }

    // methods

    public void start () {

	System.out.println("starting " + tName);
	new Thread(this, tName).start();
    }
    
    public void run() {

	disp.displayCount(tName);
	System.out.println("thread " + tName + " exiting");
    }
}
