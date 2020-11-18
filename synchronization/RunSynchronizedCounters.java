public class RunSynchronizedCounters {

    public static void main(String args[]) {

	// insantiate display with < 1000 millisecond pause
	Display disp = new Display(1000);

	// initialize both counters, which share the same display, but
	// synchroniously now
	Counter c1 = new SynchronizedCounter("counter_1", disp);
	Counter c2 = new SynchronizedCounter("counter_2", disp);

	// start these counters
	c1.start();
	c2.start();

    }
}
