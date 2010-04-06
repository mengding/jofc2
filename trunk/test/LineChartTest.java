import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.elements.LineChart;
import jofc2.model.elements.LineChart.Style.Type;
import jofc2.org.json.JSONArray;
import jofc2.org.json.JSONObject;
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
    @Test
    public void JSONTest() throws Exception {
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
        JSONObject jsonResult=  new JSONObject(OFC.getInstance().render(c));
        JSONArray elements = jsonResult.getJSONArray("elements");
        JSONArray values = elements.getJSONObject(0).getJSONArray("values");
        assert values.length() == 6;
        assert values.getJSONObject(0).getInt("value") == 10;
        assert values.getJSONObject(1).getInt("value") == 1;
        assert values.getJSONObject(2).getInt("value") == 5;
        assert values.getJSONObject(3).getInt("value") == 4;
        assert values.getJSONObject(4).getInt("value") == 6;
        assert values.getJSONObject(5).getInt("value") == 15;
        assert values.getJSONObject(5).getString("colour").equals("#121212");

    }
}
