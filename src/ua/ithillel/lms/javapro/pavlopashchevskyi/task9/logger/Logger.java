package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger;

public abstract class Logger {

  protected LoggerConfiguration loggerConfiguration;

  public Logger(LoggerConfiguration lc) {
    loggerConfiguration = lc;
  }

  public void debug(String message) {
    if (loggerConfiguration.level == LoggingLevel.DEBUG) {
      log(message, "debug");
    }
  }

  public void info(String message) {
    log(message, "info");
  }

  public abstract void log(String message, String level);
}
