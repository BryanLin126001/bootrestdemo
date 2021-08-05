package ntt.global.springboot.bootrestdemo.service;

import ntt.global.springboot.bootrestdemo.entity.Employee;

import java.util.List;

public interface IService
{
    List<Employee> findAll();

    Employee find(int id);

    void save(Employee employee);

    void delete(int id);
}
