// a chat object, which enforces a question/answer sequence between
// two callers

class Chat {

    boolean flag = false;

    // now the method is synchronized, instead of the entire object
    public synchronized void Question(String name, String msg) {

	if (flag) {

	    try {
		wait();
	    }
	    catch (InterruptedException e) {}
	}

	System.out.println(name + ": " + msg);
	flag = true;
	notify();
    }

    // other synchronized method
    public synchronized void Answer(String name, String msg) {

	if (!flag) {

	    try {
		wait();
	    }
	    catch (InterruptedException e) {}
	}

	System.out.println(name + ": " + msg);
	flag = false;
	notify();
    }
}
