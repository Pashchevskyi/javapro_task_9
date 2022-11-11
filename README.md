This task is task#9 from Hillel computer school in JavaPro group.

The topic of task is "Introduction of I/O. Working with files".

This is the simpliest logger for store of messages to log files
(or, if you would like, you might extend this system to console or some other kind of logging).

You might configure the logging process. Configuration file for logs might be set in constructor of 
LoggerConfiguration object. It is recommended to put it to "./config/log.properties" related to root
directory of the Project. 

Parameters in configuration file are stored in the format of *.properties files.

Meaning of configuration parameters:

log.file.path - path to log file

log.file.level - which kind of messages will be logged.

log.file.max_size - integer value, which is number of bytes - maximum allowed size of log file.

log.file.format - regular expression for LOG file formatting

Configuration example is situated in "./config/log.sample.properties" file of the Project.

To run project, please, rename "./config/logs.sample.ini" to "./config/logs.ini".

If you do not have directory and/or *.properties file you would like to put configuration options,
file will be created automatically.

Example of usage:

package ua.ithillel.lms;

import java.io.IOException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.Logger;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggingLevel.Loadable;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLogger;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLoggerConfigurationLoader;

public class Main {

  public static void main(String[] args) {
    Loadable lcl = new FileLoggerConfigurationLoader();
    try {
      LoggerConfiguration lc = lcl.load("./config/log.properties");
      Logger l = new FileLogger((FileLoggerConfiguration) lc);
      l.debug("Some debug message 1");
      l.info("Some info message 2");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
