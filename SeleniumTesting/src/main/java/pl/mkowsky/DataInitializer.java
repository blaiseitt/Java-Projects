package pl.mkowsky;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class DataInitializer {

    private CommandLine commandLine;

    public Params getCommandLineParams(String[] args) throws Exception {

        Options options = setOptions();

        CommandLineParser parser = new DefaultParser();

        commandLine = parser.parse(options, args);

        Params params = new Params();

        params.homePage = commandLine.getOptionValue("homePage");

        if (commandLine.hasOption("checkSubPages")) {
            if(commandLine.getOptionValue("checkSubPages").equals("true")){
                params.checkSubPages = true;
            } else if (commandLine.getOptionValue("checkSubPages").equals("false")){
                params.checkSubPages = false;
            } else {
                throw new Exception("checkSubPages parameter is invalid.");
            }
        }
        return params;
    }


    private Options setOptions() {
        Option addressOption = new Option("homePage", true, "home address");
        addressOption.setRequired(true);
        Option subPagesOption = new Option("checkSubPages", true, "check sub pages?");
        subPagesOption.setRequired(false);

        Options options = new Options();
        options.addOption(addressOption);
        options.addOption(subPagesOption);
        return options;
    }

}
