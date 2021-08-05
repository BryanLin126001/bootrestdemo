package ntt.global.springboot.bootrestdemo.repository;

import ntt.global.springboot.bootrestdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeDAO extends BaseDAO<Employee> implements IDAO<Employee>
{
    public EmployeeDAO(EntityManager entityManager)
    {
        super(entityManager);
    }
}
