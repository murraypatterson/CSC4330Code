public class RunNumbers {

    public static void main(String args[]) {

	int n = 0;
	if (args.length > 0) {
	    n = Integer.parseInt(args[0]);
	}

       	Control c = new Control();

	// take a bunch of numbers, where controller ensures that they
	// go in order
	for(int i = 0; i < n; ++i) {
	    new Number(i, c).start();
	}
    }
}
