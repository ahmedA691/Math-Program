
public class AiFactory {
	
	private final static Ai instance = Ai.use();
	public static Ai getInstance()
	{
		return instance;
	}
}
