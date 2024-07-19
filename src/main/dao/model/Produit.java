package model;

public class Produit {
    private int id;
    private String designation;
    private Double pix;
    private  Integer quantity;

    //Géneration de constructeur

    public Produit(int id, String designation, Double pix, Integer quantity) {
        this.id = id;
        this.designation = designation;
        this.pix = pix;
        this.quantity = quantity;
    }

    public Produit(String designation, double pix, int quantity) {
        this.designation = designation;
        this.pix = pix;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public Double getPix() {
        return pix;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPix(Double pix) {
        this.pix = pix;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", pix=" + pix +
                ", quantity=" + quantity +
                '}';
    }
}
