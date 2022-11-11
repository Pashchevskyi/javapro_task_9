package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger;

import java.util.HashMap;
import java.util.Map;

public abstract class LoggerConfigurationLoader {

  protected static final Map<String, LoggingLevel> supportingLoggingLevels = new HashMap<>();

  public LoggerConfigurationLoader() {
    supportingLoggingLevels.put("error", LoggingLevel.ERROR);
    supportingLoggingLevels.put("warn", LoggingLevel.WARN);
    supportingLoggingLevels.put("info", LoggingLevel.INFO);
    supportingLoggingLevels.put("debug", LoggingLevel.DEBUG);
    supportingLoggingLevels.put("trace", LoggingLevel.TRACE);
  }

  public abstract LoggerConfiguration load(String str);
}
