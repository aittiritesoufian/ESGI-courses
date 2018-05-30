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









### notes

make:controller MonController

make:models Entity

make:auth

migrate

code:models

route:

artisan route:list -> permet de récupérer toute les routes



