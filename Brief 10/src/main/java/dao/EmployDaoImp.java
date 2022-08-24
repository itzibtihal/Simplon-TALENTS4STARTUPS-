package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateUtil.HibernateUtil;
import model.Employe;

public class EmployDaoImp  implements Dao{
	
	
	   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public List<Employe> listEmploye() {
		
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Employe> result = (List<Employe>) session.createQuery("from Employe").list();
	    session.getTransaction().commit();
	    return result;
	    
	}
	

	@Override
	public Employe getEmploye(long id) {
		
		 Session session = sessionFactory.openSession();	
         session.beginTransaction();
         Object e =session.get(Employe.class, id);
         if(e==null) throw new RuntimeException("Employe introuvable");
         session.getTransaction().commit();
	     session.close();
	     return (Employe)e;
	}

	@Override
	public void addEmploye(Employe e) {
		
		    Session session = sessionFactory.openSession();		
		    session.beginTransaction();
		    session.save(e);
		    session.getTransaction().commit();
		    session.close();
		
	}

	@Override
	public void updateEmploye(Employe e) {

	    Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void deleteEmploye(long id) {
		
		 Session session = sessionFactory.openSession();	
         session.beginTransaction();
         Object e =session.get(Employe.class, id);
         if(e==null) throw new RuntimeException("Employe not delete");
         session.delete(e);
         session.getTransaction().commit();
		 session.close();
		
	}

}
