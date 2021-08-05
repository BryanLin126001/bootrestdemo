package ntt.global.springboot.bootrestdemo.service;

import ntt.global.springboot.bootrestdemo.entity.Employee;
import ntt.global.springboot.bootrestdemo.repository.IDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IService
{
    private IDAO<Employee> employeeDao;

    public EmployeeService(IDAO<Employee> employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> findAll()
    {
        return employeeDao.findAll();
    }
}
