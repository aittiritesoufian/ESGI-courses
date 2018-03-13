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

Pour afficher déclencher l'affichage du bouton "Read More" on ajoute le code suivant dans le contenu de l'article:
```
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua.<!-- more --> Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
```

Pour déclarer toutes les fonctionnalités du thème (menus, widgets etc...), on créer un fichier functions.php dans lequel on insère l'ensemble des fonctions à executer.

Pour executer une fonciton, on appel add_action qui prendra en paramètre un event (moment à laquel executer la fonction), ainsi que le nom de la fonction à executer.
```
add_action('event','functionToExecute');
```

Requis pour le projet à la soutenance:
-Avoir des paramétrages en back.
-Avoir un rendu en front.

Pour ajouter un short code on utilise la méthode add_shortcode(), elle prend en premier paramètre le label utilisé dans le shortcode, en second l'appel de la fonction à exécuter:

```php
add_shortcode('test','test_func'); 

function test_func(){
	echo '<p>Test du shortcode réussi !</p>';
} 
```

## Création d'un plugin

Par défaut le fichier utiliser par wordpress est le fichier portant le même nom que le répertoire du plugin.

```
monplugin/monplugin.php
```



Ajout d'un message dans le wp-footer automatiquement à l'affichage du plugin:

```PHP
add_action("wp_footer",'Add_Text');

function Add_Text(){
	echo "<p>Quand le footer est chargé et le plugin activé, on affiche ce paragraphe.</p>";
}
```

On peux faire la même chose avec le wp_head afin d'ajouter du CSS à charger.

Pour ne pas avoir à insérer trop de contenu dans le fichier de fonction par défaut du plugin, on peux faire des includes d'autres fichiers.

