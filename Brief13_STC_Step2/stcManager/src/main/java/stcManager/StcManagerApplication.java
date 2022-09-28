package stcManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import stcManager.entity.Activite;
import stcManager.service.ActiviteService;

@SpringBootApplication
public class StcManagerApplication implements CommandLineRunner{
//	@Autowired
//	private AdminRepository  adminRepository;
	public static void main(String[] args){
		SpringApplication.run(StcManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//AdminService  adminService  = new AdminService();
		//Admin admin = new Admin(1L,"oudor","ayoub","oudour2000ayoub@gmail.com","ayoub1234","1234","0651407775","active");
		//adminRepository.save(admin);
		//adminRepository.deleteById(1L);
		//System.out.println(admin);
//		ActiviteService activiteService = new ActiviteService();
//		Activite activite = new Activite(1L,"app mobile","create new app mobile","Dev Mobile","2022-02-15","2022-08-15","active",1,1);
//		activiteService.save(activite);
	}

}
