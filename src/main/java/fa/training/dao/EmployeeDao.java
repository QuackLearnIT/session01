package fa.training.dao;

import fa.training.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAll();

    void create(Employee employee);

    public void update(Employee employee);
}
