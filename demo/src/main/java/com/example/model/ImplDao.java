package com.example.model;

import com.example.demo.Candidat;
import com.example.demo.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class ImplDao implements Idao<Candidat> {

    @Override
    public boolean create(Candidat c) {
        try {
            Connexion.get_connection();
            String sql = "INSERT INTO candidat "
                    + "(idcandidat,nom,prenom,email,adresse,pays) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = Connexion.get_connection().prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getAdresse());
            ps.setString(6, c.getPays());
            ps.executeUpdate();

            ps.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println(c.getPrenom()+ " "+c.getNom()+ " vient de s'inscrire !");
        return false;
    }

    @Override
    public boolean update(Candidat c) {
        try {
            String sql = "UPDATE candidat SET "
                    +"nom=?,prenom=?,email=?,adresse=?,pays=?"
                    + " WHERE idcandidat = "+c.getId();
            //System.out.println("ID = "+id);
            PreparedStatement ps = Connexion.get_connection().prepareStatement(sql);

            ps.setInt(1,c.getId());
            ps.setString(2,c.getNom());
            ps.setString(3,c.getPrenom());
            ps.setString(4,c.getEmail());
            ps.setString(5,c.getAdresse());
            ps.setString(6,c.getPays());
            ps.setInt(1, c.getId());
            int i = ps.executeUpdate();
            if(i==1) {
                System.out.println("Mise a jour du candidat ayant l'id "+c.getId() +" effectuee");
            }
            else {
                System.out.println("Mise a jour echouee");
            }
            ps.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Candidat c) {
        try {
            String sql = "DELETE from candidat WHERE idcandidat = "+c.getId();
            PreparedStatement stmt = Connexion.get_connection().prepareStatement(sql);
            int i = stmt.executeUpdate();
            if(i==1)
                System.out.println("Le candidat ayant l'id"+c.getId()+" a ete supprime avec succès...");
//	      //étape 5: fermez l'objet de connexion
            else System.out.println("oups!");
            stmt.close();
        }

        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }


    @Override
    public Candidat findById(int id) {
        return null;
    }

    @Override
    public List<Candidat> findAll() {
        List<Candidat> candidats = new ArrayList<Candidat>();
        try {
            PreparedStatement ps = Connexion.get_connection().prepareStatement("SELECT * FROM candidat");
            ResultSet rs =ps.executeQuery();
            ResultSetMetaData resultMeta = rs.getMetaData();
            System.out.println("- Il y a " + resultMeta.getColumnCount() +
                    " colonnes lignes dans la table");
            while(rs.next()){
                Candidat cdt = new Candidat();
                cdt.setId(rs.getInt("idcandidat"));
                cdt.setNom(rs.getString("nom"));
                cdt.setPrenom(rs.getString("prenom"));
                cdt.setEmail(rs.getString("email"));
                cdt.setAdresse(rs.getString("adresse"));
                cdt.setPays(rs.getString("pays"));

                candidats.add(cdt);
            }

            rs.close();

        }
        catch(Exception e){
            e.getStackTrace();
        }
        return candidats;
    }
}
