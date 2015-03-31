import javax.swing.JFrame;


public class ArdoiseMagiqueWindow {

	protected JFrame f;
	protected ArdoiseMagique a;
	

	public ArdoiseMagiqueWindow()
	{
		this.f = new JFrame("ArdoiseMagique");
		this.a = new ArdoiseMagique();
		
		this.f.getContentPane().add(a);
		

		// Fermeture de la fenêtre
		this.f.addWindowListener(new FermetureFenetre());
		this.f.setSize(400, 300);
		this.f.setLocationRelativeTo(null);
		this.f.setVisible(true);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ArdoiseMagiqueWindow();
	}

}
