/***********************************************
 * @author Hrishikesh Ugavekar
 * @version 1.0
 * @since 07-06-2021
 ***********************************************/
package empwage;
import java.util.Random;
public class WageCalculator {
	private final int IS_PRESENT=1;
	private final int IS_ABSENT=0;
	private static final int IS_FULLTIME=1;
	private static final int IS_PARTTIME=2;
	private int fullDayHrs;
	private int partDayHrs;
	private int workDaysInMonth;
	private int wagePerHr;
	private String companyName;
	/**
	 * @param dayHrs
	 * Assigns hours per day for different type of employees
	 */
	WageCalculator(String companyName,int fullDayHrs,int partDayHrs,int workDaysInMonth,int wagePerHr){
		this.companyName=companyName;
		this.fullDayHrs=fullDayHrs;
		this.partDayHrs=partDayHrs;
		this.workDaysInMonth=workDaysInMonth;
		this.wagePerHr=wagePerHr;
	}
	
	
	/**
	 * Displays Welcome message on console
	 */
	private static void displayWelcome() {
		System.out.println("Welcome to Employee Wage calculator");
	}
	/**
	 * Displays information about company's standard working hours
	 */
	private void dispCompanyInfo() {
		System.out.println("Company name   : "+companyName);
		System.out.println("Full Day hours : "+fullDayHrs);
		System.out.println("Part Day hours : "+partDayHrs);
		System.out.println("Working days in month : "+workDaysInMonth);
		System.out.println("Wage Per Hr : "+wagePerHr);
	}
	/**
	 * @return 1 if employee is present otherwise 0
	 */
	private int attendence() {
    	int ran;
    	Random random=new Random();
    	ran=random.nextInt(2);
		System.out.println(ran);
		if(ran==IS_PRESENT)
			return IS_PRESENT;
		else
			return IS_ABSENT;
    }
	/**
	 * @return Wage per day
	 */
	private int calcDailyWage() {
	    	int dailyWage = wagePerHr*fullDayHrs;
	    	return dailyWage;
	}
	/**
	 * @return Part time wage per day
	 */
	private int calcPartDayWage() {
    	int partTimeDailyWage = wagePerHr*partDayHrs;
    	return partTimeDailyWage;
}
	/**
	 * @return monthly wage of the employee
	 */
	private int calcMonthlyWage() {
		int monthlyWage = workDaysInMonth*wagePerHr*fullDayHrs;
		return monthlyWage;
	}
	/**
	 * @return Total wage 
	 * Calculating wages till number of hrs reaches 100 or Working days reaches 20
	 */
	private  int calcWages() {
		int ran;
		int TotalWage=0;
		int countHrs=0;
		int countDays=0;
		Random random=new Random();
		ran=1+random.nextInt(2);
		while(countHrs<100 && countDays<workDaysInMonth)
		{
			switch (ran) {
    		case IS_FULLTIME:
    			TotalWage+=calcDailyWage();
    			countHrs+=8;
    			countDays++;
    			break;
    		case IS_PARTTIME:
    			TotalWage+=calcPartDayWage();
    			countHrs+=4;
    			countDays++;
    			break;
    	    }
			
		}
		return TotalWage;
	}
	
	public static void main(String[] args) {
		displayWelcome();
		WageCalculator company1=new WageCalculator("D Mart",8,4,25,30);
		company1.dispCompanyInfo();
		company1.attendence();
		company1.calcMonthlyWage();
		company1.calcDailyWage();
		company1.calcWages();
		
		WageCalculator company2=new WageCalculator("Reliance Fresh",10,6,28,300);
		company2.dispCompanyInfo();
		company2.attendence();
		company2.calcMonthlyWage();
		company2.calcDailyWage();
		company2.calcWages();
	}

}
