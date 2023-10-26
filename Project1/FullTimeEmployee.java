public class FullTimeEmployee extends Employee{
    public static int salary=140000;
    protected int ServingYearsNumber;
    protected int vacation=0;
    
    public FullTimeEmployee(){}

    public FullTimeEmployee(String address, String fullName, int ServingYearsNumber,boolean serving) {
        super(address, fullName,serving);
        this.ServingYearsNumber = ServingYearsNumber;
    }
    
    public void UpdateYear()
    {
        ServingYearsNumber++;
    }
    
    public void CalcLeave()
    {
        if(ServingYearsNumber<10)
        vacation=15+ServingYearsNumber;
        else 
        vacation=25;
        System.out.println("Employee's Years number is "+ServingYearsNumber+" and he has "+vacation+" vacations .");
    }
    
    @Override
    public void addVacation()
    {
        vacation++;
    }
    @Override
    public void getVacation()
    {
        System.out.println("Vacations are "+vacation);
    }
    @Override
    public void report()
    {
        super.report();
        System.out.println("Salary is "+salary);
        this.CalcLeave();
        getVacation();
    }
    
}
