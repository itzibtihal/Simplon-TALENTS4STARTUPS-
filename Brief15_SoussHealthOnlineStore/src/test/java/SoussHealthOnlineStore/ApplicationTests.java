package SoussHealthOnlineStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import SoussHealthOnlineStore.entity.Admin;
import SoussHealthOnlineStore.service.AdminService;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Autowired
	AdminService adminService;

	
	@Test
	public void TestAdmin() {
		Admin admin = new Admin();
		//SAVE
//		admin.setEmail("oudor2000ayoub@gmail.com");
//		admin.setRole(Role.ADMIN);
//		admin.setFullName("Ayoub Oudor");
//		admin.setPassword("1234");
//		adminService.save(admin);
		//UPDATE
//		admin.setRole(Role.ADMIN);
//		admin.setFullName("AYOUB OUDOR");
//		admin.setPassword("123456789");
//		adminService.update(admin, 5);
		//DELETE
//		adminService.delete(6);
		//SHOW ALL
//		adminService.getAll();

	}
}
