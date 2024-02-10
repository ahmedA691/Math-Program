
public class FrameFactory {
	private final static Frame instance = Frame.view();
	public static Frame getInstance()
	{
		return instance;
	}
}
