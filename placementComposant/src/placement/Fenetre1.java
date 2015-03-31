package placement;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Fenetre1 {
	public void init(){
		JFrame window = new JFrame("JFrame");
		JLabel txt = new JLabel("Hello world");
		
		
		JButton centre = new JButton("centre");
		JButton nord = new JButton("nord");
		JButton est = new JButton("est");
		JButton ouest = new JButton("ouest");
		JButton sud = new JButton("sud");
		
		Container pane = window.getContentPane();
		
		pane.setLayout(new BoxLayout(pane,BoxLayout.PAGE_AXIS));
		
		for (int i = 1; i < 3; i++) {
			JPanel panel = new JPanel(); 
			panel.setLayout(new BorderLayout());
			panel.add(new JButton("Button "+i),BorderLayout.CENTER);
			pane.add(panel);
		}
		pane.add(Box.createRigidArea(new Dimension(0,75)));
		//pane.add(Box.createGlue());
		JPanel panel = new JPanel(); 
		panel.setLayout(new BorderLayout());
		panel.add(new JButton("Button 3"),BorderLayout.CENTER);
		pane.add(panel);
		
//		pane.add(txt);
		
		
//		JDialog dialog = new JDialog(window, "JDialog");
//		dialog.setSize(200,200);
//		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
//		dialog.setLocationRelativeTo(window);
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setSize(400, 400);
//		window.pack();
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		window.setVisible(true);
		
//		dialog.setVisible(true);
	}
	
	public void question11a(){
		JFrame window = new JFrame("JFrame");
		
		Container pane = window.getContentPane();
		
		pane.setLayout(new BoxLayout(pane,BoxLayout.PAGE_AXIS));
		
		for (int i = 1; i < 3; i++) {
			JPanel panel = new JPanel(); 
			panel.setLayout(new BorderLayout());
			panel.add(new JButton("Button "+i),BorderLayout.CENTER);
			pane.add(panel);
		}
		pane.add(Box.createRigidArea(new Dimension(0,75)));
		//pane.add(Box.createGlue());
		JPanel panel = new JPanel(); 
		panel.setLayout(new BorderLayout());
		panel.add(new JButton("Button 3"),BorderLayout.CENTER);
		pane.add(panel);
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setSize(400, 400);
//		window.pack();
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		window.setVisible(true);
	}
	
	public void question11b(){
		JFrame window = new JFrame("JFrame");
		
		Container pane = window.getContentPane();
		
		pane.setLayout(new BoxLayout(pane,BoxLayout.PAGE_AXIS));
		
		for (int i = 1; i < 3; i++) {
			JPanel panel = new JPanel(); 
			panel.setLayout(new BorderLayout());
			panel.add(new JButton("Button "+i),BorderLayout.CENTER);
			pane.add(panel);
		}
		pane.add(Box.createRigidArea(new Dimension(0,75)));
		//pane.add(Box.createGlue());
		JPanel panel = new JPanel(); 
		panel.setLayout(new BorderLayout());
		panel.add(new JButton("Button 3"),BorderLayout.CENTER);
		pane.add(panel);
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setSize(400, 400);
//		window.pack();
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		window.setVisible(true);
	}
	
	public static void main(String[] args){
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Fenetre1 f = new Fenetre1();
        		f.question11b();
            }
        });
		
	}
}
