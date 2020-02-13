package pj4.ErrorHandling;

public class ThrowChainPractice {
	public static void main(String[] args) {

		try {
			chainThree();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void chainOne() throws ManualException {
		throw new ManualException();
	}

	public static void chainTwo() throws Exception {
		try {
			chainOne();
		} catch (ManualException e) {
			throw new Exception("chain two",e);
		}
	}

	public static void chainThree() throws Exception {
		try {
			chainTwo();
		} catch (Exception e) {
			Exception eLast = new Exception("chain three");
			eLast.initCause(e);
			throw eLast;
		}
	}
}
