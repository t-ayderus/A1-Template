package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        

            Options options = new Options();

            options.addOption("i", true, "Input Maze" );
            options.addOption("p",true,"User inputted potential path");

            CommandLineParser parser = new GnuParser();
            try {  CommandLine cmd = parser.parse(options, args);
          
            if(cmd.hasOption("i"))
            {
                String filename = args[1];
                logger.info("**** Reading the maze from file " + filename);
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                while ((line = reader.readLine()) != null) {
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            logger.info("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            logger.info("PASS ");
                        }
                    }
                  //  System.out.print(System.lineSeparator());

                }
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.error("**** Computing path");
        logger.error("PATH NOT COMPUTED");
        logger.error("** End of MazeRunner");
    }
}
