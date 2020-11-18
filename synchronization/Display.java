import java.util.Random;

// a display resource

class Display {

    int max = 1000; // milliseconds
    Random rGen;

    public Display(int m) {

	max = m;
	rGen = new Random();
    }

    public void displayCount(String name) {

	try {

	    for(int i = 5; i > 0; i--) {

		System.out.println("\t\t\t\t\t**Display** -- " + name + ": tick! " + i);
		Thread.sleep(rGen.nextInt(max));
	    }
	}
	catch (Exception e) {
	    System.out.println("thread " + name + " interrupted");
	}
    }
}
