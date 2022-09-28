package stcManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stcManager.entity.Admin;
import stcManager.service.AdminService;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/Admin")
public class AdminController {
	
    @Autowired
    private AdminService adminService;
	
	@PostMapping("/STCManager/save")
	public Admin AddAdmin(@RequestBody Admin admin) {
		adminService.save(admin);
		return admin;
	} 
    @DeleteMapping("/STCManager/delete/{roll}")
    public long deleteadmin(@PathVariable long roll) {
        adminService.delete(roll);
        return roll;
    }
	@PostMapping("/STCManager/update/{roll}")
	public Admin updateadmin(@RequestBody Admin admin,@PathVariable long roll) {
		adminService.update(admin, roll);
		return admin;
	}
    @RequestMapping("/STCManager/list")
    public List<Admin> List() {
    	return adminService.getAll();
    }
    @RequestMapping("/STCManager/list/{roll}")
    public Admin getadmin(@PathVariable long roll) {
    	return adminService.getById(roll);     
    } 
}
