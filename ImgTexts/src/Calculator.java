

import javax.swing.JOptionPane;

public class Calculator {

	public static void calculator() {
		double Fnum = 0;
		if(Globals.result!=0)Globals.result=0;
		do{String operation =Utils.operation();
		if(operation==null)break;
			{Fnum = Globals.result+Double.parseDouble(JOptionPane.showInputDialog("Enter a number"));}
		double Snum = Double.parseDouble(JOptionPane.showInputDialog("Enter another number"));
		Globals.result=Utils.switchOperation(operation, Fnum, Snum);
		JOptionPane.showMessageDialog(null,"The result is: "+Globals.result);
		Utils.confirm();
		}while (Globals.choice==JOptionPane.YES_OPTION);
}
}