
import java.security.SecureRandom;

import javax.swing.JOptionPane;
public class utils {
	public static double switchOperation (int operation, double Fnum, double Snum, double result)
	{
		switch (operation) {
		case 1:result=Add(Fnum,Snum);
		break;
		case 2:result=Subt(Fnum,Snum);
		break;
		case 3:result=Multi(Fnum,Snum);
		break;
		case 4:result=Div(Fnum,Snum);
		break;
		}
		return result;
	}
	
	public static double Add(double Fnum, double Snum)
	{
		return(Fnum+Snum);
	}
	public static double Multi(double Fnum, double Snum)
	{
		return(Fnum*Snum);
	}
	public static double Subt(double Fnum , double Snum)
	{
		return(Fnum-Snum);
	}
	public static double Div(double Fnum, double Snum)
	{
		return(Fnum/Snum);
	}
	public static int randomNumber(int length)
	{
		SecureRandom sr = new SecureRandom();
		int num = sr.nextInt(length);
		return num;
	}
	public static int operation ()
	{
		int operation = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of operation you want\n"
				+ "addition = 1 \nSubtraction = 2\nMultiplication = 3\nDivition = 4"));
		return operation;
	}

}
