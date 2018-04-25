On à un dialogue dans lequel il y à des étapes.

Chaque étape est une fonction

La conversation c'est un ensemble de dialogues sous forme de pile

Le dernier dialogue de la pile sera la première donnée affichée (LIFO).

Si la pile est vide, on prend la default Dialog

La fonction de base est :

```JS
var bot = new builder.UniversalBot(connector, []);
```

Chaque fonction envoi à la fonction suivante les résultats qu'elle récupère.

#### Stockage de données

stockage de données dans UserData, DialogData, on utilisera la fonction next().

#### Style de dialogs:

prompt.choice()

si au format auto dépend de :

1. du contenu
2. du channel

### API Wrapper SpaceX

https://github.com/Thomas-Smyth/SpaceX-API-Wrapper

