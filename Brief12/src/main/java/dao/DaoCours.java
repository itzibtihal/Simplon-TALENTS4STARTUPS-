package dao;

import java.util.List;

import model.Cours;

public interface DaoCours {
	
	 List<Cours> listCours();
	 void addCours(Cours cours);
	 void updateCours(Cours cours);
	 void deleteCours(long id);
	 Cours getCours(long id);

}
