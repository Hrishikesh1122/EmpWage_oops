package empwage;
import java.util.Random;
public class WageCalculator {
	private final int IS_PRESENT=1;
	private final int IS_ABSENT=0;
	private static final int IS_FULLTIME=1;
	private static final int IS_PARTTIME=2;
	private static final int WORK_DAYS_IN_MONTH=20;
	private final int WAGE_PER_HR=20;
	private int dayHrs;
	
	/**
	 * @param dayHrs
	 * Assigns hours per day for different type of employees
	 */
	WageCalculator(int dayHrs){
		this.dayHrs=dayHrs;
	}
	
	
	/**
	 * Displays Welcome message on console
	 */
	private static void displayWelcome() {
		System.out.println("Welcome to Employee Wage calculator");
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
	    	int dailyWage = WAGE_PER_HR*dayHrs;
	    	return dailyWage;
	}
	/**
	 * @return monthly wage of the employee
	 */
	private int calcMonthlyWage() {
		int monthlyWage = WORK_DAYS_IN_MONTH*WAGE_PER_HR*dayHrs;
		return monthlyWage;
	}
	/**
	 * @return Total wage 
	 * Calculating wages till number of hrs reaches 100 or Working days reaches 20
	 */
	private static int calcWages() {
		int ran;
		int TotalWage=0;
		int countHrs=0;
		int countDays=0;
		WageCalculator fullTimeEmp1 =new WageCalculator(8);
		WageCalculator partTimeEmp1=new WageCalculator(4);
		Random random=new Random();
		ran=1+random.nextInt(2);
		while(countHrs<100 && countDays<WORK_DAYS_IN_MONTH)
		{
			switch (ran) {
    		case IS_FULLTIME:
    			TotalWage+=fullTimeEmp1.calcDailyWage();
    			countHrs+=8;
    			countDays++;
    			break;
    		case IS_PARTTIME:
    			TotalWage+=partTimeEmp1.calcDailyWage();
    			countHrs+=4;
    			countDays++;
    			break;
    	    }
			
		}
		return TotalWage;
	}
	
	public static void main(String[] args) {
		displayWelcome();
		WageCalculator fullTimeEmp =new WageCalculator(8);
		WageCalculator partTimeEmp=new WageCalculator(4);	
		fullTimeEmp.attendence();
		partTimeEmp.attendence();
		fullTimeEmp.calcDailyWage();
		partTimeEmp.calcDailyWage();
		fullTimeEmp.calcMonthlyWage();
		partTimeEmp.calcMonthlyWage();
		calcWages();				
	}

}
