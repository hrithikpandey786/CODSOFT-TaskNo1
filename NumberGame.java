import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NumberGame {
	
	public static void main(String args[]) {
		try {
			Game obj = new Game();		
		} catch(Exception e) {
			System.out.print("Exception caught");
		}
	}
	
}

class Game extends JFrame implements ActionListener{
	
	JLabel title = new JLabel();
	JLabel txt1 = new JLabel();
	JLabel txt2 = new JLabel();
	JLabel txt3 = new JLabel();
	JLabel txt4 = new JLabel();
	JLabel txt5 = new JLabel();
	JLabel img = new JLabel();
	JTextField t = new JTextField(10);
	JButton subButton = new JButton();
	JButton restartButton = new JButton();
	JButton quitButton = new JButton();
	Font customFont;
	Font txtF1;
	Font txtF2;
	
	int guessedNum = 0;
	int tries = 6;
	int min = 0;
	int max = 100;
	int ranNum = 0;
	
	Game() throws FontFormatException, IOException{
		
		setTitle("Guessing Game");
		setVisible(true);
		setLayout(null);
		setSize(400, 380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		
		try {
		    //create the font to use. Specify the size!
			txtF1 = Font.createFont(Font.TRUETYPE_FONT, new File("Preahvihear-Regular.ttf")).deriveFont(13f);
			txtF2 = Font.createFont(Font.TRUETYPE_FONT, new File("Preahvihear-Regular.ttf")).deriveFont(12f);
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("IndieFlower-Regular.ttf")).deriveFont(Font.BOLD, 34f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(customFont);
		    ge.registerFont(txtF1);
		    ge.registerFont(txtF2);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		title.setFont(customFont);
		title.setText("Number Game");
		title.setBounds(90, 5, 250, 30);
		title.setVisible(true);
		title.setForeground(Color.BLUE);
		
		txt1.setFont(txtF1);
		txt1.setText("A number is chosen between 1 to 100.");
		txt1.setBounds(72, 50, 300, 20);
		
		txt2.setFont(txtF1);
		txt2.setText("You need to guess the number within    tries.");
		txt2.setBounds(48, 67, 300, 20);
		
		txt3.setFont(txtF2);
		txt3.setText("Type your guess here: ");
		txt3.setBounds(30, 103, 300, 20);
		
		txt4.setFont(txtF1);
		txt4.setForeground(Color.red);
		
		txt5.setText(tries+"");
		txt5.setBounds(299, 67, 50, 20);
		txt5.setForeground(Color.red);
		txt5.setFont(txtF2);
		
		ranNum = (int)(Math.random()*(max-min+1)+min);
		t.setBounds(180, 103, 80, 18);
		
		restartButton.setText("Restart");
		restartButton.setBounds(90, 130, 85, 22);
		restartButton.setVisible(false);
		
		quitButton.setText("Quit");
		quitButton.setBounds(219, 130, 85, 22);
		quitButton.setVisible(false);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		subButton.setText("Submit");
		subButton.setBounds(276, 103, 80, 20);
		subButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				tries--;
				guessedNum = Integer.parseInt(t.getText());
				
				if(tries == 0 && guessedNum != ranNum) {
					txt4.setText("Sorry, You didn't guessed it right.");
					txt4.setBounds(89, 90, 265, 30);
					GameActive(false);
				} 
				else if(tries == 0 && guessedNum == ranNum || guessedNum == ranNum) {
					txt4.setText("Congratulations!! You Guessed it right.");
					txt4.setBounds(76, 90, 265, 30);
					GameActive(false);
				} 
				else if(guessedNum < ranNum) {
					Event();
				} 
				else if(guessedNum > ranNum) {
					Event();
		    }
			}
			
		});
		
		restartButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				ranNum = (int)(Math.random()*(max-min+1)+min);
				GameActive(true);
			}
			
		});
		
		img.setIcon(new ImageIcon("guess-the-number.png"));
		Dimension size = img.getMinimumSize();
		img.setBounds(50, 150, size.width, size.height);;
		
		add(title);
		add(txt1);
		add(txt2);
		add(txt3);
		add(t);
		add(subButton);
		add(txt4);
		add(txt5);
		add(restartButton);
		add(quitButton);
		add(img);
	}
	
	public void GameActive(boolean isGameActive) {
		
		if(isGameActive == true) {
			tries = 6;
			txt5.setText(tries+"");
			txt2.setText("You need to guess the number within    tries.");
			restartButton.setVisible(false);
			txt4.setVisible(false);
			t.setVisible(true);
			t.setText("");
			txt1.setVisible(true);
			txt2.setVisible(true);
			txt3.setVisible(true);
			txt5.setVisible(true);
			subButton.setVisible(true);
			quitButton.setVisible(false);
			img.setVisible(true);
		} else {
			restartButton.setVisible(true);
			t.setVisible(false);
			txt1.setVisible(false);
			txt2.setVisible(false);
			txt3.setVisible(false);
			txt5.setVisible(false);
			subButton.setVisible(false);
			quitButton.setVisible(true);
			img.setVisible(false);
		}
		
	}
    
	public void Event() {
		
		txt4.setBounds(160, 125, 200, 20);
        txt4.setVisible(true);
	    txt5.setText(tries+"");
	    txt2.setText("You need to guess the number within    tries.");
		
		if(guessedNum < ranNum) {
			txt4.setText("Too Low. Try Again");
		} else if(guessedNum > ranNum) {
			txt4.setText(" Too High. Try Again");
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

