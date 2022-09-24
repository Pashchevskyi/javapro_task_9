package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger;

public abstract class LoggerConfiguration {

  protected LoggingLevel level;
  protected String format;

  public LoggerConfiguration(LoggingLevel ll, String lf) {
    level = ll;
    format = lf;
  }
}