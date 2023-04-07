import fa.training.dao.EmployeeDao;
import fa.training.dao.impl.EmployeeDaoImpl;
import fa.training.entity.Account;
import fa.training.entity.Employee;
import fa.training.enums.EmployeeType;

public class Main {
    public static void main(String[] args) {
//        XmlConnectionConfig.getSession();

        Employee employee1 = new Employee();
        employee1.setFullName("John");
        employee1.setEmail("John@example.com");
        employee1.setEmployeeType(EmployeeType.PART_TIME);

        Account account1 = new Account();
        account1.setEmpAccount("emp01");
        account1.setPassword("123");
        account1.setEmployee(employee1);
        employee1.setAccount(account1);


        Employee employee2 = new Employee();
        employee2.setFullName("Mary");
        employee2.setEmail("Mary@example.com");
        employee1.setEmployeeType(EmployeeType.FULL_TIME);

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.create(employee1);
        employeeDao.create(employee2);

        employeeDao.getAll().forEach(System.out::println);
    }
}
