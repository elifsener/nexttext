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

package net.nexttext;

import net.nexttext.renderer.TextPageRenderer;

/**
 * 
 * A page responsible for storing and displaying text
 * 
 * <p>The actual rendering of the text is delegated to a TextPageRenderer 
 * to support separation of model from view and to promote modularity.<p>
 *
 */
/* $Id$ */
public class TextPage {

	//The root of the text hierarchy that this page
	//is responsible for rendering.
    protected TextObjectGroup textRoot;
    protected TextPageRenderer textPageRenderer;
    
    public TextPage(Book book, TextPageRenderer t){
        this.textRoot = new TextObjectGroup();
        book.getTextRoot().attachChild(textRoot);
        this.textPageRenderer = t;
    }

    public TextObjectGroup getTextRoot() {
        return textRoot;
    }  
    
    public void render() {        
        textPageRenderer.renderPage(this);
    } 
}
