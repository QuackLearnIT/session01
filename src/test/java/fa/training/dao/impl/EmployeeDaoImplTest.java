package fa.training.dao.impl;

import fa.training.dao.AccountDao;
import fa.training.dao.EmployeeDao;
import fa.training.entity.Account;
import fa.training.entity.Employee;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeDaoImplTest {

    static EmployeeDao employeeDao;
    static AccountDao accountDao;

    @BeforeAll
    static void beforeAll() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    void create_EmpRequireInfo_Success() {
        Employee employee = new Employee();
        employee.setFullName("Nguyen Van A");
        employee.setEmail("employee01@gmail.com");
        assertDoesNotThrow(() -> employeeDao.create(employee));
    }

    @Test
    void create_EmpRequireInfo_Insert_Faled() {
        Employee employee = new Employee();
//        employee.setFullName("Nguyen Van A");
        employee.setEmail("employee01@gmail.com");
        assertThrows(PersistenceException.class, () -> employeeDao.create(employee));
    }

    @Test
    void cascadeTypePersist_Success_Test() {
        Employee employee = new Employee();
        employee.setFullName("emp03");
        employee.setEmail("emp3@gmail.com");

        String empAccount = "emp03_account";
        Account account = new Account();
        account.setEmpAccount("emp03_account");
        account.setPassword("123123");
        account.setEmployee(employee);
        employee.setAccount(account);

        employeeDao.create(employee);
        Optional<Account> accountOptional = accountDao.findById(empAccount);
        assertTrue(accountOptional.isPresent()
                && accountOptional.get().getEmpAccount().equals(empAccount));
    }
}