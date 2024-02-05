

import javax.swing.JOptionPane;

public class Calculator {

	public static void calculator() {
		int test =0;
		double Fnum = 0;
		do{int operation =utils.operation();
		if(test==0)
			{Fnum = Double.parseDouble(JOptionPane.showInputDialog("Enter a number"));}
		double Snum = Double.parseDouble(JOptionPane.showInputDialog("Enter another number"));
		Globals.result=utils.switchOperation(operation, Fnum, Snum, Globals.result);
		Fnum =Double.parseDouble(JOptionPane.showInputDialog("The result is: "+Globals.result+"\n put another number\nOr put -9999 when you are finished calculating"));
		Fnum =Fnum+Globals.result;
		test =1;
		}while (Fnum!=-9999);
}
}