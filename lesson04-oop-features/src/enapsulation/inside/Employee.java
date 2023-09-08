package enapsulation.inside;

public class Employee extends EmpInfo{
	public static void main(String[] args) {
		Company company = new Company();
		System.out.println(company.numberOfEmployee);
		
		Employee inside = new Employee();
		System.out.println(inside.name);
		System.out.println(inside.salary);
		System.out.println(inside.skills);
	}
}
