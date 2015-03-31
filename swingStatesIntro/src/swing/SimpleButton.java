package swing;

import fr.lri.swingstates.canvas.CRectangle;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.Canvas ;
import fr.lri.swingstates.canvas.CShape ;
import fr.lri.swingstates.canvas.CText ;
import fr.lri.swingstates.sm.State;
import fr.lri.swingstates.sm.Transition;
import fr.lri.swingstates.canvas.transitions.EnterOnShape;
import fr.lri.swingstates.canvas.transitions.LeaveOnShape;
import javax.swing.JFrame ;

import java.awt.Color;
import java.awt.Font ;
import java.awt.Paint;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 *
 */
public class SimpleButton {

    private CText label ;
    private CRectangle rectangle;

    SimpleButton(Canvas canvas, String text) { 	   
	   label = canvas.newText(0, 85, text, new Font("verdana", Font.PLAIN, 12)) ;
	   //on crée un texte sur le canvas à la position (0,0)
	   
	   rectangle = canvas.newRectangle(10, 0, label.getWidth()+10, label.getHeight()+5);
	 //on crée un rectangle sur le canvas à la position (0,0) de taille plus grand que le texte
	   
	   label.above(rectangle).setPickable(false);
	   //le label sera au dessus du rectangle. Normalement, on aurait du le déclarer après rectangle mais on n'aurait
	   //pas eu la dimension du texte. On met aussi le label en setPickable false pour qu'il 
	   
	   rectangle.addChild(label);
	   //on lie le label et le rectangle en disant que le label est un fils du rectangle
	   
	   label.setReferencePoint(0.5,0.5).translateTo(rectangle.getCenterX(), rectangle.getCenterY());
	   //on centre le label dans le rectangle 
    }

    public void action() {
	   System.out.println("ACTION!") ;
    }

    public CShape getShape() {
	   return rectangle ;
    }
    

    static public void main(String[] args) {
	   JFrame frame = new JFrame() ;
	   Canvas canvas = new Canvas(400,400) ;
	   frame.getContentPane().add(canvas) ;
	   frame.pack() ;
	   frame.setVisible(true) ;

	   SimpleButton simple = new SimpleButton(canvas, "simple") ;
	   
	   simple.getShape().translateBy(150,150) ;
	   
	   CStateMachine sm = new CStateMachine() {
		    Paint initColor;
		    //out est l'un des états de l'automate
		    public State out = new State() {
		    	//quand on entre dans le shape, on passe à l'état in et on paint en jaune
		        Transition enterBox = new EnterOnShape(">> in") {
		            public void action() {
		                initColor = getShape().getFillPaint();
		                getShape().setFillPaint(Color.YELLOW);
		            }
		        };
		    };
		    //in est l'autre état
		    public State in = new State() {
		    	//quand on sort du shape, on passe à l'état out et enleve la couleur jaune
		        Transition leaveBox = new LeaveOnShape(">> out") {
		            public void action() {
		                getShape().setFillPaint(initColor);
		            }
		        };
		    };
		};
		sm.attachTo(canvas);
    }

}