package dao;

import java.util.List;

import model.Prof;

public interface DaoProf {
	
	 List<Prof> listProf();
	 void addProf(Prof prof);
	 void updateProf(Prof prof);
	 void deleteProf(long id);
	 Prof getProf(long id);
}
