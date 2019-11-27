# 374-Lab-Assignment-6

This assignment was designed to demonstrate defensive programming. We were provided with a fragile Java application and tasked with adding exception handlers in order to fortify the application against faulty input. Below are the changes that I made to the application:

# 1. EmployeeTest.java

- A try-catch exception handler was implemented in the main() method, where the readInEmployeeData() method is invoked, in order to prevent an ArrayIndexOutOfBounds error.

# 2. CommandLineInterface.java 

- A try-catch exception handler was implemented in the getMainMenuNumber() method in order for the application to withstand any invalid inputs for menu navigation; i.e. any input not equalling 1, 2, or 3). The only invalid input that was handled in the original application was input 0.

- A try-catch exception handler was implemented in the getInt() method in order for the application to withstand any non-integer inputs for required integer values.

- A try-catch exception handler was implemented in the getFloat() method in order for the application to withstand any non-float inputs for the salary attribute.

- A try-catch exception handler was implemented in the readInEmployeeData() method for the case where the *employeeData.csv* spreadsheet cannot be found in any path on a computer's file directory, which thus prevents an IOException error from occurring.
