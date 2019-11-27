/**
 * 
 */
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
/**
 * @author trevordouglas
 *
 */
public class CommandLineInterface {

	
private String mainMenuString = (
            
            "Please select the phase # that you would like to use:\n" +
            "1 - Store up to 5 Employees from the commandline.\n" +
            "2 - Store up to 100 Employees from a textfile.\n" +
            "3 - Print the employee list.\n" +
            "-1 - Exit the program.\n");
	
    /*
      This method prints the menu and
      waits until the user enters a non-zero integer.
    */
    public int getMainMenuNumber()
    {
        int numericAnswer = 0;
        while(numericAnswer == 0)
	    {
		try
		    {
			numericAnswer = getInt(mainMenuString);
		    }
		
		catch(Exception e)
		    {
			System.out.println("Only integer inputs are allowed.");
			numericAnswer = getInt(mainMenuString);
		    }
		if (numericAnswer != 1 && numericAnswer != 2 && numericAnswer != 3)
		    {
			System.out.format("%s\n", "PROG: Please try again.");
		    }
	    }
        return numericAnswer;
    }
    
    public Employee getEmployeeDataFromCLI()
    {
        String firstName = getLine("Enter employee's first name:");
        String lastName = getLine("Enter employee's last name:");
        String address = getLine("Enter employee's address:");
        String phoneNumber = getLine("Enter employee's phone number:");
        String hireDate = getLine("Enter employee's hire date:");
        float salary = getFloat("Enter employee's salary:");
        Employee newEmployee = new Employee(firstName, lastName, address, phoneNumber, hireDate, salary);
        return newEmployee;
    }
	
	
	
    private int getInt(String prompt)
    {
        int intAnswer = 0;
        Scanner in = primingInput(prompt);
        try {
	    intAnswer = in.nextInt();
	}
	
	catch(Exception e) {
	    System.out.println("Only integer inputs are allowed.");
	    in.nextLine();
	    intAnswer = getInt(prompt);
	} 
        return intAnswer;
    }
    
    private String getLine(String prompt)
    {
        String stringAnswer = "";
        Scanner in = primingInput(prompt);
        stringAnswer = in.nextLine();
        return stringAnswer;
    }
    
    private float getFloat(String prompt)
    {
        float floatAnswer = 0;
        Scanner in = primingInput(prompt);
	try {
	    floatAnswer = in.nextFloat();
	}

	catch(Exception e) {
	    System.out.println("Only floating-point inputs are allowed.");
	    in.nextLine();
	    floatAnswer = getFloat(prompt);
	}    
        return floatAnswer;
    }
	
	private Scanner primingInput(String prompt)
    {
        Scanner in = new Scanner(System.in);
        System.out.format("%s\n", prompt);
        System.out.format(">?:");
        return in;
    }
	
	public boolean readInEmployeeData(String fileName, Employee[] employeeList)
	{
		int dataIndex = 0;
		try(Scanner in = new Scanner(Paths.get("employeeData.csv"))) {
		    String line = "";
		    if (in.hasNextLine())
			{
			    line = in.nextLine();
			}
		    if (line.equals("firstName|lastName|address|phoneNumber|hireDate|salary"))
			{
			    //while (in.hasNextLine())
			    while (in.hasNextLine())
				{
				    line = in.nextLine();
				    //System.out.println(line);
				    String[] tokens = line.split("\\|");
				    String firstName = tokens[0];
				    String lastName = tokens[1];
				    String address = tokens[2];
				    String phoneNumber = tokens[3];
				    String hireDate = tokens[4];
				    //System.out.format("%s %s %s %s %s\n", firstName, lastName, address, phoneNumber, hireDate);

				    float salary = Float.parseFloat(tokens[5]);
				    
				    
				    Employee newEmployee = new Employee(firstName, lastName, address, phoneNumber, hireDate, salary);
				    
				    employeeList[dataIndex] = newEmployee;
				    dataIndex++;
				
				}
			}
		in.close();
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		return true;
		
	}

	
	
}
