/*
  This file is part of the NextText project.
  http://www.nexttext.net/

  Copyright (c) 2004-08 Obx Labs / Jason Lewis

  NextText is free software: you can redistribute it and/or modify it under
  the terms of the GNU General Public License as published by the Free Software 
  Foundation, either version 2 of the License, or (at your option) any later 
  version.

  NextText is distributed in the hope that it will be useful, but WITHOUT ANY
  WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR 
  A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with 
  NextText.  If not, see <http://www.gnu.org/licenses/>.
*/

package net.nexttext.property;

/**
 * A number property of a TextObject or Behaviour.
 *
 * <p>This class handles both integer and floating point type numbers.  It
 * seemed easier to do this in one class, rather than having a class for each
 * Java primitive numerical type.  Internally, the values are stored as
 * doubles, and cast as appropriate.</p>
 */
/* $Id$ */
public class NumberProperty extends Property {

    double original;
    double value;
  
    public NumberProperty(double value) {
        original = value;
        this.value = value;      
    }

    public double getOriginal() { return original; }

    public double get() { return value; }

    public void set(double value) { 
       this.value = value;
       firePropertyChangeEvent();
    }

    public void add(double value) {
        this.value += value;
        firePropertyChangeEvent();
    }

    public void reset() {
        set(getOriginal());
    }

    public String toString() {
        return "(" + Double.toString(original) +
            ", " + Double.toString(value);
    }

    // Accessors in case it's easier to treat a number property as a long.

    public NumberProperty(long value) {
        original = (double) value;
        this.value = (double) value;     
    }

    public long getOriginalLong() { return (long) original; }
    public long getLong() {
        return (long) value;
    }

    public void set(long value) { 
        this.value = (double) value;
        firePropertyChangeEvent();
    }

    public void add(long value) {
        value += (double) value;
        firePropertyChangeEvent();
    }
}
