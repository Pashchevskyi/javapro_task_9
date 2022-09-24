package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger;

import java.io.IOException;

public abstract class LoggerConfigurationLoader {

  public abstract LoggerConfiguration load(String str) throws IOException;
}
