/***********************************************
 * Purpose Public interface to achieve abstraction 
 * @author Hrishikesh Ugavekar
 * @version 1.1
 * @since 08-06-2021
 ***********************************************/
package empwage;

public interface IWageCalculator {
	void setCompanyFields(String companyName,int fullDayHrs,int partDayHrs,int workDaysInMonth,int wagePerHr,int maxWorkingHrs );
	int calcWages(CompanyFieldSetter CompanyFieldSetter);
	void storeWagesToCollection();
	int getTotalWage(String companyName); 	
}
