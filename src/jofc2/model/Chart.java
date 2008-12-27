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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import jofc2.OFC;
import jofc2.OFCException;
import jofc2.model.axis.XAxis;
import jofc2.model.axis.YAxis;
import jofc2.model.elements.Element;

/**
 * This is the most important class in the Java OFC library. Start here,
 * configuring the title, axes, legends, labels, and draw-able elements in your
 * chart. Coerce the object to a String with the toString() method to get the
 * chart data back out.
 */
public class Chart implements Serializable {

	private static final long serialVersionUID = -1868082240169089976L;
	private Text title;
	private XAxis x_axis;
	private YAxis y_axis;
	private YAxis y_axis_right;
	private Text y_legend;
	private Text x_legend;
	private String bg_colour;
	private int is_decimal_separator_comma = 0;
	private int is_fixed_num_decimals_forced = 0;
	private int is_thousand_separator_disabled = 0;
	private int num_decimals = 2;
	private Collection<Element> elements = new ArrayList<Element>();

	public XAxis getXAxis() {
		return x_axis;
	}

	public Chart() {
	//nothing...
	}

	public Chart(String titleText) {
		this(titleText, null);
	}

	public Chart(String titleText, String style) {
		this.setTitle(new Text(titleText, style));
	}

	public Chart setXAxis(XAxis x_axis) {
		this.x_axis = x_axis;
		return this;
	}

	public YAxis getYAxis() {
		return y_axis;
	}

	public Chart setYAxis(YAxis y_axis) {
		this.y_axis = y_axis;
		return this;
	}

	public Chart setYAxisRight(YAxis y_axis_right) {
		this.y_axis_right = y_axis_right;
		return this;
	}

	public YAxis getYAxisRight() {
		return y_axis_right;
	}

	public Text getTitle() {
		return title;
	}

	public Chart setTitle(Text title) {
		this.title = title;
		return this;
	}

	public Text getXLegend() {
		return x_legend;
	}

	public Chart setXLegend(Text x_legend) {
		this.x_legend = x_legend;
		return this;
	}

	public Text getYLegend() {
		return y_legend;
	}

	public Chart setYLegend(Text y_legend) {
		this.y_legend = y_legend;
		return this;
	}

	public String getBackgroundColour() {
		return bg_colour;
	}

	public Chart setBackgroundColour(String bg_colour) {
		this.bg_colour = bg_colour;
		return this;
	}

	public Collection<Element> getElements() {
		return elements;
	}

	public Chart setElements(Collection<Element> elements) {
		this.elements.clear();
		this.elements.addAll(elements);
		return this;
	}

	public Chart addElements(Element... e) {
		elements.addAll(Arrays.asList(e));
		return this;
	}

	public Chart addElements(Collection<Element> coll) {
		elements.addAll(coll);
		return this;
	}

	public boolean removeElement(Element e) {
		return elements.remove(e);
	}

	public Element getElementByText(String text) {
		for (Element e : getElements()) {
			if (text.equals(e.getText())) return e;
		}
		return null;
	}

	@Override
	/*
	 * @throws OFCException can throw an OFCException if there is a problem
	 * rendering this Chart object. This exception would indicate an issue with
	 * the JOFC2 library itself.
	 */
	public String toString() throws OFCException {
		return OFC.getInstance().render(this);
	}
	
	/**
	 * Returns a well formatted JSON File which is much more easy for debugging
	 * (toString() returns only one line)
	 * @return
	 */
	public String toDebugString() {
		return OFC.getInstance().prettyPrint(this, 3);
	}

	/**
	 * Returns <code>true</code> if a comma is used as decimal separator and
	 * <code>false</code> if a dot is used as decimal separator.
	 */
	public boolean isDecimalSeparatorComma() {
		return is_decimal_separator_comma == 1;
	}

	/**
	 * Configures the symbols used to format decimal numbers. If the given value
	 * is <code>false</code> the American format (e.g. 1,234.45) is used. If the
	 * given value is <code>true</code> the German format (1.234,45) is used.
	 * Other formats like the French one are not yet supported by OFC.
	 * 
	 * @param is_decimal_separator_comma
	 *           <code>true</code> sets the decimal format to German,
	 *           <code>false</code> to American.
	 */
	public void setDecimalSeparatorIsComma(boolean is_decimal_separator_comma) {
		this.is_decimal_separator_comma = is_decimal_separator_comma ? 1 : 0;
	}

	/**
	 * Returns <code>true</code> if decimals are fixed to num_decimals and
	 * <code>false</code> if not.
	 */
	public boolean isFixedNumDecimalsForced() {
		return is_fixed_num_decimals_forced == 1;
	}

	/**
	 * Configures OFC to use fixed decimals (with num_decimals length). E.g.
	 * num_decimals=2 for <code>true</code> 1.1 will be 1.10 or 1 will be 1.00,
	 * for <code>false</code> 1.1 remains 1.1 and 1 remains 1
	 * 
	 * @param is_fixed_num_decimals_forced
	 *           <code>true</code> sets OFC to use fixed decimal length
	 *           <code>false</code> switches off fixed decimal length
	 */
	public void setFixedNumDecimalsForced(boolean is_fixed_num_decimals_forced) {
		this.is_fixed_num_decimals_forced = is_fixed_num_decimals_forced ? 1 : 0;
	}

	/**
	 * Returns <code>true</code> if thousand separators are used (e.g. 1.000 or
	 * 1,000... depending on is_decimal_separator_comma), <code>false</code>
	 * otherwise.
	 */
	public boolean isThousandSeparatorDisabled() {
		return is_thousand_separator_disabled == 1;
	}

	/**
	 * <code>true</code> turns on the thousand separator (e.g. 1.000 or 1,000...
	 * depending on is_decimal_separator_comma) <code>false</code> turns of the
	 * thousand separator (e.g. 1000)
	 */
	public void setThousandSeparatorDisabled(boolean is_thousand_separator_disabled) {
		this.is_thousand_separator_disabled = is_thousand_separator_disabled ? 1 : 0;
	}

	/**
	 * Returns the max number of decimals printed out in OFC. <br />
	 */
	public int getNumDecimals() {
		return num_decimals;
	}
   /**
    * Sets the max number of decimals printed out in OFC.<br />
    * Allowed values 0 - 16. <br/>
    */
	public void setNumDecimals(int num_decimals) {
		this.num_decimals = num_decimals;
	}
}
