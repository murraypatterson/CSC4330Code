public class RunCounters {

    public static void main(String args[]) {

	// insantiate display with < 1000 millisecond pause
	Display disp = new Display(1000);

	// initialize both counters, which share the same display
	Counter c1 = new Counter("counter_1", disp);
	Counter c2 = new Counter("counter_2", disp);

	// start these counters
	c1.start();
	c2.start();

    }
}
