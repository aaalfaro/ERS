package tests;



import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import org.junit.Test;
import static org.junit.Assert.*;
public class DaoTests {

	
	@Test
	public void test1() {
		Employee emp = new Employee();
		emp.setUsername("pokeMaster");
		emp.setPassword("charizard");
		assertTrue(EmployeeService.check(emp));
	}
	
	@Test
	public void test2() {
		Employee emp = new Employee();
		emp.setUsername("billybob");
		assertFalse(EmployeeService.check(emp));
	}
	
	
}
