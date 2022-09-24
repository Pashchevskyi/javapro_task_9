package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.file;

import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfiguration;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggingLevel;

public class FileLoggerConfiguration extends LoggerConfiguration {

  private final String filePath;
  private final int maxSize;

  public FileLoggerConfiguration(LoggingLevel ll, String lf, String filePath, int maxSize) {
    super(ll, lf);
    this.filePath = filePath;
    this.maxSize = maxSize;
  }

  public String getFilePath() {
    return filePath;
  }

  public int getMaxSize() {
    return maxSize;
  }
}
