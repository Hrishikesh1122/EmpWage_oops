package empwage;
import java.util.Random;
public class WageCalculator {
	private final int IS_PRESENT=1;
	private final int IS_ABSENT=0;
	private static final int IS_FULLTIME=1;
	private static final int IS_PARTTIME=2;
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
	
	public static void main(String[] args) {
		displayWelcome();
		WageCalculator fullTimeEmp =new WageCalculator(8);
		WageCalculator partTimeEmp=new WageCalculator(4);	
		Random random=new Random();
		fullTimeEmp.attendence();
		partTimeEmp.attendence();
		int ran;
		ran=1+random.nextInt(2);
		switch (ran) {
    	case IS_FULLTIME:
    		fullTimeEmp.calcDailyWage();
    		break;
    	case IS_PARTTIME:
    		partTimeEmp.calcDailyWage();
    		break;
    	}
		
	}

}
