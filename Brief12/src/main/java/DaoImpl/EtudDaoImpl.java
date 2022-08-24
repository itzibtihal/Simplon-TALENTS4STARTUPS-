package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.DaoEtudiant;
import hibernateUtil.HibernateUtil;
import model.Etudiant;
import model.Prof;

public class EtudDaoImpl implements DaoEtudiant {
	
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public List<Etudiant> listEtudiant() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Etudiant> result = (List<Etudiant>) session.createQuery("from Etudiant").list();
	    session.getTransaction().commit();
	    return result;
	}

	@Override
	public void addEtudiant(Etudiant etudiant) {
		
		Session session = sessionFactory.openSession();		
	    session.beginTransaction();
	    session.save(etudiant);
	    session.getTransaction().commit();
	    session.close();
		
	}

	@Override
	public void updateEtudiant(Etudiant etudiant) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(etudiant);
        session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void deleteEtudiant(long id) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Prof.class, id);
        if(e==null) throw new RuntimeException("Etudiant not delete");
        session.delete(e);
        session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Etudiant getEtudiant(long id) {
		
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 Object e =session.get(Etudiant.class, id);
		 if(e==null) throw new RuntimeException("Etudiant introuvable");
		 session.getTransaction().commit();
		 session.close();
		 return (Etudiant)e;
	}

}
