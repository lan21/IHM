import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class FermetureFenetre extends WindowAdapter {
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Fermeture en cours...");
		System.exit(0);
		
		//super.windowClosing(e);
	}

}
