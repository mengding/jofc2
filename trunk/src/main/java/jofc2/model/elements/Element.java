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

package jofc2.model.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jofc2.model.metadata.Alias;


public abstract class Element implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3975314200083173622L;
	private final String type;
    private Float alpha;
    private String text;
    @Alias("font-size") private Integer fontSize;
    @Alias("tip") private String tooltip;
    @Alias("gradient-fill") private Boolean gradientFill;
    private List<Object> values = new ArrayList<Object>();
    
    protected Element(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    public Float getAlpha() {
        return alpha;
    }

    public Element setAlpha(Float alpha) {
        this.alpha = alpha;
        return this;
    }

    public String getText() {
        return text;
    }

    public Element setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public Element setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }
    
    public List<Object> getValues() {
        return values;
    }
    
    public Element setTooltip(String tooltip) {
        this.tooltip = tooltip;
        return this;
    }
    
    public String getTooltip() {
        return tooltip;
    }

	
	public Boolean getGradientFill() {
		return gradientFill;
	}

	
	public void setGradientFill(Boolean gradientFill) {
		this.gradientFill = gradientFill;
	}
    
}
