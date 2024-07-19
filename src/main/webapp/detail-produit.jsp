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
            <h1 style="color:blueviolet; ">Détail de Produit</h1>
        </div>
 <div class="container">
     <form action="updateProduit" method="post"  #values="ngForm" >
        <br>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label"><h4>ID</h4></label>
            <p>${produit.id}</p>
        </div>
       <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label"><h4>Designation</h4></label>
          <p>${produit.designation}</p>
        </div>
       <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label"><h4>Prix</h4></label>
          <p>${produit.pix}</p>
       </div>
       <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label"><h4>Quantity</h4></label>
          <p>${produit.quantity}</p>
       </div>
         <a class="btn btn-primary" href="list">Rétour</a>
       </form>
     </div>
    </div>
     </body>
</html>