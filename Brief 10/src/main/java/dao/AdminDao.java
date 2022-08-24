package dao;

import model.Admin;

public interface AdminDao {

	public void addAdmin(Admin a);
	public void updateAdmin(Admin a);
	public boolean validate(String username, int password);

}
