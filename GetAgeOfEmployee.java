import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
/**
 * 
 * @author Yashwant
 * Parse an array of employee Pojos to calculate sum of ages of all Employee
 */
public class GetAgeOfEmployee {

	public static int getAge(List<Employee> emplist){
		return emplist.stream().mapToInt((x)->x.getAge()).sum();
		
	}
	
	public static void main(String arg[]){
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("A", 30));
		employeeList.add(new Employee("B", 40));
		employeeList.add(new Employee("C", 30));
		employeeList.add(new Employee("D", 20));
		employeeList.add(new Employee("E", 22));

	   // Get sum of all employee's Age
		System.out.println("Sum of Age of All Employee : " + getAge(employeeList));
		
		
		//when Stats are require Java 8 have summaryStatistics API
		IntSummaryStatistics empStatics = employeeList.stream().mapToInt((x) -> x.getAge()).summaryStatistics();
		System.out.println("Highest Employe Age in List : " + empStatics.getMax());
		System.out.println("Lowest Employe Age in List : " + empStatics.getMin());
		System.out.println("Sum of all Employe Age : " + empStatics.getSum());
		System.out.println("Average of all Employe Age : " + empStatics.getAverage());
		
	
	}
}
