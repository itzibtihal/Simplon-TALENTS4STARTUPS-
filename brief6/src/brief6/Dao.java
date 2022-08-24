package brief6;

public interface Dao {

	// CREATE categorie
	public Categories save(Categories item);

	// CREATE produits
	public Produits save(Produits item);

	// READ categorie
	Categories getById(int id);

	// READ produits
	Produits getById1(int produitsid);

	// READ produits d'une categorie
	Produits getById2(int id);

	// update categorie
	public void update(int id, Categories item);

	// update produits
	public void update(int produitsid, Produits item);

	// delete categorie
	public void delete(int id);

	// delete produits
	public void delete1(int produitsid);

}
