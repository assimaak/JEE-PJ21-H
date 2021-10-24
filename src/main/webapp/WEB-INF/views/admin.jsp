<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Web Drive Admin</title>
    <meta http-equiv='Content-Type' content='text/html'/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
    <script src="https://unpkg.com/bootstrap-datepicker@1.9.0/dist/locales/bootstrap-datepicker.fr.min.js"
            charset="UTF-8"></script>

</head>
<body>

<div class="container p-3 my-3 bg-primary text-white">
    <h1>Web Drive : Admin</h1>
    <p>Ajoutez des promotions temporaires au Web Drive.</p>
</div>

<div class="container p-3 my-3 bg-light text-dark">
    <form:form action="promotionArticle.html" method ="POST" modelAttribute="promotionOneArticle">
        <br>
        <div class="form-check form-check-inline">
            <form:radiobutton path="typeReduc" value="pourcentage"/>
            <label class="form-check-label" for="pourcent">Pourcentage</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="typeReduc" value="valeur"/>
            <label class="form-check-label" for="css">Valeur</label>
        </div>
        <form:input path="valeur" type="text" class="form-control" id="valeur_reduc" placeholder="Réduction"/>
        <br>
        <div class="form-group">
            <label for="reference">Référence</label>
            <form:input path="reference"/>
        </div>
        <br>
        <div class="input-daterange input-group" id="datepicker1">
            <label for="start">Promotion valide du </label>
            <form:input path="dateStart" />
            <span class="input-group-addon"> au </span>
            <form:input path="dateEnd" />
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

</div>

<div class="container p-3 my-3 bg-light text-dark">
    <h2>Ajout d'une promo sur un ensemble d'articles</h2>
    <form>
        <br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" id="pourcentage" name="type_reduc" value="pourcentage">
            <label class="form-check-label" for="pourcent">Pourcentage</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" id="valeur" name="type_reduc" value="valeur">
            <label class="form-check-label" for="css">Valeur</label>
        </div>
        <input type="text" class="form-control" id="valeur_reduc" placeholder="Réduction">
        <br>
        <div class="form-group">
            <label for="reference">Référence</label>
            <input type="text" class="form-control" id="reference" placeholder="Référence">
        </div>
        <br>
        <div class="input-daterange input-group" id="datepicker2">
            <label for="start">Promotion valide du </label>
            <input type="text" class="input-sm form-control" name="start"/>
            <span class="input-group-addon"> au </span>
            <input type="text" class="input-sm form-control" name="end"/>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>
<div class="container p-3 my-3 bg-light text-dark">
    <h2>Ajout d'une promo sur un panier</h2>
    <form>
        <br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" id="pourcentage" name="type_reduc" value="pourcentage">
            <label class="form-check-label" for="pourcent">Pourcentage</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" id="valeur" name="type_reduc" value="valeur">
            <label class="form-check-label" for="css">Valeur</label>
        </div>
        <input type="text" class="form-control" id="valeur_reduc" placeholder="Réduction">
        <br>
        <div class="form-group">
            <label for="code">Code Promo à entrer par le client</label>
            <input type="text" class="form-control" id="code" placeholder="Code promo">
        </div>
        <br>
        <div class="input-daterange input-group" id="datepicker3">
            <label for="start">Promotion valide du </label>
            <input type="text" class="input-sm form-control" name="start"/>
            <span class="input-group-addon"> au </span>
            <input type="text" class="input-sm form-control" name="end"/>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<div class="container p-3 my-3 bg-light text-dark">
    <h2>Ajout d'une opération marketing</h2>
    <form>
        <br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" id="ungratuit" name="type_ope" value="ungratuit">
            <label class="form-check-label" for="pourcent">X + 1 gratuit</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" id="deuxieme" name="type_ope" value="deuxieme">
            <label class="form-check-label" for="css">Deuxième à -X%</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" id="lot" name="type_ope" value="lot">
            <label class="form-check-label" for="css">X à Y€</label>
        </div>
        <input type="text" class="form-control" id="valeur_reduc" placeholder="Réduction">
        <br>
        <div class="form-group">
            <label for="reference">Référence</label>
            <input type="text" class="form-control" id="reference" placeholder="Référence">
        </div>
        <br>
        <div class="input-daterange input-group" id="datepicker4">
            <label for="start">Promotion valide du </label>
            <input type="text" class="input-sm form-control" name="start"/>
            <span class="input-group-addon"> au </span>
            <input type="text" class="input-sm form-control" name="end"/>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script>
    $("#datepicker1").datepicker({format: "dd-mm-yyyy", language: "fr"});
    $("#datepicker2").datepicker({format: "dd-mm-yyyy", language: "fr"});
    $("#datepicker3").datepicker({format: "dd-mm-yyyy", language: "fr"});
    $("#datepicker4").datepicker({format: "dd-mm-yyyy", language: "fr"});
</script>

</body>
</html>