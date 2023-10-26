import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.border.EmptyBorder;
public class ProjectEmployee {
    static Scanner input= new Scanner(System.in); 
    public static boolean printVacation(ArrayList<Employee> employee,int number)
    {
        for(Employee e:employee)
            if(e instanceof LongServingEmployee || e instanceof FullTimeEmployee)
            {
                if(e.getEmployeeNumber()==number)
                e.getVacation();
                return true;
            }    
            return false;
    }
    public static void printAllEndEmployee(ArrayList<Employee> employee)
    {
        for(Employee e:employee)
            if(e.serving==false)
                {
                    e.report();
                    System.out.println();
                }
    }
    public static boolean addVacation(ArrayList<Employee> employee,int number)
    {
        for(Employee e:employee)
            if(e instanceof LongServingEmployee || e instanceof FullTimeEmployee)
            {
                if(e.getEmployeeNumber()==number)
                e.addVacation();
                return true;
            }
            return false;
    }
    public static boolean endServing(ArrayList<Employee> employee,int number)
    {
        for(Employee e:employee)
            if(e.getEmployeeNumber()==number)
            {
                e.serving=false;
                return true;
            }

            return  false;
    }
    public static void removeEmployee(ArrayList<Employee> employee,int number,Section firstsSection,Section secondSection)
    {
        for(Employee e:employee)
        if(e.getEmployeeNumber()==number)
        { 
            employee.remove(e);
            firstsSection.removeEmployee(e);
            secondSection.removeEmployee(e);
            break;
        }
    }
    public static void addEmployee(ArrayList<Employee> employee,Section firstsSection,Section secondSection){
        System.out.println("enter the employee type : 1.fullTimeEmployee  2.LongServingEmployee 3.PartTimeEmployee  .");
            int type=input.nextInt();
            switch(type)
            {
                case 1:
                {
                    System.out.println("enter personal information of employee :");
                    System.out.println("enter his name :");
                    String name=input.next();
                    System.out.println("enter his address :");
                    String address =input.next();
                    System.out.println("enter number of years of service : ");
                    int yearsNumber=input.nextInt();
                        Employee fullTimeEmployee = new FullTimeEmployee(address, name, yearsNumber, true);
                    System.out.println("enter his birthdate as following order :day,month, year");
                    int day=input.nextInt();
                    int month=input.nextInt();
                    int year=input.nextInt();
                    fullTimeEmployee.setBirthDate(day, month, year);
                    employee.add(fullTimeEmployee);
                    System.out.println("which department would you like to join ? 1.IT   2.Marketing");
                    int num=input.nextInt();
                    if(num==1)
                    firstsSection.addEmployee(fullTimeEmployee);
                    else if(num==2)
                    secondSection.addEmployee(fullTimeEmployee);
                    else 
                    System.out.println("Wrong input .");
                }
                break;
                case 2:
                {
                    System.out.println("enter personal information of employee :");
                    System.out.println("enter his name :");
                    String name=input.next();
                    System.out.println("enter his address :");
                    String address =input.next();
                    System.out.println("enter number of years of service : ");
                    int yearsNumber=input.nextInt();
                    Employee longservingEmployee=new LongServingEmployee(address, name, yearsNumber, true);
                    System.out.println("enter his birthdate as following order :day,month, year");
                    int day=input.nextInt();
                    int month=input.nextInt();
                    int year=input.nextInt();
                    longservingEmployee.setBirthDate(day, month, year);
                    employee.add(longservingEmployee);
                    System.out.println("which department would you like to join ? 1.IT   2.Marketing");
                    int num=input.nextInt();
                    if(num==1)
                    firstsSection.addEmployee(longservingEmployee);
                    else if(num==2)
                    secondSection.addEmployee(longservingEmployee);
                    else
                    System.out.println("wrong input .");
                }
                break;
                case 3:
                {
                    System.out.println("enter personal information of employee :");
                    System.out.println("enter his name :");
                    String name=input.next();
                    System.out.println("enter his address :");
                    String address =input.next();
                    System.out.println("enter employee's workedhours :");
                    int workedHours=input.nextInt();
                    
                    Employee partTimeEmployee=new PartTimeEmployee(address, name, workedHours,true);
                    System.out.println("enter his birthdate as following order :day,month, year");
                    int day=input.nextInt();
                    int month=input.nextInt();
                    int year=input.nextInt();
                    partTimeEmployee.setBirthDate(day, month, year);
                    employee.add(partTimeEmployee);
                    System.out.println("which department would you like to join ? 1.IT   2.Marketing");
                    int num=input.nextInt();
                    if(num==1)
                    firstsSection.addEmployee(partTimeEmployee);
                    else if(num==2)
                    secondSection.addEmployee(partTimeEmployee);
                    else 
                    System.out.println("Worng input .");
                }
            }
    }
    public static void main(String[] args) {
        ArrayList<Employee> employee =new ArrayList<Employee>();
        
        ArrayList<Section> section =new ArrayList<Section>();
        Employee ITHead=new FullTimeEmployee("medin", "Anas", 25, true);
        ITHead.setBirthDate(1, 1, 1995);
        Employee MarketingHead=new LongServingEmployee("Baramkeh", "Hadi", 24, true);
        MarketingHead.setBirthDate(2, 2, 1991);
        Section firstSection=new Section(211, "IT", ITHead);
        Section secondSection=new Section(212, "Marketing", MarketingHead);        
        int num=1;
        while(num!=0)
        {
            System.out.println("if you want to add employee ,press 1 ");
            System.out.println("if you want to delete an employee ,press 2");
            System.out.println("if you want to finish an employee's service ,press 3");
            System.out.println("if you want to add leave for the employee ,press 4");
            System.out.println("if you want to show the records of all retired employess ,press 5");
            System.out.println("if you want to show the vacation payable to an employee ,press 6");
            System.out.println("if you want to show employees in a depatment ,press 7");
            System.out.println("if you want to show each department and the number of employees in it ,press 8");
            System.out.println("if you want to close the program ,press 0 ");
            System.out.println("Enter your choice :");
            num=input.nextInt();
            switch(num)
            {
                case 1:
                    addEmployee(employee,firstSection,secondSection);
                break;
                case 2:
                {
                    System.out.println("Enter the employee number you want to delete :");
                    int number=input.nextInt();
                    removeEmployee(employee, number,firstSection,secondSection);
                }
                break;
                case 3:
                {
                    System.out.println("Enter the employee's number whose service you want to terminate :");
                    int number=input.nextInt();
                    if(endServing(employee, number)==false)
                        System.out.println("there is no employee with this number .");                   
                }
                break;
                case 4:
                {
                    System.out.println("Enter employee's number to add leave to him :");
                    int number=input.nextInt();
                    addVacation(employee, number);
                }
                break;
                case 5:
                    printAllEndEmployee(employee);
                break;
                case 6:
                {
                    System.out.println("Enter employee's number whose vacations you want to know :");
                    int number=input.nextInt();
                    if(printVacation(employee, number)==false);
                        System.out.println("there is no employee with this number .");                   

                }
                break;
                case 7:
                {
                    System.out.println("we have two sections : 1.IT    2.Marketing");
                    int n=input.nextInt();
                    if(n==1)
                    firstSection.printSectionInfo();
                    else if(n==2)
                    secondSection.printSectionInfo();
                    else 
                    System.out.println("Wrong input .");
                }
                break;
                case 8:
                {
                    firstSection.printSectionInfo();
                    secondSection.printSectionInfo();
                }
                break;
                case 0:
                break;                
                default :
                System.out.println("Wrong input .");
            }
        }
    }
}
