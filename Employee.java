/**
 * 
 */
/**
 * @author trevordouglas
 *
 */
public class Employee
{
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String hireDate;
    private float salary;

    public Employee (
        String firstName, String lastName, String address, String phoneNumber,
        String hireDate, float salary)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.hireDate = hireDate;
            this.salary = salary;
        }

    public String getfirstName()
    {
        return this.firstName;
    }

    public void setfirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getlastName()
    {
        return this.lastName;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public String getHireDate()
    {
        return this.hireDate;
    }

    public float getsalary()
    {
        return this.salary;
    }

    public void printEmployeeData()
    {
        System.out.format(
            "Name: %s %s| Address: %s| Phone Number: %s|" +
            " Hire Date: %s| salary: $%f \n",
            this.firstName,
            this.lastName,
            this.address,
            this.phoneNumber,
            this.hireDate,
            this.salary);
    }
}

