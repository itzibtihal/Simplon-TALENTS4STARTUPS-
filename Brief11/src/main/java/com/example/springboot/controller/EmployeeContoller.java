package com.example.springboot.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.springboot.model.Admin;
import com.example.springboot.model.Employee;
import com.example.springboot.services.EmployeeService;
import com.example.springboot.services.impl.AdminService;

@Controller
public class EmployeeContoller {
	
    @Autowired
    private EmployeeService employeeService;

   
    @GetMapping("/")  
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("admin", new Admin()); 
        return mav;
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute("admin") Admin admin) {
    	System.out.println("Hello !");

//    	Admin authAdmin = AdminService.login(admin.getUsername(), admin.getPassword());
//
//        System.out.print(authAdmin); 
//        
//        if (Objects.nonNull(authAdmin)) {
//
//            return "employeeList"; 
//
//        } else {
//            return "redirect:/";  
//        }
    	return "employeeList";
    }
   
    @GetMapping("/logout")
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/";
    }
    
    
    @GetMapping("/employeeList")
    public String employeeList(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employeeList";   
    } 

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeAdd";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "employeeUpdate";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.employeeService.deleteEmployee(id);
        return "redirect:/";
    }
    
    

}
