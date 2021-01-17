package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
class Game extends JFrame{
	public static int population = 100;
	public static int money = 1000;
	public static int roads = 100;
	static int homes = 100;
	public static int education = 1;
	public static int happiness = 100;
	public static int t = 0;
	public static int moves = 0;
	protected AbstractButton statusLabel;
	public static void start() {
		//Starts the screen
		JFrame frame = new JFrame("City");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		//Buttons and gui stuff
		JPanel norm = new JPanel();
		JButton turn = new JButton("Next Turn");
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("Buy");
		mb.add(m1);
		JMenuItem m11 = new JMenuItem("Homes");
		JMenuItem m12 = new JMenuItem("Schools");
		JMenuItem m13 = new JMenuItem("Roads");
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		JMenu m2 = new JMenu("Sell");
		mb.add(m2);
		JMenuItem m21 = new JMenuItem("Homes");
		JMenuItem m22 = new JMenuItem("Education");
		JMenuItem m23 = new JMenuItem("Roads");
		m2.add(m21);
		m2.add(m22);
		m2.add(m23);
		JMenu m3 = new JMenu("Weapons");
		mb.add(m3);
		JMenuItem m31 = new JMenuItem("Nukes");
		m3.add(m31);
	    frame.getContentPane().add(BorderLayout.NORTH, norm);
	    m31.setBackground(Color.red);
	    mb.setBackground(Color.cyan);
	    turn.setBackground(Color.orange);
		String text = "Started";
		JTextArea updates = new JTextArea(text);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JTextArea stats = new JTextArea("Your stats are the following Population: "+population+" Money: "+money+" Roads: "+roads+" Homes: "+homes+" Education: "+education+" Happiness: "+happiness);
	    frame.setBackground(Color.gray);
	    panel.add(stats);
	    frame.add(panel);
	    frame.getContentPane().add(BorderLayout.SOUTH, panel);
	    norm.setBackground(Color.yellow);
	    norm.add(mb);
	    norm.add(updates);
	    norm.add(turn);
	    updates.setBackground(Color.LIGHT_GRAY);
	    stats.setBackground(Color.green);
		frame.setVisible(true);
		panel.setVisible(true);
		//actions
	    turn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if (homes < 0) {
	        		updates.setText("UPDATES:\nYou lost because you are loser");
	        	}
	        	if (moves == 3) {
	        	turn();
	        	updates.setText("UPDATES:\nYou have " + homes + " homes and this many roads " + roads + " and you have " + education + " education and you have this much money " + money + " and finally but not least " + happiness + " happiness!" + " Oh yea your population is " + population);
	        	t = t + 1;
	        	moves = 0;  
	        	stats.setText("Your stats are the following Population: "+population+" Money: "+money+" Roads: "+roads+" Homes: "+homes+" Education: "+education+" Happiness: "+happiness);
	        	}
	        	else {
	        		updates.setText("You must do three moves per turn");
	        	}
	        	
	        }
	    	});
	    if (money > 0) {
	    m21.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if (moves < 3) {
	        	homes = homes - 100;
	        	money = money + 100;
	        	System.out.println("Your homes now " + homes);
	        	System.out.println("Your money now " + money);
	        	updates.setText("UPDATES:\nSold homes! " + "Your homes now " + homes + " Your wealth now " + money);
	        	moves = moves + 1;
	        	}
	        	else {
	        		updates.setText("Goto next turn your out of moves");
	        	}
	        	}                
	    	});
	    m22.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if (moves < 3) {
	        	education = education - 1;
	        	money = money + 5000 * education;
	        	System.out.println("Your education now " + education);
	        	System.out.println("Your money now " + money);
	        	updates.setText("UPDATES:\nSold Education and your future! " + "Your education now " + education + " Your wealth now " + money);
	        	moves = moves + 1;
	        	}
	        	else {
	        		updates.setText("Goto next turn your out of moves");
	        	}
	        	}                
	    	});
	    m23.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if (moves < 3) {
	        	roads = roads - 100;
	        	money = money + 100;
	        	System.out.println("Your roads now " + roads);
	        	System.out.println("Your money now " + money);
	        	updates.setText("UPDATES:\nSold roads!");
	        	moves = moves + 1;
	        	}
	        	else {
	        		updates.setText("Goto next turn your out of moves");
	        	}
	        	}                
	    	});
	    }
	    if (money > 0) {
	    m11.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if (moves < 3) {
	            if (money > 0) {
	        	homes = homes + 100;
	        	money = money - 100;
	        	System.out.println("Your homes now " + homes);
	        	System.out.println("Your money now " + money);
	        	updates.setText("UPDATES:\nBought homes! " + "Your homes now " + homes + " Your wealth now " + money);
	        	moves = moves + 1;
	            }
	            else {
	            	updates.setText("You ran out of money");
	            }
	            
	    	}
	    	else {
	    		updates.setText("Goto next turn your out of moves");
	    	}
	        }
	    	});
	    m12.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if (moves < 3) {
	        	if (money > 0) {
	        	education = education + 1;
	        	money = money - 5000;
	        	System.out.println("Your education now " + education);
	        	System.out.println("Your money now " + money);
	        	updates.setText("UPDATES:\nBought Education and your future! " + "Your education now " + education + " Your wealth now " + money + " Your population is " + population);
	        	moves = moves + 1;
	            }
	            else {
	            	updates.setText("You ran out of money");
	            }
	        	}
	        	else {
	        		updates.setText("Goto next turn your out of moves");
	        	}
	        	}                
	    	});
	    m13.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if (moves < 3) {
	        	if (money > 0) {
	        	roads = roads + 100;
	        	money = money - 100;
	        	System.out.println("Your roads now " + roads);
	        	System.out.println("Your money now " + money);
	        	updates.setText("UPDATES:\nYou have "+roads+" roads!");
	        	moves = moves + 1;
	        	}   
	            else {
	            	updates.setText("You ran out of money");
	            }
	        	}
	        	else {
	        		updates.setText("Goto next turn your out of moves");
	        	}
	    }
	    	});
	    }
	    m31.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if (moves < 3) {
	        	if (money > 0) {
	        	money = money - 10000;
	        	population = 0;
	        	updates.setText("UPDATES:\nYou have Won the game, also your populations all died and now it is " + population);
	            }
	            else {
	            	updates.setText("You ran out of money");
	            }
	        	}
	        	else {
	        		updates.setText("Goto next turn your out of moves");
	        	}
	        	}                
	    	});
		if (population > 10000000) {
			updates.setText("UPDATES:\nYou won congrats!!!)");
		}
	    frame.getContentPane().add(BorderLayout.CENTER, updates);
		
	}
	public static void main(String[] args) {
	start();

	}
	public static void turn() {
		homes = homes - 10;
		happiness = happiness - 10;
		happiness = homes / 100;
		money = money - 200;
		int t2 = t * 10;
		money = money - t2;
		money = money + happiness;
		money = money + education;
		money = money + homes;
		homes = homes + roads;
		int homes3 = roads * 4;
		if (homes3 < homes) {
			homes = homes - roads;
		}
		population = population + homes;
		int population2 = homes * 4;
		if (population2 < population) {
			population = population - homes;
		}
	}
}
