package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.DaoCours;
import hibernateUtil.HibernateUtil;
import model.Cours;
import model.Etudiant;
import model.Prof;

public class CoursDaoImpl implements DaoCours {
	
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


	@Override
	public List<Cours> listCours() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Cours> result = (List<Cours>) session.createQuery("from Cours").list();
	    session.getTransaction().commit();
	    return result;
	}

	@Override
	public void addCours(Cours cours) {
		
		Session session = sessionFactory.openSession();		
	    session.beginTransaction();
	    session.save(cours);
	    session.getTransaction().commit();
	    session.close();
		
	}

	@Override
	public void updateCours(Cours cours) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(cours);
        session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void deleteCours(long id) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object c =session.get(Cours.class, id);
        if(c==null) throw new RuntimeException("Cours not delete");
        session.delete(c);
        session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Cours getCours(long id) {
		
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 Object c =session.get(Cours.class, id);
		 if(c==null) throw new RuntimeException("Cours introuvable");
		 session.getTransaction().commit();
		 session.close();
		 return (Cours)c;
	}

}
