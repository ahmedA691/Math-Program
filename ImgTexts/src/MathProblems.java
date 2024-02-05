
import javax.swing.JOptionPane;

public class MathProblems {

	public static void MathProblems() {
		int loopControl =0;
		do {
			int operation = utils.operation();
			int digit1 = Integer.parseInt(JOptionPane.showInputDialog("please enter the number of digits for the first number"));
			int digit2 = Integer.parseInt(JOptionPane.showInputDialog("please enter the number of digits for the second number"));
			digit1 = (int) Math.pow(10, digit1);
			digit2 = (int) Math.pow(10, digit2);
			int num1 = utils.randomNumber(digit1);
			int num2 = utils.randomNumber(digit2);
			String input = cases(operation, num1, num2);
			double guess = Double.parseDouble(JOptionPane.showInputDialog(input));
			int result = 0;
			result= (int) utils.switchOperation(operation, num1, num2, result);
			if(guess==result)
			{
				JOptionPane.showMessageDialog(null,"You're right. Good job");
			}
			if(guess!=result)
			{
				JOptionPane.showMessageDialog(null,"You're wrong. The answer is\n"+result);
			}
			loopControl = Integer.parseInt(JOptionPane.showInputDialog("Do you want to try again?\n 0=no 1=yes"));
		}while (loopControl==1);
	}
	private static String cases(int operation, double num1, double num2) {
		String input = "";
		switch (operation) {
		case 1: input = "What is the answer for\n " + num1 + " + " + num2 + "?";
		break;
		case 2: input = "What is the answer for\n " + num1 + " - " + num2 + "?";
		break;
		case 3: input = "What is the answer for\n " + num1 + " X " + num2 + "?";
		break;
		case 4: input = "What is the answer for\n " + num1 + " / " + num2 + "?";
		break;
		}
		return input;
	}

}
