package pl.dmcs.chartsfromcsv;

public class Controller {

    public static void main(String[] args) throws Exception {
        Communicator communicator = new Communicator();
        Parameters parameters = communicator.getParameters(args);

        ChartCreator chartCreator = new ChartCreator(parameters, new ChartUtils());
        chartCreator.create();
    }
}