import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.elements.LineChart;
import jofc2.model.elements.LineChart.Style.Type;

import org.testng.annotations.Test;

public class LineChartTest
{
    @Test
    public void serializationTest() {
        LineChart lc = new LineChart();
		lc.setDotStyle(new LineChart.Style(Type.STAR, "#111111",9,9).setRotation(90));
		lc.setDotStyle(new LineChart.Style(Type.HALLOW_DOT, "#111111",9,9));
		lc.setDotStyle(new LineChart.Style(Type.ANCHOR, "#111111",9,9,90,true).setSides(3));
		lc.setDotStyle(new LineChart.Style(Type.SOLID_DOT, "#111111",9,9));
		lc.setDotStyle(new LineChart.Style(Type.BOW, "#111111",9,9).setRotation(90));
        lc.addValues(10, 1, 5, 4, 6);
        lc.addDots(new LineChart.Dot(15, "#121212"));

        Chart c = new Chart();
        c.addElements(lc);

        String s = OFC.getInstance().prettyPrint(c, 4); 
        System.out.println("RENDERED CHART:" + s);
        assert !s.contains("\"@class\"");
    }
}
