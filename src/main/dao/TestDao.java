

import repository.ProduitImplDao;


public class TestDao {
    public static void main(String[] args) {
        ProduitImplDao userRepository = new ProduitImplDao();
        //userRepository.insertUser(new User("Barry","atbr54@gamail.com","GN"));
        //userRepository.deleteUser(1);
        userRepository.selectAllProduits().forEach(produit -> System.out.println(produit.toString()));
    }
}
