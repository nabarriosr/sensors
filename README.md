### SENSORS SYSTEM


## Comments
- SystemIntegrated class is the main class to run, and emulate the system
(please run from there or for compile)
- Exist three types of logs: 
    * RegisterAll that is all the history of every sensor
    * ResgisterLast that is the history since the last check of the monitor
    * RegisterCheck that is the history of the review of parameters
- From the console is possible set teh parameters M and S
- Its possible improve teh independency of the launch signals every 500 miliseconds creating a complexer logic for the timer
- The timer of the monitor and the sensors can hit after toomany cycles but that can be solved improving the math of the timer
- The console will show when appear one anomaly
- For this version the class of sensors interact directly, to implement one interaction with HTTP must be implemented a maven service, it can be coded
- For testing the two functionalities are checkProblems of diferent numbers after the determination of S and M, and call the registers to verify that fucntionalities
- On SystemIntegarted the rate time for sensors and monitor are hardcoded( that cna be changed or ever be a parameter) and its not using two times per minute for monitor just to show examples, but can be changed.
