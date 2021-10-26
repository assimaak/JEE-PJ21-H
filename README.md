# JEE-PJ21-H
SRA1 Project

ASSIMA Arthur, COLLARD Esteban, MEGHARI Samy, MEDAH Lisa

## Introduction
L'objectif du projet était de gérer les promotions sur le site.
Pour cela, il fallait aussi bien géré l'affichage des promotions (côté client), que l'ajout de promotion (côté administrateur).

Ce projet se distingue en 5 parties :

    La première qui consistait à modifier la visibilité du client pour l'affichage des promotions, le nombre de fois qu'un produits et présents dans le panier...

    La seconde consistait à ajouter des promotions à partir d'un identifiant de produit.

    La troisième a ajouter des promotions selon des conditions, par exemple selon une catégorie ou une marque.

    La quatrième a ajouter des codes promos qui s'applique sur l'ensemble du panier.

    La cinquième a ajouter des promotions en fonction du nombre d'article dans le panier, par exemple avec des formules tel que 2 achetés le 3ème offerts.

## Compilation 
Afin d'exécuter le projet, nous vous conseillons de cloner le projet dans le dossier *webapps* de tomcat.

Ensuite, il vous suffit de rentrer dans le dossier *JEE-PJ21-H* et d'exécuter la commande `mvn compile` qui va compiler le projet. Puis d'allumer tomcat.

## Exécuter le projet
Afin de commencer votre utilisation, il vous suffit de vous rendre sur le lien `http://localhost:8080/projet/index.jsp`

Vous avez alors le choix entre utilisé l'interface client et l'interface admin.

### Interface client

http://localhost:8080/projet/client/products.html

Dans cette interface, vous avez l'ensemble des produits disponibles avec leurs prix ainsi que leurs prix remisés s'il une promotion les concernes.

Vous avez aussi dans l'onglet en haut à droite votre panier contenant tous les objets que vous avez ajoutés.

### Interface admin

http://localhost:8080/projet/admin/forms.html

Dans cette interface, vous avez 4 questionnaires :

    Le premier sert à ajouter des promotions sur un seul article. 
    Par exemple si vous souhaitez ajouter une promotion sur le redbull vous pouvez utiliser la référence *10101010*

    Le second sert à ajouter des promotions sur des groupes d'article, par exemple sur les boissons.

    Le troisième sert à ajouter un code promotionnel à ajouter à la fin du panier.

    Le quatrième a ajouter des promotions par rapport au nombre d'article dans le panier (actuellement non fonctionnel)

