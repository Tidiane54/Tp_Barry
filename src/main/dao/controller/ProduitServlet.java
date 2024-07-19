package controller;


import model.Produit;
import repository.ProduitImplDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//Controller
@WebServlet("/")
public class ProduitServlet extends HttpServlet {
    private ProduitImplDao produitRepository;
    @Override
    public void init() throws ServletException {
        produitRepository = new ProduitImplDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();
        RequestDispatcher dispatcher;
        switch (action){
            case "/list":
                List<Produit> produits = produitRepository.selectAllProduits();
                req.setAttribute("listProduit",produits);
                dispatcher = req.getRequestDispatcher("liste-produit.jsp");
                dispatcher.forward(req,resp);
                break;
            case "/delete":
                System.out.println("delete");
                int id = Integer.parseInt(req.getParameter("id"));
                produitRepository.deleteProduit(id);
                resp.sendRedirect("list");
                break;
            case "/newProduit":
                req.getRequestDispatcher("form-produit.jsp").forward(req,resp);
                break;
            case "/editeProduit":
                int idUpt = Integer.parseInt(req.getParameter("id"));
                Produit produit = produitRepository.getElementByID(idUpt);
                req.setAttribute("produit",produit);
                req.getRequestDispatcher("edit-produit.jsp").forward(req,resp);
                break;
            case "/detailProduit":
                int idDetail = Integer.parseInt(req.getParameter("id"));
                Produit produitDetail = produitRepository.getElementByID(idDetail);
                req.setAttribute("produit",produitDetail);
                req.getRequestDispatcher("detail-produit.jsp").forward(req,resp);
                break;
            case "/search":
                String mot = req.getParameter("mot");
                List<Produit> produitsSearch = produitRepository.search(mot);
                req.setAttribute("listProduit",produitsSearch);
                dispatcher =  req.getRequestDispatcher("liste-produit.jsp");
                dispatcher.forward(req,resp);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        RequestDispatcher dispatcher;

        switch (action){
            case "/saveProduct":
                Produit produit = new Produit(
                        req.getParameter("designation"),
                        Double.parseDouble(req.getParameter("pix")),
                        Integer.parseInt(req.getParameter("quantity")));
                produitRepository.insertProduit(produit);
                resp.sendRedirect("list");
                break;
            case  "/updateProduct" :
                Produit produitUpt = new Produit(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("designation"),
                        Double.parseDouble(req.getParameter("pix")),  // Correction ici
                        Integer.parseInt(req.getParameter("quantity")) // Correction ici
                );
                produitRepository.updateProduit(produitUpt);
                resp.sendRedirect("list");
                break;
        }
    }
}
