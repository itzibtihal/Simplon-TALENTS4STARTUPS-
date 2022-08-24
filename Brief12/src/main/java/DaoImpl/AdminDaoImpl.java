package DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.DaoAdmin;
import model.Admin;

public class AdminDaoImpl  implements DaoAdmin{
	
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public void addAdmin(Admin admin) {
		
		Session session = sessionFactory.openSession();		
	    session.beginTransaction();
	    session.save(admin);
	    session.getTransaction().commit();
	    session.close();
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(admin);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteAdmin(long id) {
		// TODO Auto-generated method stub
		
	}

}
