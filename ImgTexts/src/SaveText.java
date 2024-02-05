import java.io.FileWriter;
import java.io.BufferedWriter;
import javax.swing.JOptionPane;

public class SaveText {
	public static void SaveText(String text)
	{
		String path = (JOptionPane.showInputDialog("Please provide a path that a text file will be saved in"));
		String name = (JOptionPane.showInputDialog("What do you want the name of the text file to be?"));
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(path+"\\"+name+".txt"));
			br.write(text);
			br.close();
		}
		catch (Exception e)
		{
			
		}
	}
	
}
