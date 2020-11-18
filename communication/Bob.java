// Bob, who claims to have all the answers

class Bob implements Runnable {

    Chat m;
    String[] s = { "Hi", "I'm good, and you?", "Great!" };

    Bob(Chat chat) {

	m = chat;
	new Thread(this, "Answer").start();
    }

    public void run() {

	for (int i = 0; i < s.length; i++) {
	    m.Answer("Bob", s[i]);
	}
    }
}
