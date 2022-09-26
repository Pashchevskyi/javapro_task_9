package ua.ithillel.lms;

import java.io.IOException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.Logger;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.api.Loadable;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLogger;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLoggerConfigurationLoader;

public class Main {

  public static void main(String[] args) {
    Loadable lcl = new FileLoggerConfigurationLoader();
    try {
      LoggerConfiguration lc = lcl.load("./config/log.properties");
      Logger l = new FileLogger((FileLoggerConfiguration) lc);
      l.debug("Some debug message 3");
      l.info("Some info message 5");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
