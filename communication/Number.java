// take a number... like at the DMV

public class Number implements Runnable {

    private int i_;
    private Control control;

    public Number(int i, Control c) {

	i_ = i;
	control = c;
    }

    public void start() {
	new Thread(this).start();
    }

    public void run() {

	synchronized(control) { // this ensure that you wait your turn
	    control.call(i_);
	}
    }
}
