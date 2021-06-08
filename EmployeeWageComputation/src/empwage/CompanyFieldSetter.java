/*******************************************************
 * Purpose : POJO for company object
 * @author Hrishikesh Ugavekar
 * @Version 1.1
 * @since 08-06-2021
 *
 ******************************************************/
package empwage;
public class CompanyFieldSetter {
	public int fullDayHrs;
	public int partDayHrs;
	public int workDaysInMonth;
	public int wagePerHr;
	public int maxWorkingHrs;
	public int getMaxWorkingHrs() {
		return maxWorkingHrs;
	}

	public void setMaxWorkingHrs(int maxWorkingHrs) {
		this.maxWorkingHrs = maxWorkingHrs;
	}

	public String companyName;
	

	/**
	 * This constructor assigns company name and their standard working hours.
	 * @param companyName
	 * @param fullDayHrs
	 * @param partDayHrs
	 * @param workDaysInMonth
	 * @param wagePerHr
	 */
	CompanyFieldSetter(String companyName,int fullDayHrs,int partDayHrs,int workDaysInMonth,int wagePerHr,int maxWorkingHrs){
		this.companyName=companyName;
		this.fullDayHrs=fullDayHrs;
		this.partDayHrs=partDayHrs;
		this.workDaysInMonth=workDaysInMonth;
		this.wagePerHr=wagePerHr;
		this.maxWorkingHrs=maxWorkingHrs;
	}
	
	public int getFullDayHrs() {
		return fullDayHrs;
	}

	public void setFullDayHrs(int fullDayHrs) {
		this.fullDayHrs = fullDayHrs;
	}

	public int getPartDayHrs() {
		return partDayHrs;
	}

	public void setPartDayHrs(int partDayHrs) {
		this.partDayHrs = partDayHrs;
	}

	public int getWorkDaysInMonth() {
		return workDaysInMonth;
	}

	public void setWorkDaysInMonth(int workDaysInMonth) {
		this.workDaysInMonth = workDaysInMonth;
	}

	public int getWagePerHr() {
		return wagePerHr;
	}

	public void setWagePerHr(int wagePerHr) {
		this.wagePerHr = wagePerHr;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int totalEmpWage;
	@Override
	public String toString() {
		return "CompanyFieldSetter [totalEmpWage=" + totalEmpWage + "]";
	}

	public int getTotalEmpWage() {
		return totalEmpWage;
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	
	

}
