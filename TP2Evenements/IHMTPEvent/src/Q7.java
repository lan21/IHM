import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;


public class Q7 {
	
	protected JFrame f;
	protected JPanel p;
	protected JLabel l;
	protected JButton b;
	

	public Q7()
	{
		this.f = new JFrame("Q7");
		this.p = new JPanel();
		this.l = new JLabel("---");
		
		this.l.setFont(new Font("Verdana", Font.BOLD, 20));
		
		this.f.setContentPane(p);
		this.f.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		this.p.add(l);
		this.l.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		for(int i = 0 ; i < 3 ; i++)
		{
			b = new JButton("Bouton "+(i+1));
			b.setAlignmentX(Component.CENTER_ALIGNMENT);
		
			// Classe anonyme
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					l.setText(((JButton) e.getSource()).getText());
				}
			});
			this.p.add(b);
		}
		

		
		// Fermeture de la fenêtre
		this.f.addWindowListener(new FermetureFenetre());
		this.f.setSize(200, 200);
		this.f.setLocationRelativeTo(null);
		this.f.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		
		new Q7();
	}
}
