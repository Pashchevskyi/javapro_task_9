package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggingLevel;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.api.Loadable;

public class FileLoggerConfigurationLoader implements Loadable {

  public FileLoggerConfiguration load(String path) throws IOException {
    try (Reader reader = new FileReader(path)) {
      Properties prop = new Properties();
      prop.load(reader);

      String filePath = prop.getProperty("log.file.path", "./log/log.txt");
      LoggingLevel loggingLevel = (prop.getProperty("log.file.level", "info").
          equalsIgnoreCase("debug")) ? LoggingLevel.DEBUG : LoggingLevel.INFO;
      String strMaxSize = prop.getProperty("log.file.max_size", "256");

      int maxSize;
      try {
        maxSize = Integer.parseUnsignedInt(strMaxSize);
      } catch (NumberFormatException e) {
        maxSize = 256;
      }

      String defaultFormat = "^\\[[0-9]{4}-[0-1][0-9]-[0-3][0-9]\\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]\\]\\[(DEBUG|INFO|ERROR|TRACE)\\]\\sMessage:\\s\\[.*\\]\\n$";
      String format = prop.getProperty("log.file.format", defaultFormat);

      return new FileLoggerConfiguration(loggingLevel, format, filePath, maxSize);
    }
  }
}
