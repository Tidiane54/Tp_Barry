<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produit Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
 <body>

    <%@include file="navbar.jsp" %>

    <div class="container col-md-8 offset-2 mt-5">
    <div class="container">
            <h1 style="color:blueviolet; ">Liste des produits</h1>
            <form action="search" method="get">
                 <div class="mb-3">
                     <input type="text" placeholder="Rechercher le produit ici"  name="mot" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                 <button class="btn btn-primary mt-3" type="submit" >Rechercher un produit</button>
                 </div>
             </form>
            <div class="d-flux">
               <a  href="newProduit" data-bs-toggle="modal" data-bs-target="#exampleModal"  class="btn btn-success">Ajouter</a>
            </div>
        </div>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Désignation</th>
              <th scope="col">Prix</th>
              <th scope="col">Quantite</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>


           <c:forEach  items="${listProduit}" var="produit">
                <tr>
                    <td>${produit.id}</td>
                    <td>${produit.designation}</td>
                    <td>${produit.pix}</td>
                    <td>${produit.quantity}</td>
                    <td>
                        <a class="btn btn-danger" href="delete?id=${produit.id}">Supprimer</a>
                        <a class="btn btn-primary" href="editeProduit?id=${produit.id}">Modifier</a>
                        <a class="btn btn-primary" href="detailProduit?id=${produit.id}">Détail</a>
                    </td>
                </tr>
           </c:forEach>


          </tbody>
        </table>
    </div>
     </body>
</html>