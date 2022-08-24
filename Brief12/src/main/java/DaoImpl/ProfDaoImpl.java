package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.DaoProf;
import hibernateUtil.HibernateUtil;
import model.Prof;

public class ProfDaoImpl implements DaoProf{
	
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public List<Prof> listProf() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Prof> result = (List<Prof>) session.createQuery("from Prof").list();
	    session.getTransaction().commit();
	    return result;
	}

	@Override
	public void addProf(Prof prof) {
		
		Session session = sessionFactory.openSession();		
	    session.beginTransaction();
	    session.save(prof);
	    session.getTransaction().commit();
	    session.close();
		
	}

	@Override
	public void updateProf(Prof prof) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(prof);
        session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void deleteProf(long id) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object p =session.get(Prof.class, id);
        if(p==null) throw new RuntimeException("Prof not delete");
        session.delete(p);
        session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Prof getProf(long id) {
		
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 Object p =session.get(Prof.class, id);
		 if(p==null) throw new RuntimeException("Prof introuvable");
		 session.getTransaction().commit();
		 session.close();
		return (Prof)p;
	}

}
