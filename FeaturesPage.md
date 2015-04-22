# Feature Page #
We 'll try to list all new features in JOFC2 1.0 here


## JSON Debugoutput ##
Chart.toString() gives you one big string in one line which is no problem for openflashchart but maybe for you when you want to debug the JSON Code. Therefore you can now use: chart.toDebugString(), which will give you a nice formated JSOn String like:
```
{
   "bg_colour": "#FFFFFF",
   "elements": [
      {
         "type": "bar_glass",
         "values": [
            {
               "colour": "#00FF00",
               "tip": "Abt 1\nUmsatz: 3.866.999,53 EUR",
               "top": 3866999.5254760142
            },
            {
               "colour": "#00FF00",
               "tip": "Abt 2\nUmsatz: 4.083.458,67 EUR",
               "top": 4083458.672950851
            },
            {
               "colour": "#00FF00",
               "tip": "Abt 3\nUmsatz: 2.382.793,81 EUR",
               "top": 2382793.806046932
            }
[...]
```
and so on

## Autocompute YAxis Range ##
For some reason OpenflashChart itself cannot determine a propper YAxis. You have to set one by your self with:
```
YAxis.setRange(int min, int max, int stepsize);
```
If you have dynamic charts with differend values you dont want to set a fix range. Therefore we implemented this method:
```
chart.computeYAxisRange(int NumOfSteps);
```
NumOfSteps is the number of Steps you want in your chart (a good value is from 10 to 15 Steps).
Call this method **after** you populated the chart object with data. This method works actually with line- and barcharts.

## Advanced Numberformating Options ##
We added support for numberformating options in OFC. We also patched the actionscript code of OFC itself. (We submitted the patch to monk.e.boy from OFC and it will hopefully be in the next release)
New Features are:
```
chart.setDecimalSeparatorIsComma(boolean is_decimal_separator_comma);
chart.setThousandSeparatorDisabled(boolean is_thousand_separator_disabled);
chart.setFixedNumDecimalsForced(boolean is_fixed_num_decimals_forced);
chart.setNumDecimals(int num_decimals);
```
More information is provided in the Javadocs see: http://scireum.de/jofc2/javadoc/

## Better Handling of Null Values ##
JOFC2 now handles null values e.g. in LineCharts. If you have null values you should use LineCharts.addValues(Numbers...) instead of making Dots and add them to the LineChart. Because OFC handels DOts with the value null als value Zero. Null values themself are handled as interpolated values. The bug is reported to OFC here: http://forums.openflashchart.com/viewtopic.php?f=5&t=490