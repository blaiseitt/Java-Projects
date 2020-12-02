package pl.dmcs.chartsfromcsv;

import org.apache.commons.cli.*;

public class Communicator {

    private CommandLine cmd;

    public Parameters getParameters(String[] args) throws Exception {

        Options options = setOptions();
        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options, args);
        Parameters parameters = new Parameters();
        parameters.data = cmd.getOptionValue("data");
        parameters.chart = cmd.getOptionValue("chart");
        parameters.title = cmd.getOptionValue("title");
        parameters.xLabel = cmd.getOptionValue("xlabel");
        parameters.yLabel = cmd.getOptionValue("ylabel");
        parameters.xMin = Integer.parseInt(cmd.getOptionValue("xmin"));
        parameters.xMax = Integer.parseInt(cmd.getOptionValue("xmax"));
        parameters.yMin = Integer.parseInt(cmd.getOptionValue("ymin"));
        parameters.yMax = Integer.parseInt(cmd.getOptionValue("ymax"));

        return parameters;
    }

    private Option getOption(String name, String desc, boolean required) {
        Option option = new Option(name, true, desc);
        option.setRequired(required);
        return option;
    }


    private Options setOptions() {
        Options options = new Options();

        options.addOption(getOption("data", "csv file path", true));
        options.addOption(getOption("chart", "output path", true));
        options.addOption(getOption("title", "chart title", true));
        options.addOption(getOption("xlabel", "X axis name", true));
        options.addOption(getOption("ylabel", "Y axis name", true));
        options.addOption(getOption("xmin", "minimal X-axis range", true));
        options.addOption(getOption("xmax", "maximal X-axis range", true));
        options.addOption(getOption("ymin", "minimal Y-axis range", true));
        options.addOption(getOption("ymax", "maximal Y-axis range", true));

        return options;
    }

}