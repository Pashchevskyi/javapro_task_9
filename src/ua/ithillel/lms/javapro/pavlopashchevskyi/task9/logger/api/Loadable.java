package ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.api;

import java.io.IOException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task9.logger.LoggerConfiguration;

public interface Loadable {

  LoggerConfiguration load(String str) throws IOException;
}
