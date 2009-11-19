//
// Copyright (C) 2007 Jason Lewis
//

package net.nexttext.behaviour.dform;

import net.nexttext.TextObjectGlyph;
import net.nexttext.Vector3;
import net.nexttext.property.Vector3PropertyList;
import net.nexttext.property.Vector3Property;

import java.awt.Rectangle;

import java.util.Iterator;

/**
 * A DForm which scales the size of a TextObject.
 *
 */
public class Scale extends DForm {
    
    static final String REVISION = "$CVSHeader$";

    private double scale;
    /**
     * @param scale is amount the object's size will increase, as a multiplier. 
     */
    public Scale(double scale) {
        this.scale = scale;        
    }

    public ActionResult behave(TextObjectGlyph to) {
        // Determine the center of to, in the same coordinates as the control
        // points will be.
        Vector3 toAbsPos = to.getPositionAbsolute();
        Rectangle bb = to.getBoundingPolygon().getBounds();
        Vector3 center = new Vector3(bb.getCenterX(), bb.getCenterY());
        center.sub(toAbsPos);

        // Traverse the control points of the glyph, applying the
        // multiplication factor to each one, but offset from the center, not
        // the position.
        Vector3PropertyList cPs = getControlPoints(to);
        Iterator i = cPs.iterator();
        while (i.hasNext()) {
            Vector3Property cP = (Vector3Property) i.next();
            // Get the vector from the center of the glyph to the control point.
            Vector3 p = cP.get();
            p.sub(center);
            // Scale the control point by the appropriate factor
            p.scalar(scale);
            // Return p to the original coordiates
            p.add(center);            
            cP.set(p);
        }
        return new ActionResult(true, true, false);       
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}