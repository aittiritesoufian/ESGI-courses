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

