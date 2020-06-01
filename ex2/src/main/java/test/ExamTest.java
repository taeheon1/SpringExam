package test;

public class ExamTest {
	private static ExamTest instance;

	public static ExamTest getInstance() {
		if (instance == null) {
			instance = new ExamTest();
		}
		return instance;
	}

	private ExamTest() {
	}

	public void getMessage() {
		System.out.println("ExamTest.getMessage().....");
	}
}
