## Commandes du projet



```bash
composer create-project --prefer-dist laravel/laravel Laravel

artisan make:migration create_annonce_table

artisan make:migration create_categories_table

artisan make:migration create_rating_table
```

#### Librairie pour la gestion des médias

https://docs.spatie.be/laravel-medialibrary/v7/installation-setup

```bash
composer require spatie/laravel-medialibrary:^7.0.0

artisan vendor:publish --provider="Spatie\MediaLibrary\MediaLibraryServiceProvider" --tag="migrations"

artisan migrate

artisan vendor:publish --provider="Spatie\MediaLibrary\MediaLibraryServiceProvider" --tag="config"
```

#### Librairie pour le BackOffice (voyager)

```bash
composer require tcg/voyager

artisan voyager:install

```







### notes

make:controller MonController

make:models Entity

make:auth

migrate

code:models

route:

artisan route:list -> permet de récupérer toute les routes

Grouper des routes et les restreindre (middleware) :

```PHP
Route::middleware('auth')->group( function() {
    Route::post('/api','apiController@index')->name("admin");
    Route::get('/admin','adminController@index')->name("admin");
    
});
```