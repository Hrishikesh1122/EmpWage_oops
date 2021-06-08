/***********************************************
 * @author Hrishikesh Ugavekar
 * @version 1.1
 * @since 07-06-2021
 ***********************************************/
package empwage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
public class WageCalculator implements IWageCalculator {
	private static final int IS_FULLTIME=1;
	private static final int IS_PARTTIME=2;
	
	//List of objects of class CompanyFieldSetter
	private  static LinkedList<CompanyFieldSetter> CompanyList;
	//Hash map to store total wage along with company name
	private Map<String,CompanyFieldSetter> CompanyMap;
	public WageCalculator()
	{
		CompanyList=new LinkedList<>();
		CompanyMap=new HashMap<>();
	}
	
	/**
	 * Displays Welcome message on console
	 */
	private static void displayWelcome() {
		System.out.println("Welcome to Employee Wage calculator");
	}

	/**
	 * @return Total wage 
	 * Calculates total wages till a condition is reached (Different conditions for different companies)
	 */
	public  int calcWages(CompanyFieldSetter companyList) {
		int ran;
		int TotalWage=0;
		int countHrs=0;
		int countDays=0;
		int DailyWage=0;
		Random random=new Random();
		ran=1+random.nextInt(2);
		while(countHrs<companyList.getMaxWorkingHrs() && countDays<companyList.getWorkDaysInMonth())
		{
			switch (ran) {
    		case IS_FULLTIME:
    			DailyWage=companyList.fullDayHrs*companyList.wagePerHr;
    			TotalWage+=DailyWage;
    			countHrs+=8;
    			countDays++;
    			break;
    		case IS_PARTTIME:
    			DailyWage=companyList.partDayHrs*companyList.wagePerHr;
    			TotalWage+=DailyWage;
    			countHrs+=4;
    			countDays++;
    			break;
    	    }
			
		}
		return TotalWage;
	}
	/**
	 * Stores total wage in Company Array
	 */
	public void storeWagesToCollection() {
		for (int i=0;i<CompanyList.size();i++)
		{
			CompanyFieldSetter companyList= CompanyList.get(i);
			companyList.setTotalEmpWage(this.calcWages(companyList));
			System.out.println(companyList);
		}
	}
	/**
	 * Sets fields to objects in CompanyList
	 * @param companyName
	 * @param fullDayHrs
	 * @param partDayHrs
	 * @param workDaysInMonth
	 * @param wagePerHr
	 * @param maxWorkingHrs
	 */
	public void setCompanyFields(String companyName,int fullDayHrs,int partDayHrs,int workDaysInMonth,int wagePerHr,int maxWorkingHrs ) {	
		CompanyFieldSetter companyList = new CompanyFieldSetter(companyName,fullDayHrs,partDayHrs,workDaysInMonth,wagePerHr,maxWorkingHrs);
	    CompanyList.add(companyList);
	    CompanyMap.put(companyName,companyList);
	    System.out.println(companyList);			
	}
	
	
	public static void main(String[] args) {
		displayWelcome();
		WageCalculator companies=new WageCalculator();
		companies.setCompanyFields("Dmart",8,4,20,200,100);
		companies.setCompanyFields("More",10,5,20,250,100);
		companies.storeWagesToCollection();
		
	}

}
