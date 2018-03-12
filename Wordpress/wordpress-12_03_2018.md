# Wordpress

ae.giordani@gmail.com

Soutenance:

dev d'un site vitrine avec un thème perso from scratch

+ dev d'un plugin (fonctionnalité supplémentaire que n'intègre pas wordpress).

Fichier indispensable pour un thème wordpress:

-index .php

-style.css avec le contenu suivant:
```
/*
Theme Name: theme ESGI
Author: dev
Author: ESGI
*/
```
Pour ajouter une image d'illustration, on ajoute un fichier screenshot.png à la racine du thème.

Pour modifier un thème, on créer un thème enfant:

C'est un autre thème mais dans le CSS on ajoute la ligne:
```
Template: nomDuDossierDuThemeParent
```
Pour éviter que le css ne plante, il faut réimporter le css du thème parent:
```
@import url('../nomDuDossierDuThemeParent/style.css');
```
Il y à des function native de wordpress a appeler dans le thème afin de pouvoir appeler des éléments:

```
get_header();// récupère le fichier header.php du thème ou de son parent si il n'existe pas.
get_footer();// récupère le fichier footer.php du thème ou de son parent si il n'existe pas.
```

/!\ si on appel the_content() avant the_post(); on ne peux pas récupérer le contenu.