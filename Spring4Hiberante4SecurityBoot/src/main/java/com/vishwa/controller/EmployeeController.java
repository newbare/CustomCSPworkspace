package com.vishwa.controller;
import com.vishwa.entity.Employee;
import com.vishwa.service.EmployeeService;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ranga Reddy
 * @version 1.0
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	public EmployeeController() {
		System.out.println("EmployeeController()");
		logger.info("EmployeeController()");
	}

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
    	logger.info("Creating Employee. Data: "+employee);
        return new ModelAndView("employeeForm");
    }
    
    @RequestMapping("/editEmployee")
    public ModelAndView editEmployee(@RequestParam long id, @ModelAttribute Employee employee) {
    	logger.info("Updating the Employee for the Id "+id);
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeForm", "employeeObject", employee);
    }
    
    @RequestMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
    	logger.info("Saving the Employee. Data : "+employee);
        if(employee.getId() == 0){ // if employee id is 0 then creating the employee other updating the employee
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:getAllEmployees");
    }
    
    @RequestMapping("/deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam long id) {
    	logger.info("Deleting the Employee. Id : "+id);
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:getAllEmployees");
    }
    
    @RequestMapping(value = {"/getAllEmployees","/login"})
    public ModelAndView getAllEmployees() {
    	logger.info("Getting the all Employees.");
        List<Employee> employeeList = employeeService.getAllEmployees();
        return new ModelAndView("employeeList", "employeeList", employeeList);
    }
    
    @RequestMapping("/searchEmployee")
    public ModelAndView searchEmployee(@RequestParam("searchName") String searchName) {  
    	logger.info("Searching the Employee. Employee Names: "+searchName);
    	List<Employee> employeeList = employeeService.getAllEmployees(searchName);
        return new ModelAndView("employeeList", "employeeList", employeeList);    	
    }
    
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "welcome";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}
	
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}*/

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}