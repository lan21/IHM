package swing.tags;

import java.awt.Color;
import java.awt.Paint;

import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.Canvas;

public class Selected extends CExtensionalTag{
	Paint color;
	
	public Selected(Canvas c){
		super(c);
	}
	
	public void added(CShape s){
		color = s.getFillPaint();
		s.setFillPaint(Color.YELLOW);
	}
	
	public void removed(CShape s){
		s.setFillPaint(color);
	}
}
