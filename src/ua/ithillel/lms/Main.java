package ua.ithillel.lms;

import java.io.IOException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.Logger;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfigurationLoader;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLogger;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file.FileLoggerConfigurationLoader;

public class Main {

  public static void main(String[] args) {
    LoggerConfigurationLoader lcl = new FileLoggerConfigurationLoader();
    try {
      LoggerConfiguration lc = lcl.load("./config/log.properties");
      Logger l = new FileLogger((FileLoggerConfiguration) lc);
      l.error(
          "ERROR: Logical error in Main::main() 18: Logger::error() method should not be called not on error.");
      l.warn("Warning: Main::main() in line 19: possible loss of data");
      l.info("This is info message on line 21 of Main::main() method");
      l.debug(
          "Please, look attentively at line 21 in Main::main() method. It should be better to trace stack.");
      l.trace("Stack trace: Main::main():18 -> Logger::trace():12 -> FileLogger::log():20");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
