public class RunChat {

    public static void main(String[] args) {

	Chat m = new Chat();

	// note that they both use the oject at the same time..
	new Alice(m);
	new Bob(m);
    }
}
