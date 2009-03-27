package jofc2.model.elements;

import jofc2.model.elements.AreaLineChart;
import jofc2.model.elements.LineChart;
import jofc2.model.metadata.Alias;

public class AreaLineChart extends LineChart {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static transient final Float DEFAULT_ALPHA = 0.35f;
    
    @Alias("fill-alpha") private Float fillAlpha;
    @Alias("fill") private String fillColor;
    

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public AreaLineChart() {
        super("area_line");
        setFillAlpha(DEFAULT_ALPHA);
    }

    public Float getFillAlpha() {
        return fillAlpha;
    }

    public AreaLineChart setFillAlpha(Float fillAlpha) {
        this.fillAlpha = fillAlpha;
        return this;
    }
}