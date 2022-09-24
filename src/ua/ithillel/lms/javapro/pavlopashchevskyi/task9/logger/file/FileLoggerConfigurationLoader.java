package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfigurationLoader;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggingLevel;

public class FileLoggerConfigurationLoader extends LoggerConfigurationLoader {

  public LoggerConfiguration load(String path) {
    String filePath = "";
    LoggingLevel loggingLevel = LoggingLevel.DEBUG;
    int maxSize = 0;
    String format = "";
    try (Reader reader = new FileReader("./config/logs.ini")) {
      int r;
      StringBuilder sb = new StringBuilder();
      while ((r = reader.read()) != -1) {
        sb.append((char) r);
      }
      String str = sb.toString().replaceAll("\r\n\r\n", "\n").trim();
      String[] settings = str.split("\n");
      String[][] settingsValues = new String[settings.length][];
      int j = 0;
      for (String setting : settings) {
        if (setting.contains("=")) {
          settingsValues[j] = setting.split("=");
          j++;
        }
      }
      for (String[] settingsValue : settingsValues) {
        switch (settingsValue[0].toLowerCase()) {
          case "file": {
            try {
              filePath = settingsValue[1];
            } catch (ArrayIndexOutOfBoundsException e) {
              filePath = "./log/log.txt";
            }
          }
          break;
          case "level": {
            try {
              loggingLevel = (settingsValue[1].equalsIgnoreCase("debug")) ?
                  LoggingLevel.DEBUG : LoggingLevel.INFO;
            } catch (ArrayIndexOutOfBoundsException e) {
              loggingLevel = LoggingLevel.INFO;
            }
          }
          break;
          case "max-size": {
            try {
              maxSize = Integer.parseInt(settingsValue[1]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
              maxSize = 256;
            }
          }
          break;
          case "format": {
            try {
              format = settingsValue[1];
            } catch (ArrayIndexOutOfBoundsException e) {
              format = "^\\[[0-9]{4}-[0-1][0-9]-[0-3][0-9]\\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]\\]\\[(DEBUG|INFO|ERROR|TRACE)\\]\\sСообщение:\\s\\[.*\\]\\n$";
            }
          }
          break;
        }
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return new FileLoggerConfiguration(loggingLevel, format, filePath, maxSize);
  }
}
