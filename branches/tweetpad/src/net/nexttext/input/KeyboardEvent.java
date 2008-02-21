//
// Copyright 2004 Jason Lewis
//

package net.nexttext.input;

import java.awt.event.KeyEvent;

/**
 * An event generated by the keyboard.
 *
 * <p>This is a wrapper around the {@link KeyEvent} class.  All IDs returned 
 * by the functions of this class are the same IDs used in the {@link KeyEvent} 
 * class.</p>
 */

public class KeyboardEvent extends InputEvent {

    static final String REVISION = "$CVSHeader: obx/NextText/src/net/nexttext/input/KeyboardNTEvent.java,v 1.3 2004/07/06 14:46:37 brunon Exp $";

	// The mouse event
	KeyEvent event;
	
	/**
	 * Class constructor
	 *
	 * @param	event	the generated event
	 */
	public KeyboardEvent(KeyEvent event) {
		this.event = event;
	}
	
	/**
	 * Returns the type of keyboard event.
	 *
	 * @return	the type id of the keyboard event
	 */
	public int getType() { return event.getID(); }
	
	/**
	 * Returns the character associated with the key in this event.
	 *
	 * @return	a char corresponding to to the combination of keystrokes 
	 *			that make up this event.
	 */
	public char getKeyChar() { return event.getKeyChar(); }
	
	/**
	 * Returns the integer keyCode associated with the key in this event. 
	 *
	 * @return	the integer code for an actual key on the keyboard.
	 *			(For KEY_TYPED events, the keyCode is VK_UNDEFINED.)
	 */
	public int getKeyCode() { return event.getKeyCode(); }
	
	/**
	 * Returns the location of the key that originated this key event.
	 *
	 * @return	the location of the key that was pressed or released. Always
	 *			returns KEY_LOCATION_UNKNOWN for KEY_TYPED events.
	 */
	public int getKeyLocation() { return event.getKeyLocation(); }
	
	/**
	 * Returns whether the key in this event is an "action" key.
	 *
	 * @return	true if the key is an "action" key, false otherwise
	 */
	public boolean isActionKey() { return event.isActionKey(); }
	
	/**
	 * Returns whether or not the Alt modifier is down on this event.
	 *
	 * @return	true if the alt key is down
	 */
	public boolean isAltDown() { return event.isAltDown(); }
	
	/**
	 * Returns whether or not the Alt Graph modifier is down on this event.
	 *
	 * @return	true if the alt graph key is down
	 */
	public boolean isAltGraphDown() { return event.isAltGraphDown(); }
	
	/**
	 * Returns whether or not the Control modifier is down on this event.
	 *
	 * @return	true if the control key is down
	 */
	public boolean isControlDown() { return event.isControlDown(); }

	/**
	 * Returns whether or not the Meta modifier is down on this event.
	 *
	 * @return	true if the meta key is down
	 */
	public boolean isMetaDown() { return event.isMetaDown(); }
	
	/**
	 * Returns whether or not the Shift modifier is down on this event.
	 *
	 * @return	true if the shift key is down
	 */
	public boolean isShiftDown() { return event.isShiftDown(); }
}
