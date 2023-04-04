package fa.training.dao.impl;

import fa.training.dao.EmployeeDao;
import fa.training.entity.Employee;
import fa.training.util.XmlConnectionConfig;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getAll() {
        try(Session session = XmlConnectionConfig.getSession()) {
            return session.createQuery("SELECT e FROM Employee e",
                                        Employee.class)
                    .getResultList();
        }
    }

    @Override
    public void create(Employee employee) {
        try(Session session = XmlConnectionConfig.getSession()){
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Employee employee) {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Employee id cannot be null");
        }
        try(Session session = XmlConnectionConfig.getSession()){
            session.beginTransaction();
            session.merge(employee);
            session.getTransaction().commit();
        }
    }
}
