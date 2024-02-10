
import javax.swing.JOptionPane;

public class MathQuestions {
	private static void mathProblems() {
		do {
			String operation = Utils.operation();
			if(operation==null)break;
			int digit1 = Integer.parseInt(JOptionPane.showInputDialog("please enter the number of digits for the first number"));
			int digit2 = Integer.parseInt(JOptionPane.showInputDialog("please enter the number of digits for the second number"));
			digit1 = (int) Math.pow(10, digit1);
			digit2 = (int) Math.pow(10, digit2);
			int num1 = Utils.randomNumber(digit1);
			int num2 = Utils.randomNumber(digit2);
			String input = cases(operation, num1, num2);
			double guess = Double.parseDouble(JOptionPane.showInputDialog(input));
			Globals.result= (int) Utils.switchOperation(operation, num1, num2);
			if(guess==Globals.result)
			{
				JOptionPane.showMessageDialog(null,"You're right. Good job");
			}
			if(guess!=Globals.result)
			{
				JOptionPane.showMessageDialog(null,"You're wrong. The answer is\n"+Globals.result);
			}
			Utils.confirm();
		}while (Globals.choice==JOptionPane.YES_OPTION);
	}
	private static String cases(String operation, double num1, double num2) {
		String input = "";
		switch (operation) {
		case Globals.add:return input = "What is the answer for\n " + num1 + " + " + num2 + "?";
		case Globals.sub:return input = "What is the answer for\n " + num1 + " - " + num2 + "?";
		case Globals.multi:return input = "What is the answer for\n " + num1 + " X " + num2 + "?";
		case Globals.div:return input = "What is the answer for\n " + num1 + " / " + num2 + "?";
		}
		return input;
	}
	private static void MathQuestions()
	{}
	public static MathQuestions create()
	{
		return new MathQuestions();
	}
	public static void use()
	{
		mathProblems();
	}
	

}
