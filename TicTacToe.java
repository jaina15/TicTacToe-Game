package pk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.LinkedBlockingDeque;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class TicTacToe implements ActionListener {

	JPanel p = new JPanel(null);
	int cnt=0;
	String letter="";
	//int flag =0;
	//int ans=0;
	public String plbl;
	public boolean win=false;
	//String[] a=new String[10];
	JButton btn[];
	JLabel lbl,anslbl,result;
	JFrame frame = new JFrame("Tic-Tac-Toe");

	/**
	 * Create the frame.
	 */
	public TicTacToe() {
		//frame.setContentPane(new JLabel(new ImageIcon("img/wooden.jpg")));
		frame.getContentPane().setBackground(new Color(128, 128, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 373, 488);
		frame.setBackground(Color.WHITE);
		//frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		// this label will tell the turn of the players
		
		lbl = new JLabel("Player 1 turn");
		lbl.setForeground(new Color(0, 255, 255));
		lbl.setFont(new Font("Franklin Gothic Book", Font.BOLD | Font.ITALIC, 24));
		lbl.setBounds(23, 49, 306, 45);
		frame.getContentPane().add(lbl);
		
		// result label will equate the answer label
		
		result = new JLabel("Result : -");
		result.setFont(new Font("Arial Black", Font.BOLD, 18));
		result.setForeground(Color.GREEN);
		result.setBounds(23, 337, 97, 38);
		frame.getContentPane().add(result);
		
		
		// answer label where the result of the game will be displayed
		
		anslbl = new JLabel("");
		anslbl.setForeground(new Color(255, 255, 51));
		anslbl.setFont(new Font("Arial Black", Font.BOLD, 18));
		anslbl.setBounds(132, 337, 206, 38);
		frame.getContentPane().add(anslbl);
		
		// initializing 9 boxes 
		
		btn = new JButton[9];
		for(int i=0;i<9;i++){
			btn[i]=new JButton("");
			btn[i].setBackground(new Color(238, 232, 170));
			btn[i].setForeground(Color.BLACK);
			btn[i].setFont(new Font("Franklin Gothic Book", Font.BOLD, 34));
			btn[i].addActionListener(this);
			frame.getContentPane().add(btn[i]);
		}
		frame.setVisible(true);
		
		// box positioning
		
		btn[0].setBounds(36, 92, 97, 68);
		btn[1].setBounds(132, 92, 97, 68);
		btn[2].setBounds(228, 92, 97, 68);
		btn[3].setBounds(36, 160, 97, 68);
		btn[4].setBounds(132, 160, 97, 68);
		btn[5].setBounds(228, 160, 97, 68);
		btn[6].setBounds(36, 228, 97, 68);
		btn[7].setBounds(132, 228, 97, 68);
		btn[8].setBounds(228, 228, 97, 68);
		
		
		// reset or restart button to clear all the boxes and labels
		
		JButton rstbtn = new JButton("RESTART");
		rstbtn.setBackground(new Color(255, 0, 0));
		rstbtn.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		rstbtn.setForeground(new Color(255, 255, 0));
		rstbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<9;i++){
					btn[i].setEnabled(true);
					btn[i].setText("");
					btn[i].setBackground(new Color(238, 232, 170));
				}
				lbl.setText("Player 1 turn");
				anslbl.setText("");
				cnt=0;
			}
		});
		rstbtn.setBounds(228, 390, 110, 38);
		frame.getContentPane().add(rstbtn);
		
		JLabel lblPlayer = new JLabel("Player 1 = X             Player 2 = O");
		lblPlayer.setFont(new Font("Franklin Gothic Book", Font.BOLD | Font.ITALIC, 18));
		lblPlayer.setForeground(new Color(255, 0, 255));
		lblPlayer.setBounds(23, 13, 306, 38);
		frame.getContentPane().add(lblPlayer);
	
	}
	
	// action performed on clicking the boxes
	
	public void actionPerformed(ActionEvent e) {
		cnt++;
		if(cnt%2==1){
			letter="X";
			lbl.setText("Player 2 turn");
		}
		else{
			letter="O";
			lbl.setText("Player 1 turn");
		}
		
		Object click = e.getSource();
		for(int i=0;i<9;i++){
			if(click==btn[i]){
				btn[i].setText(letter);
				btn[i].setEnabled(false);
				break;
			}
		}
		
		//checking for horizontal wins
		
		if(btn[0].getText()==btn[1].getText() &&btn[1].getText()==btn[2].getText() && btn[0].getText()!=""){
			win=true;
			btn[0].setBackground(new Color(0, 255, 0));
			btn[1].setBackground(new Color(0, 255, 0));
			btn[2].setBackground(new Color(0, 255, 0));
			}
		else if(btn[3].getText() == btn[4].getText() && btn[4].getText() == btn[5].getText() && btn[3].getText() != ""){
			win = true;
			btn[5].setBackground(new Color(0, 255, 0));
			btn[4].setBackground(new Color(0, 255, 0));
			btn[3].setBackground(new Color(0, 255, 0));
			}
		else if(btn[6].getText() == btn[7].getText() && btn[7].getText() == btn[8].getText() && btn[6].getText() != ""){
			win = true;
			btn[6].setBackground(new Color(0, 255, 0));
			btn[7].setBackground(new Color(0, 255, 0));
			btn[8].setBackground(new Color(0, 255, 0));
			}
		
		//checking for vertical wins
		
		else if(btn[0].getText() == btn[3].getText() && btn[3].getText() == btn[6].getText() && btn[0].getText() != ""){
			win = true;
			btn[0].setBackground(new Color(0, 255, 0));
			btn[3].setBackground(new Color(0, 255, 0));
			btn[6].setBackground(new Color(0, 255, 0));
			}
		else if(btn[1].getText() == btn[4].getText() && btn[4].getText() == btn[7].getText() && btn[1].getText() != ""){
			win = true;
			btn[7].setBackground(new Color(0, 255, 0));
			btn[1].setBackground(new Color(0, 255, 0));
			btn[4].setBackground(new Color(0, 255, 0));
			}
		else if(btn[2].getText() == btn[5].getText() && btn[5].getText() == btn[8].getText() && btn[2].getText() != ""){
			win = true;
			btn[8].setBackground(new Color(0, 255, 0));
			btn[5].setBackground(new Color(0, 255, 0));
			btn[2].setBackground(new Color(0, 255, 0));
			}
		
		//checking for diagonal wins
		
		else if(btn[0].getText() == btn[4].getText() && btn[4].getText() == btn[8].getText() && btn[0].getText() != ""){
			win = true;
			btn[0].setBackground(new Color(0, 255, 0));
			btn[4].setBackground(new Color(0, 255, 0));
			btn[8].setBackground(new Color(0, 255, 0));
			}
		else if(btn[2].getText() == btn[4].getText() && btn[4].getText() == btn[6].getText() && btn[2].getText() != ""){
			win = true;
			btn[4].setBackground(new Color(0, 255, 0));
			btn[6].setBackground(new Color(0, 255, 0));
			btn[2].setBackground(new Color(0, 255, 0));
			}
		else {
			win = false;
			}
			
		// will tell which player wins or is it a tie
		
		if(win == true){
			
				whoWins();
				
				} 
		else if(cnt == 9 && win == false){
			
				tie();
			
			}
		}
		
		// method for tie
	
		public void tie(){
				anslbl.setText("Its a TIE");
				for(int i=0;i<9;i++){
					btn[i].setEnabled(false);
					btn[i].setBackground(new Color(255, 0, 0));
				}
			}
	
		// method for wins
		
		public void whoWins(){
				if(letter.equals("X"))
					anslbl.setText("\" Player 1 WINS \"");
				else if(letter.equals("O"))
					anslbl.setText("\" Player 2 WINS \"");
				for(int i=0;i<9;i++)
					btn[i].setEnabled(false);
			}
			
	// main method to make the whole game run
		
	public static void main(String[] args) {
		new TicTacToe();
	}
}
