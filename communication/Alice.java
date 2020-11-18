// Alice, who asks all of the questions

class Alice implements Runnable {

    Chat m;
    String[] s = { "Hi", "How are you?", "I'm also good!" };

    Alice(Chat chat) {

	m = chat;
	new Thread(this, "Question").start();
    }

    public void run() {

	for (int i = 0; i < s.length; i++) {
	    m.Question("Alice", s[i]);
	}
    }
}
