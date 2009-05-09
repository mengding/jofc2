import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.elements.LineChart;
import org.testng.annotations.Test;

public class LineChartTest
{
    @Test
    public void serializationTest() {
        LineChart lc = new LineChart();
        lc.setDotStyle(new LineChart.Style.HallowDot("#ff00ff", 3, 1));
        lc.addValues(10, 1, 5, 4, 6);
        lc.addDots(new LineChart.Dot(15, "#121212"));

        Chart c = new Chart();
        c.addElements(lc);

        String s = OFC.getInstance().prettyPrint(c, 4); 
        System.out.println("RENDERED CHART:" + s);
        assert !s.contains("\"@class\"");
    }
}
