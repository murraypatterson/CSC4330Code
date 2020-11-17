public class RunParamCountDowns {

    public static void main(String args[]) {

	// construct first parameterized counter and run it
	ParamCountDown c1 = new ParamCountDown("counter_1", 5, true);
	c1.start();

	// construct second parameterized counter and run it
	ParamCountDown c2 = new ParamCountDown("counter_2", 5, true);
	c2.start();
    }
}
