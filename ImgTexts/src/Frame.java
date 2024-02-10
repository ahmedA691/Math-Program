
import java.awt.Color;

import java.lang.Runtime;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class Frame extends JFrame implements ActionListener {
	int counter =0;
	Thread musicThread; 
	Thread myFrameThread;
	private Frame()
	{
		
		Globals.Music = createButton("mute music", 680,700,150,50,this);
		Globals.FindAnswer = createButton("Find the answer", 1075,500,150,50,this);
		Globals.Calculator = createButton("Calculator",1100,300 , 100, 50,this);
		
		
		Globals.mathProblem = createButton("Questions",300, 300, 100, 50,this);
		
		
		Globals.RandomNum = createButton("Random Number",285, 500, 130, 50,this);
		
		Border border = BorderFactory.createLineBorder(Color.black,3);
		
		ImageIcon logo = new ImageIcon("lib\\aa.jpg");
		ImageIcon img= new ImageIcon("lib\\cool.jpg");
		this.setVisible(true);
		//this.setSize(500, 420);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Math Problem");
		//this.getContentPane().setBackground(Color.orange);
		this.getContentPane().setBackground(new Color(200,200,200));
		this.setIconImage(logo.getImage());
		//this.setResizable(false); //prevent resizing the this.
		JLabel label = new JLabel();
		label.setText("Math Program");
		label.setHorizontalTextPosition(JLabel.CENTER);// set the text in relation to the image
		label.setVerticalTextPosition(JLabel.TOP);
		
		label.setIcon(img);
		label.setForeground(Color.white);
		label.setBackground(Color.black);
		label.setOpaque(true); //set background color
		label.setFont(new Font("Arial",Font.PLAIN,20));
		label.setBorder(border);
		label.setVerticalAlignment(JLabel.TOP);//set the whole label
		label.setHorizontalAlignment(JLabel.CENTER);//set the whole label
		//label.setBounds(150, 0, 150,50);//set the label dimantions in the frame
		label.add(Globals.Calculator);
		label.add(Globals.mathProblem);
		label.add(Globals.RandomNum);
		label.add(Globals.FindAnswer);
		label.add(Globals.Music);
		label.setVisible(true);
		this.add(label);
		//this.setLayout(null);
		JLabel pic= new JLabel();
		//this.add(pic);
		this.pack();//this will automatically set the layout of the frame according to the label that it has
		musicThread = new Thread(Music::Music);  // Create and start the music thread
		musicThread.start();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Globals.Calculator)
		{
			Calculator calculator= new Calculator();
			calculator.calculator();
		}
		else if(e.getSource()==Globals.mathProblem)
		{
			MathQuestions math =MathQuestionsFactory.getInstance();
			math.use();
		}
		else if(e.getSource()==Globals.RandomNum)
		{
			RandomNum.RandomNum();
		}
		else if(e.getSource()==Globals.FindAnswer)
		{
			int choice =0;
			do{choice = Integer.parseInt(JOptionPane.showInputDialog("put the number of the choice that you want\n1- Provide an image of the problem\n"
					+ "2- Write down the problem\n3- Change Api Key\n(Remember, this is only a prototype. The answer might not be accurate)"));
			
			}while(choice>3 || choice <1);
			if(choice==1)
			{
				ImgText.ImgText();
			}
			else if(choice==2) {
				Ai ai = AiFactory.getInstance();
				JOptionPane.showMessageDialog(null, ai.getApi());
			}
			else if (choice==3)
			{
				Globals.ApiKey = JOptionPane.showInputDialog("Put the new Api Key");
				JOptionPane.showMessageDialog(null, "the new Api key has been saved");
			}
			
		}
		else if(e.getSource()==Globals.Music)
		{
			if(Globals.MusicControl&counter<5)
				{Globals.MusicControl = false;
				Globals.Music.setText("unmute music");
				counter++;
				}
			else if(!Globals.MusicControl&counter<5) {
			Globals.MusicControl = true;
			Globals.Music.setText("mute music");
				counter++;}
			else if(counter<10)
			{
				JOptionPane.showMessageDialog(null, "YOU PLAYED WITH THIS BUTTON TOO MUCH.\n"
						+ "THAT'S IT, YOU ARE NOT WORTHY TO LISTEN TO THIS MUSIC");
				counter++;
			}
			else if(counter==10)
			{
				JOptionPane.showMessageDialog(null, "PLAY WITH SOMETHING ELSE, THIS PROGRAM WILL DISAPEEAAAAR, bye bye, and find a purpose for your life");
				try {
					deleteMe.deleteMe();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.gc();
				System.exit(0);
			}
			
		}
			
	}
	public static Frame view() {
		return new Frame();
	}
	private static JButton createButton(String name, int x, int y, int width, int height, ActionListener listener)
	{
		JButton button = new JButton (name);
		button.setBounds(x, y, width, height);
		button.addActionListener(listener);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		return button;
	}
	private static void close(JFrame frame)
	{
		frame.setVisible(false);
	}

}
