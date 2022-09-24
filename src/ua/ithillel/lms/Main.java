package ua.ithillel.lms;

import java.io.IOException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.Logger;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfigurationLoader;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLogger;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLoggerConfigurationLoader;

public class Main {

  public static void main(String[] args) {
    LoggerConfigurationLoader lcl = new FileLoggerConfigurationLoader();
    try {
      LoggerConfiguration lc = lcl.load("./config/logs.ini");
      Logger l = new FileLogger(lc);
      l.debug("Some debug message 1");
      l.info("Some info message 2");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
