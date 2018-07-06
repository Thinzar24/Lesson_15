package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
        //First let's create an employee
        Employee employeezz = new Employee();
        employeezz.setName("Stephen Bullock");
        employeezz.setSsn("555-12-1234");

        //Now let's create a loptop
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");

        //Add the laptop to the employee
        employeezz.setLaptop(laptop);

        //save the employee to the database
        employeeRepository.save(employeezz);

        //Grab all the employees from the database and send them to the template
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

}
