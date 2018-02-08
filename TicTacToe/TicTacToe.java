import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


class TicTacToe implements ActionListener
{
	//startGameComponents
	JFrame mainFrame;
	JButton b[];
	JLabel nameOfGame;
	ImageIcon imgZero,imgX;
	

	//onStartComponents
	JDialog enterNameDialog;
	JLabel enterNameLabel;
	JLabel namePlayerFirst,namePlayerSecond;
	JTextField firstPlayerName, secondPlayerName;
	JButton startGame;
	JLabel imgZeroButton, imgXButton;
	JLabel turnLabel;
	ImageIcon im1 = new ImageIcon("images/zero.gif");
	ImageIcon im2 = new ImageIcon("images/x.gif");
	JButton playAgain;
	
	void onStart()
	{
		//DialogBox
		enterNameDialog = new JDialog(mainFrame,"TicTacToe : Players",true);
		enterNameDialog.setSize(500,500);
		enterNameDialog.setLayout(null);
		
		
		//EnterNameLabel
		enterNameLabel = new JLabel("Enter Player Name");
		enterNameLabel.setFont(new java.awt.Font("Times New Roman", 2, 40));
		enterNameLabel.setBounds(80,50,450,50);
		enterNameDialog.add(enterNameLabel);
		
		//FirstPlayerName
		namePlayerFirst =new JLabel("First:");
		namePlayerFirst.setFont(new java.awt.Font("Times New Roman", 2, 18));
		namePlayerFirst.setBounds(50,150,70,18);
		enterNameDialog.add(namePlayerFirst);
		
		firstPlayerName = new JTextField(null);
		firstPlayerName.setBounds(160,145,150,30);
		firstPlayerName.setText("");
		enterNameDialog.add(firstPlayerName);
		
		//SecondPlayerName
		namePlayerSecond =new JLabel("Second:");
		namePlayerSecond.setFont(new java.awt.Font("Times New Roman", 2, 18));
		namePlayerSecond.setBounds(50,250,70,18);
		enterNameDialog.add(namePlayerSecond);
		
		secondPlayerName = new JTextField(null);
		secondPlayerName.setBounds(160,245,150,30);
		secondPlayerName.setText("");
		enterNameDialog.add(secondPlayerName);
		
		//ImageZeroOnDialogBox
		imgZeroButton = new JLabel();
		imgZeroButton.setBounds(360,125,70,70);
		imgZeroButton.setBorder(null);
		imgZeroButton.setIcon(im1);
		enterNameDialog.add(imgZeroButton);
		
		//ImageXOnDialogBox
		imgXButton = new JLabel();
		imgXButton.setBounds(360,225,70,70);
		imgXButton.setBorder(null);
		imgXButton.setIcon(im2);
		enterNameDialog.add(imgXButton);
		
		//StartGameButton
		startGame = new JButton("Start Game");
		startGame.setBounds(185,320,100,30);
		enterNameDialog.add(startGame);
		
		startGame.addActionListener(this);
		enterNameDialog.setVisible(true);
	}
	
	void startGame()
	{
		b = new JButton[9];
		mainFrame = new JFrame("TicTacToe : By Sachin");
		//mainFrame.add(this);
		
		//TicTacToeLabel
		nameOfGame = new JLabel("Tic Tac Toe");
		nameOfGame.setFont(new java.awt.Font("Times New Roman", 3, 40));
		nameOfGame.setBounds(200,20,250,50);
		mainFrame.add(nameOfGame);
		
		//TurnLabel
		turnLabel = new JLabel();
		turnLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
		turnLabel.setBounds(170,360,430,50);
		turnLabel.setText(firstPlayerName.getText()+"'s Turn");
		mainFrame.add(turnLabel);
		
		//PlayAgainButton
		playAgain = new JButton("Play Again");
		playAgain.setBounds(240,440,100,50);
		playAgain.addActionListener(this);
		mainFrame.add(playAgain);
		
		
		for(int i=0;i<b.length;i++)
		{
			b[i] = new JButton();
		}
		
		b[0].setBounds(170,100,80,80);
		b[1].setBounds(250,100,80,80);
		b[2].setBounds(330,100,80,80);
		
		b[3].setBounds(170,180,80,80);
		b[4].setBounds(250,180,80,80);
		b[5].setBounds(330,180,80,80);
		
		b[6].setBounds(170,260,80,80);
		b[7].setBounds(250,260,80,80);
		b[8].setBounds(330,260,80,80);
				
		
		for(int i=0;i<b.length;i++)
		{
			//b[i].setBorderPainted(false);
			b[i].setBorder(new LineBorder(new Color(45, 145, 128)));
			b[i].setBackground(new Color(49, 167, 169));
			b[i].addActionListener(this);
			mainFrame.add(b[i]);
		}
		
		
		
		//mainFrame.setBackground(new Color(38, 175, 166));
		mainFrame.setLayout(null);
		mainFrame.getContentPane().setBackground(new Color(64, 196, 174));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(600,600);
		mainFrame.setVisible(true);	
	}
	
	TicTacToe()
	{
		onStart();
	}
	
	
	int flag = 0;
	boolean secondClick[] = new boolean[9];
	String playerFirst[] = new String[9];
	String playerSecond[] = new String[9];
	
	{
		//OnSecondClick-NoChange
		for(int i = 0;i<secondClick.length;i++)
		{
			secondClick[i] = true;
		}
		
		//PlayerFirst
		for(int i=0;i<playerFirst.length;i++)
		{
			playerFirst[i] = null;
		}
		
		//PlayerSecond
		for(int i=0;i<playerSecond.length;i++)
		{
			playerSecond[i] = null;
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		imgZero = new ImageIcon("images/zero.gif");
		imgX = new ImageIcon("images/x.gif");
		
		if(e.getSource() == startGame)
		{
			String nameFirst = firstPlayerName.getText();
			String nameSecond = secondPlayerName.getText();
			if((firstPlayerName.getText().equals("")) && (secondPlayerName.getText().equals("")))
			{
				JOptionPane.showMessageDialog(enterNameDialog, "Please Enter Name of Both Players!!!");
			}
			else
			{
				startGame();
				enterNameDialog.dispose();
			}
		}
		
		if(e.getSource()== b[0])
		{
			if((flag == 0) && (secondClick[0] == true))
			{
				b[0].setIcon(imgZero);
				flag = 1;
				playerFirst[0] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[0] == true))
			{
				b[0].setIcon(imgX);
				flag = 0;
				playerSecond[0] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[0] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource()== b[1])
		{
			if((flag == 0) && (secondClick[1] == true))
			{
				b[1].setIcon(imgZero);
				flag = 1;
				playerFirst[1] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[1] == true))
			{
				b[1].setIcon(imgX);
				flag = 0;
				playerSecond[1] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[1] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource()== b[2])
		{
			if((flag == 0) && (secondClick[2] == true))
			{
				b[2].setIcon(imgZero);
				flag = 1;
				playerFirst[2] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[2] == true))
			{
				b[2].setIcon(imgX);
				flag = 0;
				playerSecond[2] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[2] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource()==b[3])
		{
			if((flag == 0) && (secondClick[3] == true))
			{
				b[3].setIcon(imgZero);
				flag = 1;
				playerFirst[3] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[3] == true))
			{
				b[3].setIcon(imgX);
				flag = 0;
				playerSecond[3] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[3] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource()==b[4])
		{
			if((flag == 0) && (secondClick[4] == true))
			{
				b[4].setIcon(imgZero);
				flag = 1;
				playerFirst[4] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[4] == true))
			{
				b[4].setIcon(imgX);
				flag = 0;
				playerSecond[4] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[4] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource()==b[5])
		{
			if((flag == 0) && (secondClick[5] == true))
			{
				b[5].setIcon(imgZero);
				flag = 1;
				playerFirst[5] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[5] == true))
			{
				b[5].setIcon(imgX);
				flag = 0;
				playerSecond[5] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[5] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource()==b[6])
		{
			if((flag == 0) && (secondClick[6] == true))
			{
				b[6].setIcon(imgZero);
				flag = 1;
				playerFirst[6] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[6] == true))
			{
				b[6].setIcon(imgX);
				flag = 0;
				playerSecond[6] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[6] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource()==b[7])
		{
			if((flag == 0) && (secondClick[7] == true))
			{
				b[7].setIcon(imgZero);
				flag = 1;
				playerFirst[7] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[7] == true))
			{
				b[7].setIcon(imgX);
				flag = 0;
				playerSecond[7] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[7] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource()==b[8])
		{
			if((flag == 0) && (secondClick[8] == true))
			{
				b[8].setIcon(imgZero);
				flag = 1;
				playerFirst[8] = "win";
				turnLabel.setText(secondPlayerName.getText()+"'s Turn");
			}
			else if((flag == 1) && (secondClick[8] == true))
			{
				b[8].setIcon(imgX);
				flag = 0;
				playerSecond[8] = "win";
				turnLabel.setText(firstPlayerName.getText()+"'s Turn");
			}
			secondClick[8] = false;
			System.out.println("Flag:"+flag);
			checkWin();
		}
		
		if(e.getSource() == playAgain)
		{
			mainFrame.dispose();
			new TicTacToe();
		}
		
	}
	
	void checkWin()
	{
		if(((playerFirst[0] == "win") && (playerFirst[1] == "win") && (playerFirst[2] == "win")) ||
		   ((playerFirst[3] == "win") && (playerFirst[4] == "win") && (playerFirst[5] == "win")) ||
		   ((playerFirst[6] == "win") && (playerFirst[7] == "win") && (playerFirst[8] == "win")) ||
		   ((playerFirst[0] == "win") && (playerFirst[3] == "win") && (playerFirst[6] == "win")) ||
		   ((playerFirst[1] == "win") && (playerFirst[4] == "win") && (playerFirst[7] == "win")) ||
		   ((playerFirst[2] == "win") && (playerFirst[5] == "win") && (playerFirst[8] == "win")) ||
		   ((playerFirst[0] == "win") && (playerFirst[4] == "win") && (playerFirst[8] == "win")) ||
		   ((playerFirst[2] == "win") && (playerFirst[4] == "win") && (playerFirst[6] == "win"))  )
		{			
			System.out.println("Player First Wins...!!!");
			turnLabel.setText("Winner : "+firstPlayerName.getText());
			JOptionPane.showMessageDialog(mainFrame, firstPlayerName.getText()+" Wins");
			for(int i = 0;i<b.length;i++)
			{
				b[i].addActionListener(null);
				b[i].setEnabled(false);
			}
		}
		else if(((playerSecond[0] == "win") && (playerSecond[1] == "win") && (playerSecond[2] == "win")) ||
				((playerSecond[3] == "win") && (playerSecond[4] == "win") && (playerSecond[5] == "win")) ||
				((playerSecond[6] == "win") && (playerSecond[7] == "win") && (playerSecond[8] == "win")) ||
				((playerSecond[0] == "win") && (playerSecond[3] == "win") && (playerSecond[6] == "win")) ||
				((playerSecond[1] == "win") && (playerSecond[4] == "win") && (playerSecond[7] == "win")) ||
				((playerSecond[2] == "win") && (playerSecond[5] == "win") && (playerSecond[8] == "win")) ||
				((playerSecond[0] == "win") && (playerSecond[4] == "win") && (playerSecond[8] == "win")) ||
				((playerSecond[2] == "win") && (playerSecond[4] == "win") && (playerSecond[6] == "win"))  )
		{
			System.out.println("Player Second Wins...!!!");
			turnLabel.setText("Winner : "+secondPlayerName.getText());
			JOptionPane.showMessageDialog(mainFrame, secondPlayerName.getText()+" Wins");
			for(int i = 0;i<b.length;i++)
			{
				b[i].addActionListener(null);
				b[i].setEnabled(false);
			}
		}
	}
	
	
	public static void main(String... ar)
	{
		new TicTacToe();
	}
}