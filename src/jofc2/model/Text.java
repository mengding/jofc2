/*
This file is part of JOFC2.

JOFC2 is free software: you can redistribute it and/or modify
it under the terms of the Lesser GNU General Public License as
published by the Free Software Foundation, either version 3 of
the License, or (at your option) any later version.

JOFC2 is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

See <http://www.gnu.org/licenses/lgpl-3.0.txt>.
*/

package jofc2.model;

import java.io.Serializable;

public class Text implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2390229886841547192L;
	private String text;
    private String style;
    
    public Text() {
        this(null, null);
    }
    
    public Text(String text) {
        this(text, null);
    }
    
    public Text(String text, String style) {
        setText(text);
        setStyle(style);
    }
    
    public String getText() {
        return text;
    }
    public Text setText(String text) {
        this.text = text;
        return this;
    }
    public String getStyle() {
        return style;
    }
    public Text setStyle(String style) {
        this.style = style;
        return this;
    }
}
