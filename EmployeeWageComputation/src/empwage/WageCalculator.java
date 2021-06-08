/***********************************************
 * @author Hrishikesh Ugavekar
 * @version 1.1
 * @since 07-06-2021
 ***********************************************/
package empwage;
import java.util.Random;
public class WageCalculator implements IWageCalculator {
	private static final int IS_FULLTIME=1;
	private static final int IS_PARTTIME=2;
	
	private int companyIndex=0;
	//Array of objects of class CompanyFieldSetter
	CompanyFieldSetter CompanyArray[]=new CompanyFieldSetter[10];
	
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
	public  int calcWages(CompanyFieldSetter CompanyFieldSetter) {
		int ran;
		int TotalWage=0;
		int countHrs=0;
		int countDays=0;
		int DailyWage=0;
		Random random=new Random();
		ran=1+random.nextInt(2);
		while(countHrs<CompanyFieldSetter.maxWorkingHrs && countDays<CompanyFieldSetter.workDaysInMonth)
		{
			switch (ran) {
    		case IS_FULLTIME:
    			DailyWage=CompanyFieldSetter.fullDayHrs*CompanyFieldSetter.wagePerHr;
    			TotalWage+=DailyWage;
    			countHrs+=8;
    			countDays++;
    			break;
    		case IS_PARTTIME:
    			DailyWage=CompanyFieldSetter.partDayHrs*CompanyFieldSetter.wagePerHr;
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
	public void storeWagesToArray() {
		for (int i=0;i<companyIndex;i++)
		{
			CompanyArray[i].setTotalEmpWage(this.calcWages(CompanyArray[i]));
			System.out.println(CompanyArray[i]);
		}
	}
	/**
	 * Sets fields to objects in CompanyArray
	 * @param companyName
	 * @param fullDayHrs
	 * @param partDayHrs
	 * @param workDaysInMonth
	 * @param wagePerHr
	 * @param maxWorkingHrs
	 */
	public void setCompanyFields(String companyName,int fullDayHrs,int partDayHrs,int workDaysInMonth,int wagePerHr,int maxWorkingHrs ) {
			CompanyArray[companyIndex]=new CompanyFieldSetter(companyName,fullDayHrs,partDayHrs,workDaysInMonth,wagePerHr,maxWorkingHrs);
			companyIndex++;
	}
	
	public static void main(String[] args) {
		displayWelcome();
		WageCalculator companies=new WageCalculator();
		companies.setCompanyFields("Dmart",8,4,20,200,100);
		companies.setCompanyFields("More",10,5,20,250,100);
		companies.storeWagesToArray();
	}

}
