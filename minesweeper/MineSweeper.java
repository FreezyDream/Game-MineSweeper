package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;

public class MineSweeper extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private int scoreCounter = 0;
	private JLabel label;
	private JLabel resultLabel;
	private JPanel buttonPanel;
	private JMenuItem newGame;
	private JMenuItem exit;
	private JMenuItem instruction;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private JButton button11;
	private JButton button12;
	private JButton button13;
	private JButton button14;
	private JButton button15;
	private JButton button16;
	private JButton button17;
	private JButton button18;
	private JButton button19;
	private JButton button20;
	private JButton button21;
	private JButton button22;
	private JButton button23;
	private JButton button24;
	private JButton button25;
	private JButton button26;
	private JButton button27;
	private JButton button28;
	private JButton button29;
	private JButton button30;
	private JButton button31;
	private JButton button32;
	private JButton button33;
	private JButton button34;
	private JButton button35;
	private JButton button36;
	private JButton button37;
	private JButton button38;
	private JButton button39;
	private JButton button40;
	private JButton button41;
	private JButton button42;
	private JButton button43;
	private JButton button44;
	private JButton button45;
	private JButton button46;
	private JButton button47;
	private JButton button48;
	private JButton button49;
	private JButton button50;
	private JButton button51;
	private JButton button52;
	private JButton button53;
	private JButton button54;
	private JButton button55;
	private JButton button56;
	private JButton button57;
	private JButton button58;
	private JButton button59;
	private JButton button60;
	private JButton button61;
	private JButton button62;
	private JButton button63;
	private JButton button64;
	private JButton button65;
	private JButton button66;
	private JButton button67;
	private JButton button68;
	private JButton button69;
	private JButton button70;
	private JButton button71;
	private JButton button72;
	private JButton button73;
	private JButton button74;
	private JButton button75;
	private JButton button76;
	private JButton button77;
	private JButton button78;
	private JButton button79;
	private JButton button80;
	private JButton button81;
	private String[][] field = new String[9][9];
	private int[] mines = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	Random rand = new Random();
	
	public MineSweeper()
	{
		resultLabel = new JLabel("You lost!");
		setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        newGame = new JMenuItem("New Game");
        exit = new JMenuItem("Exit");
        newGame.addActionListener(this);
        exit.addActionListener(this);
        file.add(newGame);
        file.add(exit);
        JMenu help = new JMenu("Help");
        instruction = new JMenuItem("Instruction");
        instruction.addActionListener(this);
        help.add(instruction);
        label = new JLabel("Score: 0");
        resultLabel = new JLabel("You lost!");
        resultLabel.setVisible(false);
        menuBar.add(file);
        menuBar.add(help);
        menuBar.add(label);
        menuBar.add(resultLabel);
        add(menuBar, BorderLayout.NORTH);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(9, 9));
        add(buttonPanel, BorderLayout.CENTER);
        for(int i = 0; i < 13; i++)
        {
        	int newMine = rand.nextInt(81)+1;
        	for(int j = 0; j < 13; j++)
        	{
        		if(newMine == mines[j])
        		{
        			i--;
        			break;
        		}
        		else if(j == 12)
        			mines[i] = newMine;
        	}
        }
        for(int i = 0; i < 12; i++)
        {
            for(int j = 0; j < 12-i; j++)
            {
                if(mines[j] > mines[j+1]) 
                {
                    int temp = mines[j];
                    mines[j] = mines[j+1];
                    mines[j+1] = temp;
                }
            }
        }
        int counter = 0;
        int minesCounter = 0;
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
            	counter++;
            	if(counter == mines[minesCounter])
            	{
            		field[i][j] = "*";
            		minesCounter++;
            		if(minesCounter == 13)
            			minesCounter = 0;
            	}
            	else
            		field[i][j] = "";
            }
        }
        counter = 0;
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
            	counter++;
            	minesCounter = 0;
            	if(field[i][j] != "*")
            	{
	            	if(i == 0)
	            	{
	            		if(j == 0)
	            		{
	            			if(field[i+1][j] == "*")
	            				minesCounter++;
	            			if(field[i][j+1] == "*")
	            				minesCounter++;
	            			if(field[i+1][j+1] == "*")
	            				minesCounter++;
	            		}
	            		else if(j == 8)
	            		{
	            			if(field[i+1][j] == "*")
	            				minesCounter++;
	            			if(field[i][j-1] == "*")
	            				minesCounter++;
	            			if(field[i+1][j-1] == "*")
	            				minesCounter++;
	            		}
	            		else
	            		{
	            			if(field[i+1][j] == "*")
	            				minesCounter++;
	            			if(field[i][j+1] == "*")
	            				minesCounter++;
	            			if(field[i+1][j+1] == "*")
	            				minesCounter++;
	            			if(field[i+1][j-1] == "*")
	            				minesCounter++;
	            			if(field[i][j-1] == "*")
	            				minesCounter++;
	            		}
	            	}
	            	else if(i == 8)
	            	{
	            		if(j == 0)
	            		{
	            			if(field[i][j+1] == "*")
	            				minesCounter++;
	            			if(field[i-1][j] == "*")
	            				minesCounter++;
	            			if(field[i-1][j+1] == "*")
	            				minesCounter++;
	            		}
	            		else if(j == 8)
	            		{
	            			if(field[i][j-1] == "*")
	            				minesCounter++;
	            			if(field[i-1][j] == "*")
	            				minesCounter++;
	            			if(field[i-1][j-1] == "*")
	            				minesCounter++;
	            		}
	            		else
	            		{
	            			if(field[i][j+1] == "*")
	            				minesCounter++;
	            			if(field[i-1][j] == "*")
	            				minesCounter++;
	            			if(field[i-1][j+1] == "*")
	            				minesCounter++;
	            			if(field[i][j-1] == "*")
	            				minesCounter++;
	            			if(field[i-1][j-1] == "*")
	            				minesCounter++;
	            		}
	            	}
	            	else if(j == 0)
	            	{
	            		if(field[i][j+1] == "*")
            				minesCounter++;
	            		if(field[i-1][j] == "*")
            				minesCounter++;
	            		if(field[i+1][j] == "*")
            				minesCounter++;
	            		if(field[i-1][j+1] == "*")
            				minesCounter++;
	            		if(field[i+1][j+1] == "*")
            				minesCounter++;
	            	}
	            	else if(j == 8)
	            	{
	            		if(field[i][j-1] == "*")
            				minesCounter++;
	            		if(field[i-1][j] == "*")
            				minesCounter++;
	            		if(field[i+1][j] == "*")
            				minesCounter++;
	            		if(field[i-1][j-1] == "*")
            				minesCounter++;
	            		if(field[i+1][j-1] == "*")
            				minesCounter++;
	            	}
	            	else
	            	{
	            		if(field[i][j+1] == "*")
            				minesCounter++;
	            		if(field[i][j-1] == "*")
            				minesCounter++;
	            		if(field[i-1][j] == "*")
            				minesCounter++;
	            		if(field[i+1][j] == "*")
            				minesCounter++;
	            		if(field[i-1][j+1] == "*")
            				minesCounter++;
	            		if(field[i+1][j+1] == "*")
            				minesCounter++;
	            		if(field[i-1][j-1] == "*")
            				minesCounter++;
	            		if(field[i+1][j-1] == "*")
            				minesCounter++;
	            	}
	            	field[i][j] = Integer.toString(minesCounter);
            	}
            	if(counter == 1)
            	{
            		button1 = new JButton("");
            		button1.addActionListener(this);
            	    button1.setBorder(new LineBorder(Color.BLACK));
            		button1.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button1);
            	}
            	else if(counter == 2)
            	{
            		button2 = new JButton("");
            		button2.addActionListener(this);
            	    button2.setBorder(new LineBorder(Color.BLACK));
            		button2.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button2);
            	}
            	else if(counter == 3)
            	{
            		button3 = new JButton("");
            		button3.addActionListener(this);
            	    button3.setBorder(new LineBorder(Color.BLACK));
            		button3.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button3);
            	}
            	else if(counter == 4)
            	{
            		button4 = new JButton("");
            		button4.addActionListener(this);
            	    button4.setBorder(new LineBorder(Color.BLACK));
            		button4.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button4);
            	}
            	else if(counter == 5)
            	{
            		button5 = new JButton("");
            		button5.addActionListener(this);
            	    button5.setBorder(new LineBorder(Color.BLACK));
            		button5.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button5);
            	}
            	else if(counter == 6)
            	{
            		button6 = new JButton("");
            		button6.addActionListener(this);
            	    button6.setBorder(new LineBorder(Color.BLACK));
            		button6.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button6);
            	}
            	else if(counter == 7)
            	{
            		button7 = new JButton("");
            		button7.addActionListener(this);
            	    button7.setBorder(new LineBorder(Color.BLACK));
            		button7.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button7);
            	}
            	else if(counter == 8)
            	{
            		button8 = new JButton("");
            		button8.addActionListener(this);
            	    button8.setBorder(new LineBorder(Color.BLACK));
            		button8.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button8);
            	}
            	else if(counter == 9)
            	{
            		button9 = new JButton("");
            		button9.addActionListener(this);
            	    button9.setBorder(new LineBorder(Color.BLACK));
            		button9.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button9);
            	}
            	else if(counter == 10)
            	{
            		button10 = new JButton("");
            		button10.addActionListener(this);
            	    button10.setBorder(new LineBorder(Color.BLACK));
            		button10.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button10);
            	}
            	else if(counter == 11)
            	{
            		button11 = new JButton("");
            		button11.addActionListener(this);
            	    button11.setBorder(new LineBorder(Color.BLACK));
            		button11.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button11);
            	}
            	else if(counter == 12)
            	{
            		button12 = new JButton("");
            		button12.addActionListener(this);
            	    button12.setBorder(new LineBorder(Color.BLACK));
            		button12.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button12);
            	}
            	else if(counter == 13)
            	{
            		button13 = new JButton("");
            		button13.addActionListener(this);
            	    button13.setBorder(new LineBorder(Color.BLACK));
            		button13.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button13);
            	}
            	else if(counter == 14)
            	{
            		button14 = new JButton("");
            		button14.addActionListener(this);
            	    button14.setBorder(new LineBorder(Color.BLACK));
            		button14.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button14);
            	}
            	else if(counter == 15)
            	{
            		button15 = new JButton("");
            		button15.addActionListener(this);
            	    button15.setBorder(new LineBorder(Color.BLACK));
            		button15.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button15);
            	}
            	else if(counter == 16)
            	{
            		button16 = new JButton("");
            		button16.addActionListener(this);
            	    button16.setBorder(new LineBorder(Color.BLACK));
            		button16.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button16);
            	}
            	else if(counter == 17)
            	{
            		button17 = new JButton("");
            		button17.addActionListener(this);
            	    button17.setBorder(new LineBorder(Color.BLACK));
            		button17.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button17);
            	}
            	else if(counter == 18)
            	{
            		button18 = new JButton("");
            		button18.addActionListener(this);
            	    button18.setBorder(new LineBorder(Color.BLACK));
            		button18.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button18);
            	}
            	else if(counter == 19)
            	{
            		button19 = new JButton("");
            		button19.addActionListener(this);
            	    button19.setBorder(new LineBorder(Color.BLACK));
            		button19.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button19);
            	}
            	else if(counter == 20)
            	{
            		button20 = new JButton("");
            		button20.addActionListener(this);
            	    button20.setBorder(new LineBorder(Color.BLACK));
            		button20.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button20);
            	}
            	else if(counter == 21)
            	{
            		button21 = new JButton("");
            		button21.addActionListener(this);
            	    button21.setBorder(new LineBorder(Color.BLACK));
            		button21.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button21);
            	}
            	else if(counter == 22)
            	{
            		button22 = new JButton("");
            		button22.addActionListener(this);
            	    button22.setBorder(new LineBorder(Color.BLACK));
            		button22.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button22);
            	}
            	else if(counter == 23)
            	{
            		button23 = new JButton("");
            		button23.addActionListener(this);
            	    button23.setBorder(new LineBorder(Color.BLACK));
            		button23.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button23);
            	}
            	else if(counter == 24)
            	{
            		button24 = new JButton("");
            		button24.addActionListener(this);
            	    button24.setBorder(new LineBorder(Color.BLACK));
            		button24.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button24);
            	}
            	else if(counter == 25)
            	{
            		button25 = new JButton("");
            		button25.addActionListener(this);
            	    button25.setBorder(new LineBorder(Color.BLACK));
            		button25.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button25);
            	}
            	else if(counter == 26)
            	{
            		button26 = new JButton("");
            		button26.addActionListener(this);
            	    button26.setBorder(new LineBorder(Color.BLACK));
            		button26.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button26);
            	}
            	else if(counter == 27)
            	{
            		button27 = new JButton("");
            		button27.addActionListener(this);
            	    button27.setBorder(new LineBorder(Color.BLACK));
            		button27.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button27);
            	}
            	else if(counter == 28)
            	{
            		button28 = new JButton("");
            		button28.addActionListener(this);
            	    button28.setBorder(new LineBorder(Color.BLACK));
            		button28.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button28);
            	}
            	else if(counter == 29)
            	{
            		button29 = new JButton("");
            		button29.addActionListener(this);
            	    button29.setBorder(new LineBorder(Color.BLACK));
            		button29.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button29);
            	}
            	else if(counter == 30)
            	{
            		button30 = new JButton("");
            		button30.addActionListener(this);
            	    button30.setBorder(new LineBorder(Color.BLACK));
            		button30.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button30);
            	}
            	else if(counter == 31)
            	{
            		button31 = new JButton("");
            		button31.addActionListener(this);
            	    button31.setBorder(new LineBorder(Color.BLACK));
            		button31.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button31);
            	}
            	else if(counter == 32)
            	{
            		button32 = new JButton("");
            		button32.addActionListener(this);
            	    button32.setBorder(new LineBorder(Color.BLACK));
            		button32.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button32);
            	}
            	else if(counter == 33)
            	{
            		button33 = new JButton("");
            		button33.addActionListener(this);
            	    button33.setBorder(new LineBorder(Color.BLACK));
            		button33.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button33);
            	}
            	else if(counter == 34)
            	{
            		button34 = new JButton("");
            		button34.addActionListener(this);
            	    button34.setBorder(new LineBorder(Color.BLACK));
            		button34.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button34);
            	}
            	else if(counter == 35)
            	{
            		button35 = new JButton("");
            		button35.addActionListener(this);
            	    button35.setBorder(new LineBorder(Color.BLACK));
            		button35.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button35);
            	}
            	else if(counter == 36)
            	{
            		button36 = new JButton("");
            		button36.addActionListener(this);
            	    button36.setBorder(new LineBorder(Color.BLACK));
            		button36.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button36);
            	}
            	else if(counter == 37)
            	{
            		button37 = new JButton("");
            		button37.addActionListener(this);
            	    button37.setBorder(new LineBorder(Color.BLACK));
            		button37.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button37);
            	}
            	else if(counter == 38)
            	{
            		button38 = new JButton("");
            		button38.addActionListener(this);
            	    button38.setBorder(new LineBorder(Color.BLACK));
            		button38.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button38);
            	}
            	else if(counter == 39)
            	{
            		button39 = new JButton("");
            		button39.addActionListener(this);
            	    button39.setBorder(new LineBorder(Color.BLACK));
            		button39.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button39);
            	}
            	else if(counter == 40)
            	{
            		button40 = new JButton("");
            		button40.addActionListener(this);
            	    button40.setBorder(new LineBorder(Color.BLACK));
            		button40.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button40);
            	}
            	else if(counter == 41)
            	{
            		button41 = new JButton("");
            		button41.addActionListener(this);
            	    button41.setBorder(new LineBorder(Color.BLACK));
            		button41.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button41);
            	}
            	else if(counter == 42)
            	{
            		button42 = new JButton("");
            		button42.addActionListener(this);
            	    button42.setBorder(new LineBorder(Color.BLACK));
            		button42.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button42);
            	}
            	else if(counter == 43)
            	{
            		button43 = new JButton("");
            		button43.addActionListener(this);
            	    button43.setBorder(new LineBorder(Color.BLACK));
            		button43.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button43);
            	}
            	else if(counter == 44)
            	{
            		button44 = new JButton("");
            		button44.addActionListener(this);
            	    button44.setBorder(new LineBorder(Color.BLACK));
            		button44.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button44);
            	}
            	else if(counter == 45)
            	{
            		button45 = new JButton("");
            		button45.addActionListener(this);
            	    button45.setBorder(new LineBorder(Color.BLACK));
            		button45.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button45);
            	}
            	else if(counter == 46)
            	{
            		button46 = new JButton("");
            		button46.addActionListener(this);
            	    button46.setBorder(new LineBorder(Color.BLACK));
            		button46.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button46);
            	}
            	else if(counter == 47)
            	{
            		button47 = new JButton("");
            		button47.addActionListener(this);
            	    button47.setBorder(new LineBorder(Color.BLACK));
            		button47.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button47);
            	}
            	else if(counter == 48)
            	{
            		button48 = new JButton("");
            		button48.addActionListener(this);
            	    button48.setBorder(new LineBorder(Color.BLACK));
            		button48.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button48);
            	}
            	else if(counter == 49)
            	{
            		button49 = new JButton("");
            		button49.addActionListener(this);
            	    button49.setBorder(new LineBorder(Color.BLACK));
            		button49.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button49);
            	}
            	else if(counter == 50)
            	{
            		button50 = new JButton("");
            		button50.addActionListener(this);
            	    button50.setBorder(new LineBorder(Color.BLACK));
            		button50.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button50);
            	}
            	else if(counter == 51)
            	{
            		button51 = new JButton("");
            		button51.addActionListener(this);
            	    button51.setBorder(new LineBorder(Color.BLACK));
            		button51.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button51);
            	}
            	else if(counter == 52)
            	{
            		button52 = new JButton("");
            		button52.addActionListener(this);
            	    button52.setBorder(new LineBorder(Color.BLACK));
            		button52.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button52);
            	}
            	else if(counter == 53)
            	{
            		button53 = new JButton("");
            		button53.addActionListener(this);
            	    button53.setBorder(new LineBorder(Color.BLACK));
            		button53.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button53);
            	}
            	else if(counter == 54)
            	{
            		button54 = new JButton("");
            		button54.addActionListener(this);
            	    button54.setBorder(new LineBorder(Color.BLACK));
            		button54.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button54);
            	}
            	else if(counter == 55)
            	{
            		button55 = new JButton("");
            		button55.addActionListener(this);
            	    button55.setBorder(new LineBorder(Color.BLACK));
            		button55.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button55);
            	}
            	else if(counter == 56)
            	{
            		button56 = new JButton("");
            		button56.addActionListener(this);
            	    button56.setBorder(new LineBorder(Color.BLACK));
            		button56.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button56);
            	}
            	else if(counter == 57)
            	{
            		button57 = new JButton("");
            		button57.addActionListener(this);
            	    button57.setBorder(new LineBorder(Color.BLACK));
            		button57.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button57);
            	}
            	else if(counter == 58)
            	{
            		button58 = new JButton("");
            		button58.addActionListener(this);
            	    button58.setBorder(new LineBorder(Color.BLACK));
            		button58.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button58);
            	}
            	else if(counter == 59)
            	{
            		button59 = new JButton("");
            		button59.addActionListener(this);
            	    button59.setBorder(new LineBorder(Color.BLACK));
            		button59.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button59);
            	}
            	else if(counter == 60)
            	{
            		button60 = new JButton("");
            		button60.addActionListener(this);
            	    button60.setBorder(new LineBorder(Color.BLACK));
            		button60.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button60);
            	}
            	else if(counter == 61)
            	{
            		button61 = new JButton("");
            		button61.addActionListener(this);
            	    button61.setBorder(new LineBorder(Color.BLACK));
            		button61.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button61);
            	}
            	else if(counter == 62)
            	{
            		button62 = new JButton("");
            		button62.addActionListener(this);
            	    button62.setBorder(new LineBorder(Color.BLACK));
            		button62.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button62);
            	}
            	else if(counter == 63)
            	{
            		button63 = new JButton("");
            		button63.addActionListener(this);
            	    button63.setBorder(new LineBorder(Color.BLACK));
            		button63.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button63);
            	}
            	else if(counter == 64)
            	{
            		button64 = new JButton("");
            		button64.addActionListener(this);
            	    button64.setBorder(new LineBorder(Color.BLACK));
            		button64.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button64);
            	}
            	else if(counter == 65)
            	{
            		button65 = new JButton("");
            		button65.addActionListener(this);
            	    button65.setBorder(new LineBorder(Color.BLACK));
            		button65.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button65);
            	}
            	else if(counter == 66)
            	{
            		button66 = new JButton("");
            		button66.addActionListener(this);
            	    button66.setBorder(new LineBorder(Color.BLACK));
            		button66.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button66);
            	}
            	else if(counter == 67)
            	{
            		button67 = new JButton("");
            		button67.addActionListener(this);
            	    button67.setBorder(new LineBorder(Color.BLACK));
            		button67.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button67);
            	}
            	else if(counter == 68)
            	{
            		button68 = new JButton("");
            		button68.addActionListener(this);
            	    button68.setBorder(new LineBorder(Color.BLACK));
            		button68.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button68);
            	}
            	else if(counter == 69)
            	{
            		button69 = new JButton("");
            		button69.addActionListener(this);
            	    button69.setBorder(new LineBorder(Color.BLACK));
            		button69.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button69);
            	}
            	else if(counter == 70)
            	{
            		button70 = new JButton("");
            		button70.addActionListener(this);
            	    button70.setBorder(new LineBorder(Color.BLACK));
            		button70.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button70);
            	}
            	else if(counter == 71)
            	{
            		button71 = new JButton("");
            		button71.addActionListener(this);
            	    button71.setBorder(new LineBorder(Color.BLACK));
            		button71.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button71);
            	}
            	else if(counter == 72)
            	{
            		button72 = new JButton("");
            		button72.addActionListener(this);
            	    button72.setBorder(new LineBorder(Color.BLACK));
            		button72.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button72);
            	}
            	else if(counter == 73)
            	{
            		button73 = new JButton("");
            		button73.addActionListener(this);
            	    button73.setBorder(new LineBorder(Color.BLACK));
            		button73.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button73);
            	}
            	else if(counter == 74)
            	{
            		button74 = new JButton("");
            		button74.addActionListener(this);
            	    button74.setBorder(new LineBorder(Color.BLACK));
            		button74.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button74);
            	}
            	else if(counter == 75)
            	{
            		button75 = new JButton("");
            		button75.addActionListener(this);
            	    button75.setBorder(new LineBorder(Color.BLACK));
            		button75.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button75);
            	}
            	else if(counter == 76)
            	{
            		button76 = new JButton("");
            		button76.addActionListener(this);
            	    button76.setBorder(new LineBorder(Color.BLACK));
            		button76.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button76);
            	}
            	else if(counter == 77)
            	{
            		button77 = new JButton("");
            		button77.addActionListener(this);
            	    button77.setBorder(new LineBorder(Color.BLACK));
            		button77.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button77);
            	}
            	else if(counter == 78)
            	{
            		button78 = new JButton("");
            		button78.addActionListener(this);
            	    button78.setBorder(new LineBorder(Color.BLACK));
            		button78.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button78);
            	}
            	else if(counter == 79)
            	{
            		button79 = new JButton("");
            		button79.addActionListener(this);
            	    button79.setBorder(new LineBorder(Color.BLACK));
            		button79.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button79);
            	}
            	else if(counter == 80)
            	{
            		button80 = new JButton("");
            		button80.addActionListener(this);
            	    button80.setBorder(new LineBorder(Color.BLACK));
            		button80.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button80);
            	}
            	else if(counter == 81)
            	{
            		button81 = new JButton("");
            		button81.addActionListener(this);
            	    button81.setBorder(new LineBorder(Color.BLACK));
            		button81.setPreferredSize(new Dimension(30, 30));
                    buttonPanel.add(button81);
            	}
            }
        }
	}
	private void disablingAllButtons()
	{
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
		button9.setEnabled(false);
		button10.setEnabled(false);
		button11.setEnabled(false);
		button12.setEnabled(false);
		button13.setEnabled(false);
		button14.setEnabled(false);
		button15.setEnabled(false);
		button16.setEnabled(false);
		button17.setEnabled(false);
		button18.setEnabled(false);
		button19.setEnabled(false);
		button20.setEnabled(false);
		button21.setEnabled(false);
		button22.setEnabled(false);
		button23.setEnabled(false);
		button24.setEnabled(false);
		button25.setEnabled(false);
		button26.setEnabled(false);
		button27.setEnabled(false);
		button28.setEnabled(false);
		button29.setEnabled(false);
		button30.setEnabled(false);
		button31.setEnabled(false);
		button32.setEnabled(false);
		button33.setEnabled(false);
		button34.setEnabled(false);
		button35.setEnabled(false);
		button36.setEnabled(false);
		button37.setEnabled(false);
		button38.setEnabled(false);
		button39.setEnabled(false);
		button40.setEnabled(false);
		button41.setEnabled(false);
		button42.setEnabled(false);
		button43.setEnabled(false);
		button44.setEnabled(false);
		button45.setEnabled(false);
		button46.setEnabled(false);
		button47.setEnabled(false);
		button48.setEnabled(false);
		button49.setEnabled(false);
		button50.setEnabled(false);
		button51.setEnabled(false);
		button52.setEnabled(false);
		button53.setEnabled(false);
		button54.setEnabled(false);
		button55.setEnabled(false);
		button56.setEnabled(false);
		button57.setEnabled(false);
		button58.setEnabled(false);
		button59.setEnabled(false);
		button60.setEnabled(false);
		button61.setEnabled(false);
		button62.setEnabled(false);
		button63.setEnabled(false);
		button64.setEnabled(false);
		button65.setEnabled(false);
		button66.setEnabled(false);
		button67.setEnabled(false);
		button68.setEnabled(false);
		button69.setEnabled(false);
		button70.setEnabled(false);
		button71.setEnabled(false);
		button72.setEnabled(false);
		button73.setEnabled(false);
		button74.setEnabled(false);
		button75.setEnabled(false);
		button76.setEnabled(false);
		button77.setEnabled(false);
		button78.setEnabled(false);
		button79.setEnabled(false);
		button80.setEnabled(false);
		button81.setEnabled(false);
	}
	
	private static void createAndShowUI()
    {
        JFrame frame = new JFrame("Mine Sweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(800,300);
        frame.add(new MineSweeper());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
	
	public static void main(String[] args) 
	{
		createAndShowUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source == newGame)
		{
			createAndShowUI();
		}
		else if(source == exit)
		{
			System.exit(0);
		}
		else if(source == instruction)
		{
			System.out.println("In order to win, you need to achieve the score of 66.");
			System.out.println("After clicking any button, you will see if there was a mine or was it neutral.");
			System.out.println("The numbers indicate how many mines are touching the button.");
			System.out.println("If you click a button where is mine (*), you lose.");
			System.out.println("There are 13 mines to avoid");
		}
		else if(source == button1)
		{
			if("*".equals(field[0][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button1.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][0]))
			{
				button1.setText("");
				button2.doClick();
				button10.doClick();
				button11.doClick();
			}
			else
				button1.setText(field[0][0]);
		}
		else if(source == button2)
		{
			if("*".equals(field[0][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button2.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][1]))
			{
				button2.setText("");
				button1.doClick();
				button3.doClick();
				button10.doClick();
				button11.doClick();
				button12.doClick();
			}
			else
				button2.setText(field[0][1]);
		}
		else if(source == button3)
		{
			if("*".equals(field[0][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button3.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][2]))
			{
				button3.setText("");
				button2.doClick();
				button4.doClick();
				button11.doClick();
				button12.doClick();
				button13.doClick();
			}
			else
				button3.setText(field[0][2]);
		}
		else if(source == button4)
		{
			if("*".equals(field[0][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button4.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][3]))
			{
				button4.setText("");
				button3.doClick();
				button5.doClick();
				button12.doClick();
				button13.doClick();
				button14.doClick();
			}
			else
				button4.setText(field[0][3]);
		}
		else if(source == button5)
		{
			if("*".equals(field[0][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button5.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][4]))
			{
				button5.setText("");
				button4.doClick();
				button6.doClick();
				button13.doClick();
				button14.doClick();
				button15.doClick();
			}
			else
				button5.setText(field[0][4]);
		}
		else if(source == button6)
		{
			if("*".equals(field[0][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button6.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][5]))
			{
				button6.setText("");
				button5.doClick();
				button7.doClick();
				button14.doClick();
				button15.doClick();
				button16.doClick();
			}
			else
				button6.setText(field[0][5]);
		}
		else if(source == button7)
		{
			if("*".equals(field[0][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button7.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][6]))
			{
				button7.setText("");
				button6.doClick();
				button8.doClick();
				button15.doClick();
				button16.doClick();
				button17.doClick();
			}
			else
				button7.setText(field[0][6]);
		}
		else if(source == button8)
		{
			if("*".equals(field[0][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button8.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][7]))
			{
				button8.setText("");
				button7.doClick();
				button9.doClick();
				button16.doClick();
				button17.doClick();
				button18.doClick();
			}
			else
				button8.setText(field[0][7]);
		}
		else if(source == button9)
		{
			if("*".equals(field[0][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button9.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[0][8]))
			{
				button9.setText("");
				button8.doClick();
				button17.doClick();
				button18.doClick();
			}
			else
				button9.setText(field[0][8]);
		}
		else if(source == button10)
		{
			if("*".equals(field[1][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button10.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][0]))
			{
				button10.setText("");
				button1.doClick();
				button2.doClick();
				button11.doClick();
				button19.doClick();
				button20.doClick();
			}
			else
				button10.setText(field[1][0]);
		}
		else if(source == button11)
		{
			if("*".equals(field[1][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button11.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][1]))
			{
				button11.setText("");
				button1.doClick();
				button2.doClick();
				button3.doClick();
				button10.doClick();
				button12.doClick();
				button19.doClick();
				button20.doClick();
				button21.doClick();
			}
			else
				button11.setText(field[1][1]);
		}
		else if(source == button12)
		{
			if("*".equals(field[1][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button12.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][2]))
			{
				button12.setText("");
				button2.doClick();
				button3.doClick();
				button4.doClick();
				button11.doClick();
				button13.doClick();
				button20.doClick();
				button21.doClick();
				button22.doClick();
			}
			else
				button12.setText(field[1][2]);
		}
		else if(source == button13)
		{
			if("*".equals(field[1][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button13.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][3]))
			{
				button13.setText("");
				button3.doClick();
				button4.doClick();
				button5.doClick();
				button12.doClick();
				button14.doClick();
				button21.doClick();
				button22.doClick();
				button23.doClick();
			}
			else
				button13.setText(field[1][3]);
		}
		else if(source == button14)
		{
			if("*".equals(field[1][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button14.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][4]))
			{
				button14.setText("");
				button4.doClick();
				button5.doClick();
				button6.doClick();
				button13.doClick();
				button15.doClick();
				button22.doClick();
				button23.doClick();
				button24.doClick();
			}
			else
				button14.setText(field[1][4]);
		}
		else if(source == button15)
		{
			if("*".equals(field[1][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button15.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][5]))
			{
				button15.setText("");
				button5.doClick();
				button6.doClick();
				button7.doClick();
				button14.doClick();
				button16.doClick();
				button23.doClick();
				button24.doClick();
				button25.doClick();
			}
			else
				button15.setText(field[1][5]);
		}
		else if(source == button16)
		{
			if("*".equals(field[1][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button16.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][6]))
			{
				button16.setText("");
				button6.doClick();
				button7.doClick();
				button8.doClick();
				button15.doClick();
				button17.doClick();
				button24.doClick();
				button25.doClick();
				button26.doClick();
			}
			else
				button16.setText(field[1][6]);
		}
		else if(source == button17)
		{
			if("*".equals(field[1][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button17.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][7]))
			{
				button17.setText("");
				button7.doClick();
				button8.doClick();
				button9.doClick();
				button16.doClick();
				button18.doClick();
				button25.doClick();
				button26.doClick();
				button27.doClick();
			}
			else
				button17.setText(field[1][7]);
		}
		else if(source == button18)
		{
			if("*".equals(field[1][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button18.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[1][8]))
			{
				button18.setText("");
				button8.doClick();
				button9.doClick();
				button17.doClick();
				button26.doClick();
				button27.doClick();
			}
			else
				button18.setText(field[1][8]);
		}
		else if(source == button19)
		{
			if("*".equals(field[2][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button19.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][0]))
			{
				button19.setText("");
				button10.doClick();
				button11.doClick();
				button20.doClick();
				button28.doClick();
				button29.doClick();
			}
			else
				button19.setText(field[2][0]);
		}
		else if(source == button20)
		{
			if("*".equals(field[2][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button20.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][1]))
			{
				button20.setText("");
				button10.doClick();
				button11.doClick();
				button12.doClick();
				button19.doClick();
				button21.doClick();
				button28.doClick();
				button29.doClick();
				button30.doClick();
			}
			else
				button20.setText(field[2][1]);
		}
		else if(source == button21)
		{
			if("*".equals(field[2][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button21.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][2]))
			{
				button21.setText("");
				button11.doClick();
				button12.doClick();
				button13.doClick();
				button20.doClick();
				button22.doClick();
				button29.doClick();
				button30.doClick();
				button31.doClick();
			}
			else
				button21.setText(field[2][2]);
		}
		else if(source == button22)
		{
			if("*".equals(field[2][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button22.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][3]))
			{
				button22.setText("");
				button12.doClick();
				button13.doClick();
				button14.doClick();
				button21.doClick();
				button23.doClick();
				button30.doClick();
				button31.doClick();
				button32.doClick();
			}
			else
				button22.setText(field[2][3]);
		}
		else if(source == button23)
		{
			if("*".equals(field[2][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button23.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][4]))
			{
				button23.setText("");
				button13.doClick();
				button14.doClick();
				button15.doClick();
				button22.doClick();
				button24.doClick();
				button31.doClick();
				button32.doClick();
				button33.doClick();
			}
			else
				button23.setText(field[2][4]);
		}
		else if(source == button24)
		{
			if("*".equals(field[2][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button24.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][5]))
			{
				button24.setText("");
				button14.doClick();
				button15.doClick();
				button16.doClick();
				button23.doClick();
				button25.doClick();
				button32.doClick();
				button33.doClick();
				button34.doClick();
			}
			else
				button24.setText(field[2][5]);
		}
		else if(source == button25)
		{
			if("*".equals(field[2][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button25.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][6]))
			{
				button25.setText("");
				button15.doClick();
				button16.doClick();
				button17.doClick();
				button24.doClick();
				button26.doClick();
				button33.doClick();
				button34.doClick();
				button35.doClick();
			}
			else
				button25.setText(field[2][6]);
		}
		else if(source == button26)
		{
			if("*".equals(field[2][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button26.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][7]))
			{
				button26.setText("");
				button16.doClick();
				button17.doClick();
				button18.doClick();
				button25.doClick();
				button27.doClick();
				button34.doClick();
				button35.doClick();
				button36.doClick();
			}
			else
				button26.setText(field[2][7]);
		}
		else if(source == button27)
		{
			if("*".equals(field[2][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button27.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[2][8]))
			{
				button27.setText("");
				button17.doClick();
				button18.doClick();
				button26.doClick();
				button35.doClick();
				button36.doClick();
			}
			else
				button27.setText(field[2][8]);
		}
		else if(source == button28)
		{
			if("*".equals(field[3][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button28.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][0]))
			{
				button28.setText("");
				button19.doClick();
				button20.doClick();
				button29.doClick();
				button37.doClick();
				button38.doClick();
			}
			else
				button28.setText(field[3][0]);
		}
		else if(source == button29)
		{
			if("*".equals(field[3][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button29.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][1]))
			{
				button29.setText("");
				button19.doClick();
				button20.doClick();
				button21.doClick();
				button28.doClick();
				button30.doClick();
				button37.doClick();
				button38.doClick();
				button39.doClick();
			}
			else
				button29.setText(field[3][1]);
		}
		else if(source == button30)
		{
			if("*".equals(field[3][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button30.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][2]))
			{
				button30.setText("");
				button20.doClick();
				button21.doClick();
				button22.doClick();
				button29.doClick();
				button31.doClick();
				button38.doClick();
				button39.doClick();
				button40.doClick();
			}
			else
				button30.setText(field[3][2]);
		}
		else if(source == button31)
		{
			if("*".equals(field[3][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button31.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][3]))
			{
				button31.setText("");
				button21.doClick();
				button22.doClick();
				button23.doClick();
				button30.doClick();
				button32.doClick();
				button39.doClick();
				button40.doClick();
				button41.doClick();
			}
			else
				button31.setText(field[3][3]);
		}
		else if(source == button32)
		{
			if("*".equals(field[3][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button32.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][4]))
			{
				button32.setText("");
				button22.doClick();
				button23.doClick();
				button24.doClick();
				button31.doClick();
				button33.doClick();
				button40.doClick();
				button41.doClick();
				button42.doClick();
			}
			else
				button32.setText(field[3][4]);
		}
		else if(source == button33)
		{
			if("*".equals(field[3][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button33.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][5]))
			{
				button33.setText("");
				button23.doClick();
				button24.doClick();
				button25.doClick();
				button32.doClick();
				button34.doClick();
				button41.doClick();
				button42.doClick();
				button43.doClick();
			}
			else
				button33.setText(field[3][5]);
		}
		else if(source == button34)
		{
			if("*".equals(field[3][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button34.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][6]))
			{
				button34.setText("");
				button24.doClick();
				button25.doClick();
				button26.doClick();
				button33.doClick();
				button35.doClick();
				button42.doClick();
				button43.doClick();
				button44.doClick();
			}
			else
				button34.setText(field[3][6]);
		}
		else if(source == button35)
		{
			if("*".equals(field[3][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button35.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][7]))
			{
				button35.setText("");
				button25.doClick();
				button26.doClick();
				button27.doClick();
				button34.doClick();
				button36.doClick();
				button43.doClick();
				button44.doClick();
				button45.doClick();
			}
			else
				button35.setText(field[3][7]);
		}
		else if(source == button36)
		{
			if("*".equals(field[3][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button36.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[3][8]))
			{
				button36.setText("");
				button26.doClick();
				button27.doClick();
				button35.doClick();
				button44.doClick();
				button45.doClick();
			}
			else
				button36.setText(field[3][8]);
		}
		else if(source == button37)
		{
			if("*".equals(field[4][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button37.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][0]))
			{
				button37.setText("");
				button28.doClick();
				button29.doClick();
				button38.doClick();
				button46.doClick();
				button47.doClick();
			}
			else
				button37.setText(field[4][0]);
		}
		else if(source == button38)
		{
			if("*".equals(field[4][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button38.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][1]))
			{
				button38.setText("");
				button28.doClick();
				button29.doClick();
				button30.doClick();
				button37.doClick();
				button39.doClick();
				button46.doClick();
				button47.doClick();
				button48.doClick();
			}
			else
				button38.setText(field[4][1]);
		}
		else if(source == button39)
		{
			if("*".equals(field[4][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button39.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][2]))
			{
				button39.setText("");
				button29.doClick();
				button30.doClick();
				button31.doClick();
				button38.doClick();
				button40.doClick();
				button47.doClick();
				button48.doClick();
				button49.doClick();
			}
			else
				button39.setText(field[4][2]);
		}
		else if(source == button40)
		{
			if("*".equals(field[4][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button40.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][3]))
			{
				button40.setText("");
				button30.doClick();
				button31.doClick();
				button32.doClick();
				button39.doClick();
				button41.doClick();
				button48.doClick();
				button49.doClick();
				button50.doClick();
			}
			else
				button40.setText(field[4][3]);
		}
		else if(source == button41)
		{
			if("*".equals(field[4][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button41.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][4]))
			{
				button41.setText("");
				button31.doClick();
				button32.doClick();
				button33.doClick();
				button40.doClick();
				button42.doClick();
				button49.doClick();
				button50.doClick();
				button51.doClick();
			}
			else
				button41.setText(field[4][4]);
		}
		else if(source == button42)
		{
			if("*".equals(field[4][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button42.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][5]))
			{
				button42.setText("");
				button32.doClick();
				button33.doClick();
				button34.doClick();
				button41.doClick();
				button43.doClick();
				button50.doClick();
				button51.doClick();
				button52.doClick();
			}
			else
				button42.setText(field[4][5]);
		}
		else if(source == button43)
		{
			if("*".equals(field[4][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button43.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][6]))
			{
				button43.setText("");
				button33.doClick();
				button34.doClick();
				button35.doClick();
				button42.doClick();
				button44.doClick();
				button51.doClick();
				button52.doClick();
				button53.doClick();
			}
			else
				button43.setText(field[4][6]);
		}
		else if(source == button44)
		{
			if("*".equals(field[4][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button44.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][7]))
			{
				button44.setText("");
				button34.doClick();
				button35.doClick();
				button36.doClick();
				button43.doClick();
				button45.doClick();
				button52.doClick();
				button53.doClick();
				button54.doClick();
			}
			else
				button44.setText(field[4][7]);
		}
		else if(source == button45)
		{
			if("*".equals(field[4][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button45.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[4][8]))
			{
				button45.setText("");
				button35.doClick();
				button36.doClick();
				button44.doClick();
				button53.doClick();
				button54.doClick();
			}
			else
				button45.setText(field[4][8]);
		}
		else if(source == button46)
		{
			if("*".equals(field[5][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button46.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][0]))
			{
				button46.setText("");
				button37.doClick();
				button38.doClick();
				button47.doClick();
				button55.doClick();
				button56.doClick();
			}
			else
				button46.setText(field[5][0]);
		}
		else if(source == button47)
		{
			if("*".equals(field[5][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button47.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][1]))
			{
				button47.setText("");
				button37.doClick();
				button38.doClick();
				button39.doClick();
				button46.doClick();
				button48.doClick();
				button55.doClick();
				button56.doClick();
				button57.doClick();
			}
			else
				button47.setText(field[5][1]);
		}
		else if(source == button48)
		{
			if("*".equals(field[5][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button48.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][2]))
			{
				button48.setText("");
				button38.doClick();
				button39.doClick();
				button40.doClick();
				button47.doClick();
				button49.doClick();
				button56.doClick();
				button57.doClick();
				button58.doClick();
			}
			else
				button48.setText(field[5][2]);
		}
		else if(source == button49)
		{
			if("*".equals(field[5][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button49.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][3]))
			{
				button49.setText("");
				button39.doClick();
				button40.doClick();
				button41.doClick();
				button48.doClick();
				button50.doClick();
				button57.doClick();
				button58.doClick();
				button59.doClick();
			}
			else
				button49.setText(field[5][3]);
		}
		else if(source == button50)
		{
			if("*".equals(field[5][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button50.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][4]))
			{
				button50.setText("");
				button40.doClick();
				button41.doClick();
				button42.doClick();
				button49.doClick();
				button51.doClick();
				button58.doClick();
				button59.doClick();
				button60.doClick();
			}
			else
				button50.setText(field[5][4]);
		}
		else if(source == button51)
		{
			if("*".equals(field[5][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button51.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][5]))
			{
				button51.setText("");
				button41.doClick();
				button42.doClick();
				button43.doClick();
				button50.doClick();
				button52.doClick();
				button59.doClick();
				button60.doClick();
				button61.doClick();
			}
			else
				button51.setText(field[5][5]);
		}
		else if(source == button52)
		{
			if("*".equals(field[5][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button52.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][6]))
			{
				button52.setText("");
				button42.doClick();
				button43.doClick();
				button44.doClick();
				button51.doClick();
				button53.doClick();
				button60.doClick();
				button61.doClick();
				button62.doClick();
			}
			else
				button52.setText(field[5][6]);
		}
		else if(source == button53)
		{
			if("*".equals(field[5][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button53.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][7]))
			{
				button53.setText("");
				button43.doClick();
				button44.doClick();
				button45.doClick();
				button52.doClick();
				button54.doClick();
				button61.doClick();
				button62.doClick();
				button63.doClick();
			}
			else
				button53.setText(field[5][7]);
		}
		else if(source == button54)
		{
			if("*".equals(field[5][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button54.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[5][8]))
			{
				button54.setText("");
				button44.doClick();
				button45.doClick();
				button53.doClick();
				button62.doClick();
				button63.doClick();
			}
			else
				button54.setText(field[5][8]);
		}
		else if(source == button55)
		{
			if("*".equals(field[6][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button55.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][0]))
			{
				button55.setText("");
				button46.doClick();
				button47.doClick();
				button56.doClick();
				button64.doClick();
				button65.doClick();
			}
			else
				button55.setText(field[6][0]);
		}
		else if(source == button56)
		{
			if("*".equals(field[6][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button56.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][1]))
			{
				button56.setText("");
				button46.doClick();
				button47.doClick();
				button48.doClick();
				button55.doClick();
				button57.doClick();
				button64.doClick();
				button65.doClick();
				button66.doClick();
			}
			else
				button56.setText(field[6][1]);
		}
		else if(source == button57)
		{
			if("*".equals(field[6][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button57.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][2]))
			{
				button57.setText("");
				button47.doClick();
				button48.doClick();
				button49.doClick();
				button56.doClick();
				button58.doClick();
				button65.doClick();
				button66.doClick();
				button67.doClick();
			}
			else
				button57.setText(field[6][2]);
		}
		else if(source == button58)
		{
			if("*".equals(field[6][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button58.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][3]))
			{
				button58.setText("");
				button48.doClick();
				button49.doClick();
				button50.doClick();
				button57.doClick();
				button59.doClick();
				button66.doClick();
				button67.doClick();
				button68.doClick();
			}
			else
				button58.setText(field[6][3]);
		}
		else if(source == button59)
		{
			if("*".equals(field[6][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button59.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][4]))
			{
				button59.setText("");
				button49.doClick();
				button50.doClick();
				button51.doClick();
				button58.doClick();
				button60.doClick();
				button67.doClick();
				button68.doClick();
				button69.doClick();
			}
			else
				button59.setText(field[6][4]);
		}
		else if(source == button60)
		{
			if("*".equals(field[6][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button60.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][5]))
			{
				button60.setText("");
				button50.doClick();
				button51.doClick();
				button52.doClick();
				button59.doClick();
				button61.doClick();
				button68.doClick();
				button69.doClick();
				button70.doClick();
			}
			else
				button60.setText(field[6][5]);
		}
		else if(source == button61)
		{
			if("*".equals(field[6][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button61.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][6]))
			{
				button61.setText("");
				button51.doClick();
				button52.doClick();
				button53.doClick();
				button60.doClick();
				button62.doClick();
				button69.doClick();
				button70.doClick();
				button71.doClick();
			}
			else
				button61.setText(field[6][6]);
		}
		else if(source == button62)
		{
			if("*".equals(field[6][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button62.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][7]))
			{
				button62.setText("");
				button52.doClick();
				button53.doClick();
				button54.doClick();
				button61.doClick();
				button63.doClick();
				button70.doClick();
				button71.doClick();
				button72.doClick();
			}
			else
				button62.setText(field[6][7]);
		}
		else if(source == button63)
		{
			if("*".equals(field[6][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button63.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[6][8]))
			{
				button63.setText("");
				button53.doClick();
				button54.doClick();
				button62.doClick();
				button71.doClick();
				button72.doClick();
			}
			else
				button63.setText(field[6][8]);
		}
		else if(source == button64)
		{
			if("*".equals(field[7][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button64.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][0]))
			{
				button64.setText("");
				button55.doClick();
				button56.doClick();
				button65.doClick();
				button73.doClick();
				button74.doClick();
			}
			else
				button64.setText(field[7][0]);
		}
		else if(source == button65)
		{
			if("*".equals(field[7][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button65.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][1]))
			{
				button65.setText("");
				button55.doClick();
				button56.doClick();
				button57.doClick();
				button64.doClick();
				button66.doClick();
				button73.doClick();
				button74.doClick();
				button75.doClick();
			}
			else
				button65.setText(field[7][1]);
		}
		else if(source == button66)
		{
			if("*".equals(field[7][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button66.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][2]))
			{
				button66.setText("");
				button56.doClick();
				button57.doClick();
				button58.doClick();
				button65.doClick();
				button67.doClick();
				button74.doClick();
				button75.doClick();
				button76.doClick();
			}
			else
				button66.setText(field[7][2]);
		}
		else if(source == button67)
		{
			if("*".equals(field[7][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button67.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][3]))
			{
				button67.setText("");
				button57.doClick();
				button58.doClick();
				button59.doClick();
				button66.doClick();
				button68.doClick();
				button75.doClick();
				button76.doClick();
				button77.doClick();
			}
			else
				button67.setText(field[7][3]);
		}
		else if(source == button68)
		{
			if("*".equals(field[7][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button68.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][4]))
			{
				button68.setText("");
				button58.doClick();
				button59.doClick();
				button60.doClick();
				button67.doClick();
				button69.doClick();
				button76.doClick();
				button77.doClick();
				button78.doClick();
			}
			else
				button68.setText(field[7][4]);
		}
		else if(source == button69)
		{
			if("*".equals(field[7][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button69.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][5]))
			{
				button69.setText("");
				button59.doClick();
				button60.doClick();
				button61.doClick();
				button68.doClick();
				button70.doClick();
				button77.doClick();
				button78.doClick();
				button79.doClick();
			}
			else
				button69.setText(field[7][5]);
		}
		else if(source == button70)
		{
			if("*".equals(field[7][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button70.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][6]))
			{
				button70.setText("");
				button60.doClick();
				button61.doClick();
				button62.doClick();
				button69.doClick();
				button71.doClick();
				button78.doClick();
				button79.doClick();
				button80.doClick();
			}
			else
				button70.setText(field[7][6]);
		}
		else if(source == button71)
		{
			if("*".equals(field[7][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button71.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][7]))
			{
				button71.setText("");
				button61.doClick();
				button62.doClick();
				button63.doClick();
				button70.doClick();
				button72.doClick();
				button79.doClick();
				button80.doClick();
				button81.doClick();
			}
			else
				button71.setText(field[7][7]);
		}
		else if(source == button72)
		{
			if("*".equals(field[7][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button72.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[7][8]))
			{
				button72.setText("");
				button62.doClick();
				button63.doClick();
				button71.doClick();
				button80.doClick();
				button81.doClick();
			}
			else
				button72.setText(field[7][8]);
		}
		else if(source == button73)
		{
			if("*".equals(field[8][0]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button73.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][0]))
			{
				button73.setText("");
				button64.doClick();
				button65.doClick();
				button74.doClick();
			}
			else
				button73.setText(field[8][0]);
		}
		else if(source == button74)
		{
			if("*".equals(field[8][1]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button74.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][1]))
			{
				button74.setText("");
				button64.doClick();
				button65.doClick();
				button66.doClick();
				button73.doClick();
				button75.doClick();
			}
			else
				button74.setText(field[8][1]);
		}
		else if(source == button75)
		{
			if("*".equals(field[8][2]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button75.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][2]))
			{
				button75.setText("");
				button65.doClick();
				button66.doClick();
				button67.doClick();
				button74.doClick();
				button76.doClick();
			}
			else
				button75.setText(field[8][2]);
		}
		else if(source == button76)
		{
			if("*".equals(field[8][3]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button76.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][3]))
			{
				button76.setText("");
				button66.doClick();
				button67.doClick();
				button68.doClick();
				button75.doClick();
				button77.doClick();
			}
			else
				button76.setText(field[8][3]);
		}
		else if(source == button77)
		{
			if("*".equals(field[8][4]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button77.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][4]))
			{
				button77.setText("");
				button67.doClick();
				button68.doClick();
				button69.doClick();
				button76.doClick();
				button78.doClick();
			}
			else
				button77.setText(field[8][4]);
		}
		else if(source == button78)
		{
			if("*".equals(field[8][5]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button78.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][5]))
			{
				button78.setText("");
				button68.doClick();
				button69.doClick();
				button70.doClick();
				button77.doClick();
				button79.doClick();
			}
			else
				button78.setText(field[8][5]);
		}
		else if(source == button79)
		{
			if("*".equals(field[8][6]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button79.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][6]))
			{
				button79.setText("");
				button69.doClick();
				button70.doClick();
				button71.doClick();
				button78.doClick();
				button80.doClick();
			}
			else
				button79.setText(field[8][6]);
		}
		else if(source == button80)
		{
			if("*".equals(field[8][7]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button80.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][7]))
			{
				button80.setText("");
				button70.doClick();
				button71.doClick();
				button72.doClick();
				button79.doClick();
				button81.doClick();
			}
			else
				button80.setText(field[8][7]);
		}
		else if(source == button81)
		{
			if("*".equals(field[8][8]))
			{
				resultLabel.setVisible(true);
				disablingAllButtons();
			}
			button81.setEnabled(false);
			scoreCounter++;
			if("0".equals(field[8][8]))
			{
				button81.setText("");
				button71.doClick();
				button72.doClick();
				button80.doClick();
			}
			else
				button81.setText(field[8][8]);
		}
		if(scoreCounter == 68)
		{
			resultLabel.setText("You won!");
			resultLabel.setVisible(true);
			disablingAllButtons();
		}
		label.setText("Score: "+ scoreCounter);
	}
}
