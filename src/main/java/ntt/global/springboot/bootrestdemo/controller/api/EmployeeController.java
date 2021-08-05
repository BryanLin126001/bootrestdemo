package ntt.global.springboot.bootrestdemo.controller.api;

import ntt.global.springboot.bootrestdemo.entity.Employee;
import ntt.global.springboot.bootrestdemo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController
{
    private IService service;

    @Autowired
    public EmployeeController(@Qualifier("employeeService") IService service)
    {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return service.findAll();
    }




}
