package dao;

import java.util.List;

import model.Etudiant;

public interface DaoEtudiant {
	 List<Etudiant> listEtudiant();
	 void addEtudiant(Etudiant etudiant);
	 void updateEtudiant(Etudiant etudiant);
	 void deleteEtudiant(long id);
	 Etudiant getEtudiant(long id);

}
