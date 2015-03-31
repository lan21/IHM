import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;


public class ReponseAuClic implements ActionListener {
	
	protected JLabel l;
	
	public ReponseAuClic(JLabel l)
	{
		this.l = l;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clic sur le bouton");
		
		this.l.setText(""+(Integer.parseInt(this.l.getText())+1));
	}

}
