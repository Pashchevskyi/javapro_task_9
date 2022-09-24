This task is task#9 from Hillel computer school in JavaPro group.

The topic of task is "Introduction of I/O. Working with files".

This is the simpliest logger for store of messages to log files
(or, if you would like, you might extend this system to console or some other kind of logging)

You might configure the logging process. Log files are stored to "log" directory of project
(by default). Configuration file for logs is always situated in
"./config/logs.ini" file of project.

Parameters in configuration file are stored in the following format:

NAME1=VALUE1
NAME2=VALUE2
...
NAMEn=VALUEn

Meaning of configuration parameters:

FILE - path to log file

LEVEL - which kind of messages will be logged (now "debug" and "info" is supported.
Note: level "debug" contains level "info").

MAX-SIZE - integer value, which is number of bytes - maximum allowed size of log file.

FORMAT - regular expression for LOG file formatting

Configuration example is situated in "./config/logs.sample.ini" file of the Project.

To run project, please, rename "./config/logs.sample.ini" to "./config/logs.ini".
