
public class MathQuestionsFactory {
	private final static MathQuestions math = MathQuestions.create();
	public static MathQuestions getInstance()
	{
		return math;
	}

}
