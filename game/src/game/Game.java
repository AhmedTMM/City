package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

class Game extends JFrame{
	public static int population = 100;
	public static int money = 1000;
	public static int roads = 100;
	public static int homes = 100;
	public static int education = 1;
	public static int happiness = 100;
	protected AbstractButton statusLabel;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Starts the screen
		JFrame frame = new JFrame("City");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		//Buttons and gui stuff
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
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, turn);
		String text = "Started";
		JTextArea updates = new JTextArea(text);
        frame.setVisible(true);
        //actions for buttons
        turn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (homes < 0) {
            		updates.setText("UPDATES:\nYou lost because you are loser");
            	}
            	turn();
            	updates.setText("UPDATES:\nYou have " + homes + " homes and this many roads " + roads + " and you have " + education + " education and you have this much money " + money + " and finally but not least " + happiness + " happiness!");
            	}                
        	});
        if (money > 0) {
        m21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	homes = homes - 100;
            	money = money + 100;
            	System.out.println("Your homes now " + homes);
            	System.out.println("Your money now " + money);
            	updates.setText("UPDATES:\nSold homes! " + "Your homes now " + homes + " Your wealth now " + money);
            	}                
        	});
        m22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	education = education - 1;
            	money = money + 5000 * education;
            	System.out.println("Your education now " + education);
            	System.out.println("Your money now " + money);
            	updates.setText("UPDATES:\nSold Education and your future! " + "Your education now " + education + " Your wealth now " + money);
            	}                
        	});
        m23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	roads = roads - 100;
            	money = money + 100;
            	System.out.println("Your roads now " + roads);
            	System.out.println("Your money now " + money);
            	updates.setText("UPDATES:\nSold roads!");
            	}                
        	});
        }
        if (money > 0) {
        m11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (money > 0) {
            	homes = homes + 100;
            	money = money - 100;
            	System.out.println("Your homes now " + homes);
            	System.out.println("Your money now " + money);
            	updates.setText("UPDATES:\nBought homes! " + "Your homes now " + homes + " Your wealth now " + money);
                }
                else {
                	updates.setText("You ran out of money");
                }
            	}                
        	});
        m12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (money > 0) {
            	education = education + 1;
            	money = money - 5000;
            	System.out.println("Your education now " + education);
            	System.out.println("Your money now " + money);
            	updates.setText("UPDATES:\nBought Education and your future! " + "Your education now " + education + " Your wealth now " + money + " Your population is " + population);
                }
                else {
                	updates.setText("You ran out of money");
                }
            	}                
        	});
        m13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (money > 0) {
            	roads = roads + 100;
            	money = money - 100;
            	System.out.println("Your roads now " + roads);
            	System.out.println("Your money now " + money);
            	updates.setText("UPDATES:\nYou have "+roads+" roads!");
            	}   
                else {
                	updates.setText("You ran out of money");
                }
        }
        	});
        }
        m31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (money > 0) {
            	money = money - 10000;
            	population = 0;
            	updates.setText("UPDATES:\nYou have Won the game, also your populations all died and now it is " + population);
                }
                else {
                	updates.setText("You ran out of money");
                }
            	}                
        	});
        if (population > 10000000) {
        	updates.setText("UPDATES:\nYou won congrats!!!)");
        }
        frame.getContentPane().add(BorderLayout.CENTER, updates);
	}
	public static void turn() {
		homes = homes - 10;
		happiness = happiness - 10;
		happiness = homes / 100;
		money = money - 200;
		money = money + happiness;
		money = money + education;
		money = money + homes;
		homes = homes + roads;
		population = population + homes;
		int population2 = homes * 4;
		if (population2 < population) {
			population = population - homes;
		}
		int roads2 = roads * 2;
		if (roads2 < homes) {
			homes = homes - roads;
		}
	}
}
