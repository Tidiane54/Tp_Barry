<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produit Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
 <body>

    <%@include file="navbar.jsp" %>
        <div class="container">
                    <form action="saveProduct" method="post"  #values="ngForm" >
                      <h2 style="color:blue;">Ajouter le produit </h2>
                      <br>
                      <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Designation</label>
                        <input type="text"  name="designation" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                      </div>
                      <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Prix</label>
                        <input type="number" name="pix" class="form-control" id="pix" required >
                      </div>
                      <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Quantite</label>
                        <input type="number" name="quantity" class="form-control" id="exampleInputPassword1" required>
                      </div>
                        <button type="button"  class="btn btn-secondary" data-bs-dismiss="modal" name="annuler">Fermer</button>
                        <button type="submit" class="btn btn-success m-lg-1" name="save">Ajouter</button>
                    </form>
                  </div>
     </body>
</html>