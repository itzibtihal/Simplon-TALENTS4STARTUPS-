package brief6;

public class Produits {
	private int produitsid;
	private String name;
	private String prix;
	private int categoriesid;

	public Produits(String name, String prix, int categoriesid) {
		this.name = name;
		this.prix = prix;
		this.categoriesid = categoriesid;
	}

	public Produits() {
	}

	public int getProduitsid() {
		return produitsid;
	}

	public void setProduitsid(int produitsid) {
		this.produitsid = produitsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public int getCategoriesid() {
		return categoriesid;
	}

	public void setCategoriesid(int categoriesid) {
		this.categoriesid = categoriesid;
	}

	@Override
	public String toString() {
		return "Produits [produitsid=" + produitsid + ", name=" + name + ", prix=" + prix + ", categoriesid="
				+ categoriesid + "]";
	}
}
