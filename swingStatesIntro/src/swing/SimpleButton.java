package swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;

import javax.swing.JFrame;

import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.CRectangle;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.CText;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.canvas.transitions.EnterOnTag;
import fr.lri.swingstates.canvas.transitions.LeaveOnTag;
import fr.lri.swingstates.canvas.transitions.PressOnTag;
import fr.lri.swingstates.canvas.transitions.ReleaseOnTag;
import fr.lri.swingstates.debug.StateMachineVisualization;
import fr.lri.swingstates.sm.State;
import fr.lri.swingstates.sm.Transition;
import fr.lri.swingstates.sm.transitions.Release;
import fr.lri.swingstates.sm.transitions.TimeOut;

/**
 * @author Allan Rakotoarivony
 *
 */
public class SimpleButton {

	private CText label;
	private CRectangle rectangle;
	private CStateMachine buttonStateMachine;

	SimpleButton(Canvas canvas, String text) {
		label = canvas
				.newText(0, 85, text, new Font("verdana", Font.PLAIN, 12));
		// on crée un texte sur le canvas à la position (0,0)

		rectangle = canvas.newRectangle(10, 0, label.getWidth() + 10,
				label.getHeight() + 5);
		// on crée un rectangle sur le canvas à la position (0,0) de taille plus
		// grand que le texte

		rectangle.setFillPaint(Color.GRAY);
		label.above(rectangle).setPickable(false);
		// le label sera au dessus du rectangle. Normalement, on aurait du le
		// déclarer après rectangle mais on n'aurait
		// pas eu la dimension du texte. On met aussi le label en setPickable
		// false pour qu'il

		rectangle.addChild(label);
		// on lie le label et le rectangle en disant que le label est un fils du
		// rectangle

		label.setReferencePoint(0.5, 0.5).translateTo(rectangle.getCenterX(),
				rectangle.getCenterY());
		// on centre le label dans le rectangle

		final CExtensionalTag simpleButton = new CExtensionalTag() {
		};
		rectangle.addTag(simpleButton);

		buttonStateMachine = new CStateMachine() {
			Paint color;
			CShape buttonPressed;
			public State out = new State() {
				public void enter(){
					if(buttonPressed!=null)
						buttonPressed.setStroke(new BasicStroke(1));
				}
				Transition enterOnTag = new EnterOnTag(simpleButton, ">> in") {
					public void action(){
						buttonPressed = getShape();
					}
				};
			};
			public State in = new State() {
				public void enter(){
					buttonPressed.setOutlined(true);
					buttonPressed.setStroke(new BasicStroke(3));
				}
				Transition pressOnTag = new PressOnTag(simpleButton,
						">> pressed") {
					public void action() {
						color = getShape().getFillPaint();
					}
				};
				Transition leaveOnTag = new LeaveOnTag(simpleButton, ">> out") {
				};
			};
			public State pressed = new State() {
				public void enter(){
					getShape().setFillPaint(Color.YELLOW);
					getShape().setOutlined(false);
					buttonPressed = getShape();
					armTimer(200, false);
				}
				Transition releaseOnTag = new ReleaseOnTag(simpleButton,
						">> semiClicked") {
					public void action() {
						armTimer(200,false);
					}
				};
				Transition leaveOnTag = new LeaveOnTag(simpleButton,
						">> pressedOut") {
					public void action() {
						getShape().setFillPaint(color);
					}
				};
				Transition click = new TimeOut(">> longClick") {
					public void action() {
						buttonPressed.setOutlined(true).setStroke(
								new BasicStroke(1));
						buttonPressed.setFillPaint(Color.RED);
					}
				};
			};
			public State pressedOut = new State() {
				Transition release = new Release(">> out") {
					public void action() {
						buttonPressed.setOutlined(true).setStroke(
								new BasicStroke(1));
					}
				};

				Transition enterOnTag = new EnterOnTag(simpleButton,
						">> pressed") {
					public void action() {
						color = getShape().getFillPaint();
						getShape().setFillPaint(Color.YELLOW);
					}
				};
			};
			public State longClick = new State() {
				Transition releaseOnTag = new ReleaseOnTag(simpleButton,">> longClicked") {
					public void action(){
						armTimer(200,false);
					}
				};
			};
			public State semiClicked = new State() {
				Transition semiClickDone = new TimeOut(">> in"){
					public void action(){
						doSemiClick();
					}
				};
				Transition repressOnTag = new PressOnTag(simpleButton,">> doubleClick"){
				};
			};
			
			public State longClicked = new State() {
				Transition longClickDone = new TimeOut(">> in"){
					public void action(){
						doClick();
					}
				};
			};
			
			public State doubleClick = new State(){
				Transition doubleClickDone = new ReleaseOnTag(simpleButton,">> in"){
					public void action(){
						doDoubleClick();
					}
				};
			};
		};
		/*
		 * buttonStateMachine = new CStateMachine() { public State start = new
		 * State(){
		 * 
		 * }; public State pressed = new State(){
		 * 
		 * }; public State semiClick = new State(){
		 * 
		 * }; public State doubleClick = new State(){
		 * 
		 * }; public State longClik; };
		 */
		buttonStateMachine.attachTo(canvas);

	}

	public void action() {
		System.out.println("ACTION!");
	}

	public CShape getShape() {
		return rectangle;
	}

	public void addTag(CExtensionalTag t) {
		rectangle.addTag(t);
	}

	public CStateMachine getButtonStateMachine() {
		return buttonStateMachine;
	}

	public void removeTag(CExtensionalTag t) {
		rectangle.removeTag(t);
	}

	public void doClick() {
		// TODO
	}

	public void doSemiClick() {
		// TODO
	}

	public void doClickDemi() {
		// TODO
	}

	public void doDoubleClick() {
		// TODO
	}

	static public void main(String[] args) {
		JFrame frame = new JFrame();
		Canvas canvas = new Canvas(400, 400);
		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setVisible(true);

		SimpleButton simple = new SimpleButton(canvas, "simple");
		/*SimpleButton tricky = new SimpleButton(canvas, "tricky");*/

		simple.getShape().translateBy(150, 150);

		StateMachineVisualization smv = new StateMachineVisualization(
				simple.getButtonStateMachine());
		JFrame frameSM = new JFrame();
		frameSM.getContentPane().add(smv);
		frameSM.pack();
		frameSM.setLocation(500, 0);
		frameSM.setVisible(true);
	}

}