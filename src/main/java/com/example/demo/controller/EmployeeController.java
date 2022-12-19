package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/read-employee")
    public  String showReadEmployeePage(ModelMap model) {
        model.addAttribute("employees", employeeService.findAll());
        return "reademployee";
    }

    @RequestMapping("/create-employee")
    public String showCreateEmployeePage(Model model) {
        model.addAttribute("command", new Employee());
        return "createemployee";
    }

    @RequestMapping(value = "/create-employee", method = RequestMethod.POST)
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/read-employee";
    }

    @RequestMapping(value = "/update-employee/{id}")
    public String showUpdateEmployeePage(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", employeeService.findById(id).orElse(null));
        return "updateemployee";
    }


    @RequestMapping(value = "/update-employee/{id}", method = RequestMethod.POST)
    public String updateEmployee(@PathVariable int id, @ModelAttribute("contact") Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/read-employee";
    }

    @RequestMapping(value = "/delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
        return "redirect:/read-employee";
    }

}
