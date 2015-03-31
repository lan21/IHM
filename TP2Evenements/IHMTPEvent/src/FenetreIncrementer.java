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


public class FenetreIncrementer
{
	protected JFrame f;
	protected JPanel p;
	protected JLabel l;
	protected JButton b;
	
	
	public FenetreIncrementer()
	{
		this.f = new JFrame("--Incrémenter--");//creier un jframe avec titre incrementer
		this.p = new JPanel(); 
		this.l = new JLabel(""+0);
		this.l.setFont(new Font("Courier", Font.BOLD, 20));
		this.b = new JButton("Incrémenter");
		
		this.f.setContentPane(p);
		this.f.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS ));// placer les  commposante verticalement 
		
		this.p.add(l);
		this.p.add(b);
		this.l.setAlignmentX(Component.CENTER_ALIGNMENT);// centrer les composente au centre de la fene
		this.b.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Classe anonyme
		this.b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// On incrémente le label
				l.setText(""+(Integer.parseInt(l.getText())+1));
			}
		});

		//  Classe interne
		this.b.addActionListener(new ReponseAuClicInterne());
		
		// Fermeture de la fenetre
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
		
		FenetreIncrementer q = new FenetreIncrementer();
	}
	
	private class ReponseAuClicInterne implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			// On affiche un message dans la console
			System.out.println("Clic sur le bouton");
		}

	}


}
