// a shared resource that ensures that the set of "Number"s which
// share this object proceed in order, according to "counter"

public class Control {

    private int counter = 0;

    public void call(int i) {

	while(i != counter) {

	    try {
		wait();
	    }
	    catch(Exception e) {}
	}
	
	System.out.println(i);
	counter++; // next, please
	notifyAll();
    }
}
