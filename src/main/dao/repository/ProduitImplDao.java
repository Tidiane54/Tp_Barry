package repository;




import model.SingletonConnection;
import model.Produit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitImplDao {

    //Insérer produit
    public void insertProduit(Produit produit){
        SingletonConnection db = new SingletonConnection();
        String $sql =" Insert into produit (designation,pix,quantity) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement($sql);
            preparedStatement.setString(1, produit.getDesignation());
            preparedStatement.setDouble(2,produit.getPix());
            preparedStatement.setInt(3, produit.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    //Supprimer
    public void deleteProduit(int id){
        SingletonConnection db = new SingletonConnection();
        String $sql =" Delete from produit where id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement($sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produit> selectAllProduits(){
        SingletonConnection db = new SingletonConnection();
        List<Produit> produits = new ArrayList<>();
        String $sql =" SELECT * from produit";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement($sql);
            ResultSet rs= preparedStatement.executeQuery();

            while(rs.next()){
                Produit produit = new Produit(
                        rs.getInt("id"),
                        rs.getString("designation"),
                        rs.getDouble("pix"),
                        rs.getInt("quantity")
                );
                produits.add(produit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }

    public void updateProduit(Produit produit){
        SingletonConnection db = new SingletonConnection();
        String sql = "Update produit set designation = ?, pix = ?, quantity = ? where id = ?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, produit.getDesignation());
            preparedStatement.setDouble(2,produit.getPix());
            preparedStatement.setInt(3, produit.getQuantity());
            preparedStatement.setInt(4, produit.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Produit getElementByID(int id){
        SingletonConnection db = new SingletonConnection();
        String sql = "SELECT * from produit where id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                Produit produit = new Produit(
                        rs.getInt("id"),
                        rs.getString("designation"),
                        rs.getDouble("pix"),
                        rs.getInt("quantity"));
                return produit;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }



    public List<Produit> search (String mot){
        SingletonConnection db = new SingletonConnection();
        List<Produit> produits = new ArrayList<>();
        String $sql ="SELECT * from produit where designation LIKE ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement($sql);
            preparedStatement.setString(1,"%"+mot+"%");
            ResultSet rs=  preparedStatement.executeQuery();

            while(rs.next()){
                Produit produit = new Produit(
                        rs.getInt("id"),
                        rs.getString("designation"),
                        rs.getDouble("pix"),
                        rs.getInt("quantity")
                );
                produits.add(produit);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }

}

