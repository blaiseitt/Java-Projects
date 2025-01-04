package pl.dmcs.chartsfromcsv;

public class Parameters {

    public String data;
    public String chart;
    public String title;
    public String xLabel;
    public String yLabel;
    public Integer xMin;
    public Integer xMax;
    public Integer yMin;
    public Integer yMax;

    Parameters() {
    }

    Parameters(String data, String chart, String title, String xLabel, String yLabel, Integer xMin, Integer xMax, Integer yMin,
               Integer yMax) {
        this.data = data;
        this.chart = chart;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }
}
