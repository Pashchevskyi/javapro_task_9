package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger;

public abstract class Logger {

  protected LoggerConfiguration loggerConfiguration;

  public Logger(LoggerConfiguration lc) {
    loggerConfiguration = lc;
  }

  public void trace(String message) {
    if (loggerConfiguration.level == LoggingLevel.TRACE) {
      log(message, "trace");
    }
  }

  public void debug(String message) {
    if (loggerConfiguration.level == LoggingLevel.TRACE
        || loggerConfiguration.level == LoggingLevel.DEBUG) {
      log(message, "debug");
    }
  }

  public void info(String message) {
    if (loggerConfiguration.level == LoggingLevel.TRACE
        || loggerConfiguration.level == LoggingLevel.DEBUG ||
        loggerConfiguration.level == LoggingLevel.INFO) {
      log(message, "info");
    }
  }

  public void warn(String message) {
    if (loggerConfiguration.level == LoggingLevel.TRACE
        || loggerConfiguration.level == LoggingLevel.DEBUG ||
        loggerConfiguration.level == LoggingLevel.INFO
        || loggerConfiguration.level == LoggingLevel.WARN) {
      log(message, "warn");
    }
  }

  public void error(String message) {
    if (loggerConfiguration.level == LoggingLevel.TRACE
        || loggerConfiguration.level == LoggingLevel.DEBUG ||
        loggerConfiguration.level == LoggingLevel.INFO
        || loggerConfiguration.level == LoggingLevel.WARN ||
        loggerConfiguration.level == LoggingLevel.ERROR) {
      log(message, "error");
    }
  }

  public abstract void log(String message, String level);
}
