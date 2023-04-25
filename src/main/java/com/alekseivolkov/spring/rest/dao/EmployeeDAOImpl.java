package com.alekseivolkov.spring.rest.dao;

import com.alekseivolkov.spring.rest.entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        var session = sessionFactory.getCurrentSession();
        var allEmployees = session.createQuery("from Employee", Employee.class).getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        var session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        var session = sessionFactory.getCurrentSession();
        var employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        var session = sessionFactory.getCurrentSession();
        var query = session.createQuery("DELETE FROM Employee WHERE id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}


