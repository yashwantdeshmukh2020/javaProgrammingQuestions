/**
 * 
 * @author Yashwant
 *
 */
public class Employee {
	private static String Name;
	private static int Age;
	

	public Employee(String name2, int age2) {
		this.Name=name2;
		this.Age=age2;
	}


	public static String getName() {
		return Name;
	}


	public static void setName(String name) {
		Name = name;
	}


	public static int getAge() {
		return Age;
	}


	public static void setAge(int age) {
		Age = age;
	}


	@Override
	public String toString() {
		return "Employee [toString()=" + super.toString() + "]";
	}
	
	
}
