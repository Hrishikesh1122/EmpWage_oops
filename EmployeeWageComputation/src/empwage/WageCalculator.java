package empwage;
import java.util.Random;
public class WageCalculator {
	private final int IS_PRESENT=1;
	
	/**
	 * Displays Welcome message on console
	 */
	private void displayWelcome() {
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
			return 1;
		else
			return 0;
   }

	public static void main(String[] args) {
		WageCalculator w =new WageCalculator();
		w.displayWelcome();
		w.attendence();

	}

}
