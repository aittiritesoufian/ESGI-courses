## Commandes du projet



```bash
composer create-project --prefer-dist laravel/laravel monannonce

vagrant reload --provision
```

#### Librairie pour le BackOffice (voyager)

```bash
composer require tcg/voyager

artisan voyager:install --with-dummy

```

Si erreur à la fin de la dernière commande sur l'insertion du link, alors executer la commande suivante depuis l'invite de commande en dehors de la machine virtuelle:

```bash
php artisan storage:link
```

Création des tables annonce et rating avec le fichier de migration, exécuter la commande:

```bash
php artisan migrate
```

La table annonce utilisera les catégories existante avec voyager pour la création du contenu.

Création du BREAD bloquée car le modèle n'existe pas, on exécute la commande suivante pour le créer manuellement:

```bash
artisan make:model Annonce
```

___

```bash
artisan make:migration create_annonce_table

artisan make:migration create_rating_table

composer require pvtl/voyager-forms

composer dump-autoload && php artisan voyager-forms:install

artisan make:controller RegistrationController

composer remove pvtl/voyager-forms

composer require "laravelcollective/html"
```







### notes

make:controller MonController

make:models Entity

make:auth

migrate

// code:models

artisan route:list -> permet de récupérer toute les routes

Grouper des routes et les restreindre (middleware) :

```PHP
Route::middleware('auth')->group( function() {
    Route::post('/api','apiController@index')->name("admin");
    Route::get('/admin','adminController@index')->name("admin");
    
});
```
 history | grep artisan