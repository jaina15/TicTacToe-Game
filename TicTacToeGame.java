package pk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame implements ActionListener{
	
	JFrame frame = new JFrame("Tic-Tac-Toe");
	JButton btn[];
	JPanel p = new JPanel(null);
	String letter="";
	public int cnt=0;
	public boolean win=false;
	
	public TicTacToeGame(){
		btn = new JButton[9];
		frame.setSize(300, 300);
		frame.setBounds(300, 350, 300, 350);
		frame.setResizable(false);
		frame.setLayout(new GridLayout(3, 3));
		frame.setLocationRelativeTo(null);
				
		for(int i=0;i<9;i++){
			btn[i]=new JButton("");
			btn[i].setBackground(new Color(238, 232, 170));
			btn[i].setFont(new Font("Tahoma", Font.BOLD, 24));
			btn[i].addActionListener(this);
			frame.add(btn[i]);
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		cnt++;
		if(cnt%2==1){
			letter="X";
		}
		else{
			letter="O";
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
		}
		else if(btn[3].getText() == btn[4].getText() && btn[4].getText() == btn[5].getText() && btn[3].getText() != ""){
			win = true;
			}
		else if(btn[6].getText() == btn[7].getText() && btn[7].getText() == btn[8].getText() && btn[6].getText() != ""){
			win = true;
			}//checking for verticle wins
		else if(btn[0].getText() == btn[3].getText() && btn[3].getText() == btn[6].getText() && btn[0].getText() != ""){
			win = true;
			}
		else if(btn[1].getText() == btn[4].getText() && btn[4].getText() == btn[7].getText() && btn[1].getText() != ""){
			win = true;
			}
		else if(btn[2].getText() == btn[5].getText() && btn[5].getText() == btn[8].getText() && btn[2].getText() != ""){
			win = true;
			}
		//checking for diagonal wins
		else if(btn[0].getText() == btn[4].getText() && btn[4].getText() == btn[8].getText() && btn[0].getText() != ""){
			win = true;
			}
		else if(btn[2].getText() == btn[4].getText() && btn[4].getText() == btn[6].getText() && btn[2].getText() != ""){
			win = true;
			}
		else {
			win = false;
			}
		/*Show a dialog if someone wins or the game is tie*/
		if(win == true){
			
			whoWins();

			} 
		else if(cnt == 9 && win == false){
			tie();
			}
	}
	
	public void tie(){
		JOptionPane.showMessageDialog(null, "Tie Game!");
		String user = JOptionPane.showInputDialog("Want to play again (Y/N)");
		if(user.equals("Y") || user.equals("y")){
			for(int i=0;i<9;i++){
					btn[i].setEnabled(true);
					btn[i].setText("");
				}
				cnt=0;
			}
		else if(user.equals("N") || user.equals("n")){
			frame.dispose();
			}
	}
	
	public void whoWins(){
		JOptionPane.showMessageDialog(null, letter + " WINS!");
		String user = JOptionPane.showInputDialog("Want to play again ?(Y/N)");
		if(user.equals("Y") || user.equals("y")){
			//new TicTacToeGame();
			for(int i=0;i<9;i++){
				btn[i].setEnabled(true);
				btn[i].setText("");
			}
			cnt=0;
			}
		else if(user.equals("N") || user.equals("n")){
			frame.dispose();
		}
	}
	
	public static void main(String[] args) {
		
		new TicTacToeGame();

	}

}
