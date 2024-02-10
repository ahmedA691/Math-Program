

import java.security.SecureRandom;


import javax.swing.JOptionPane;
public class Utils {
	public static double switchOperation (String operation, double Fnum, double Snum)
	{
		switch (operation) {
		case Globals.add:return Fnum+Snum;
		case Globals.sub:return Fnum-Snum;
		case Globals.multi:return Fnum*Snum;
		case Globals.div:return Fnum/Snum;
		}
		return 0;
	}
	public static int randomNumber(int length)
	{
		SecureRandom sr = new SecureRandom();
		int num = sr.nextInt(length);
		return num;
	}
	public static String operation ()
	{
		final String operations[] = {Globals.add,Globals.sub,Globals.multi,Globals.div};
		String op = (String) JOptionPane.showInputDialog(null, "Choose an operation","Operation list",JOptionPane.DEFAULT_OPTION,null,operations,null);
		if(op==null) return null;
		return op;
	}
	public static void confirm()
	{
		Globals.choice = JOptionPane.showConfirmDialog(null, "Do you want to contine", "confirm",JOptionPane.YES_NO_OPTION);
	}
	private static void Utils()
	{}
	
}
