package magnetic;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;

import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.CSegment;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.Canvas;

public class MagneticGuide extends CExtensionalTag {
	protected CSegment segment;
	
	public MagneticGuide(Canvas c){
		super(c);
	}
	
	public void added(CShape s){
		s.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,new float[]{9},0));
	}
	
	public void removed(CSegment s){
		
	}
}
