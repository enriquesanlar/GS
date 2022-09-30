package com.ejecicio.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejecicio.main.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Procedure
    Employee getEmployee_(int id);

    @Procedure
    List<Employee> getEmployees_();

    @Procedure
    int insertEmployee(String lastName, String name);
    
}
