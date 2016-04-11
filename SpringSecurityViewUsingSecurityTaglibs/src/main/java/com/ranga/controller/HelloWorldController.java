package com.ranga.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ranga.entity.Employee;
import com.ranga.service.EmployeeService;

@Controller
public class HelloWorldController {

	private static final Logger logger = Logger.getLogger(HelloWorldController.class);
	@Autowired
    private EmployeeService employeeService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}
	@RequestMapping("/createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee,ModelMap model) {
    	logger.info("Creating Employee. Data: "+employee);
    	//model.addAttribute("user", getPrincipal());
        return new ModelAndView("employeeForm");
    }
	
	 @RequestMapping("/editEmployee")
	    public ModelAndView editEmployee(@RequestParam long id, @ModelAttribute Employee employee) {
	    	logger.info("Updating the Employee for the Id "+id);
	        employee = employeeService.getEmployee(id);
	        return new ModelAndView("employeeForm", "employeeObject", employee);
	    }
	    
	    @RequestMapping("/saveEmployee")
	    public ModelAndView saveEmployee(@ModelAttribute Employee employee,ModelMap model) {
	    	logger.info("Saving the Employee. Data : "+employee);
	        if(employee.getId() == 0){ // if employee id is 0 then creating the employee other updating the employee
	            employeeService.createEmployee(employee);
	            model.addAttribute("saveMsg","success");
	        } else {
	            employeeService.updateEmployee(employee);
	            model.addAttribute("editMsg","success");
	        }
	        return new ModelAndView("redirect:getAllEmployees");
	    }
	    
	    @RequestMapping("/deleteEmployee")
	    public ModelAndView deleteEmployee(@RequestParam long id) {
	    	logger.info("Deleting the Employee. Id : "+id);
	        employeeService.deleteEmployee(id);
	        return new ModelAndView("redirect:getAllEmployees");
	    }
	
	 @RequestMapping(value = {"getAllEmployees", "/"})
	    public ModelAndView getAllEmployees(ModelMap model) {
	    	logger.info("Getting the all Employees.");
	    	model.addAttribute("user", getPrincipal());
	        List<Employee> employeeList = employeeService.getAllEmployees();
	        return new ModelAndView("employeeList", "employeeList", employeeList);
	    }
	 
	 @RequestMapping("/searchEmployee")
	    public ModelAndView searchEmployee(@RequestParam("searchName") String searchName) {  
	    	logger.info("Searching the Employee. Employee Names: "+searchName);
	    	List<Employee> employeeList = employeeService.getAllEmployees(searchName);
	        return new ModelAndView("employeeList", "employeeList", employeeList);    	
	    }
	 

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

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