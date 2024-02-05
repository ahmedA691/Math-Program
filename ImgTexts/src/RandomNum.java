
import javax.swing.JOptionPane;
public class RandomNum {
	
	public static void RandomNum () {
		int length =0;
		do { length = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of people/things"));
		}while (length<2);
		length = length++;
		int randomNum =-1;
		while (randomNum<1)
		{
			randomNum = utils.randomNumber(length);
		}
		JOptionPane.showMessageDialog(null, "The number is: "+randomNum);
	}

}
