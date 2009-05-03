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
package jofc2.util;

import jofc2.model.elements.LineChart.Style;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.path.PathTrackingWriter;

public class TypeDotConverter extends ConverterBase<Style> {

	@Override
	public void convert(Style o, PathTrackingWriter writer, MarshallingContext mc) {
		writeNode(writer, "type", o.getType(), false);
		writeNode(writer, "colour", o.getColour(), true);
		writeNode(writer, "dot-size", o.getDotSize(), true);
		writeNode(writer, "halo-size", o.getHaloSize(), true);
		writeNode(writer, "rotation", o.getRotation(), true);
		writeNode(writer, "hallow", o.getHallow(), true);
		writeNode(writer, "sides", o.getSides(), true);
	}

	@SuppressWarnings("unchecked")
	public boolean canConvert(Class arg0) {
		return Style.class.isAssignableFrom(arg0);
	}
}
