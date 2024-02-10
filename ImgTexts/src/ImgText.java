
		import net.sourceforge.tess4j.Tesseract;


		import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.*;
		import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class ImgText {

		public static String ImgText() {
			File pic = null;
			JFileChooser file = new JFileChooser();
			int option = JOptionPane.showOptionDialog(null, file, "Select a File", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				  pic = file.getSelectedFile();
			
			Tesseract tesseract = new Tesseract();
			try {
				String path = /*Globals.imagePath+*/"lib\\Tess4J\\tessdata";
				tesseract.setDatapath(path);
				String text = tesseract.doOCR(pic);
				Ai ai = AiFactory.getInstance();
				text = ai.use("fix the spelling mistakes in this text. If this is a math problem only give me the solution I don't need the steps"+text);
				String answer = text.replace(". ", "\n");
				System.out.print(answer);
				JOptionPane.showMessageDialog(null, answer);
				return answer;
			} catch (TesseractException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}

}