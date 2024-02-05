
		import net.sourceforge.tess4j.Tesseract;
		import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.*;
		import java.io.File;
		import javax.swing.JOptionPane;
public class ImgText {

		public static String ImgText() {
			String pic = (JOptionPane.showInputDialog("please provide the path of the image"));
			Tesseract tesseract = new Tesseract();
			try {
				String path = /*Globals.imagePath+*/"lib\\Tess4J\\tessdata";
				tesseract.setDatapath(path);
				String text = tesseract.doOCR(new File (pic));
				text = API.API("fix the spelling mistakes in this text. If this is a math problem only give me the solution I don't need the steps"+text);
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