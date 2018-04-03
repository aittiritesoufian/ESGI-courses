#  I. A qui peuvent servir les réseaux informatiques aujourd'hui ?

## Evolution de l'informatique depuis 50 ans

#### 1980 : Les réseaux sont peu développés,

Les MAINFRAME sont des super-calculateurs utilisés pour des calculs scientifiques ou du traitement de texte.

Les architectures sont centralisés.

#### 1990 : Evolution des réseaux, Boom de l'internet;

Applications client-serveur:

1. Client ---REQUETE---> Serveur
2. Serveur ---REPONSE---> Client

Applications pair-à-pair :

Client/serveur ---REQUETE---> Client/Serveur ---REQUETE---> Client/serveur

Client/serveur ---REPONSE---> Client/Serveur ---REPONSE---> Client/serveur

Architectures distribuées : (AOL, Alice, Wanadoo, Free, ...).

#### 1991 : Création du langage HTML (MSN, SkyBlog, ...).

#### 2000 : Apparition de la virtualisation (Plusieurs machines virtuelles sur une même machine Serveur).

Le réseau c'est ainsi développé, souvent une machine virtuelle (VM) = une application Serveur. (Si une application tombe les autres services sur le serveur physique continue de fonctionner).

Les machines deviennent VOLATILES. (Début de l'externalisation des services et des services d'infogérence)

On-Promise : internalisation des infrastructures.

#### 2010 : Cloud-Computing : S'appuis sur la virtualisation et permet par exemple de louer un système d'exploitation ou un service 

- qui est accessible à distance (par le réseau/by network)
- qui est accessible à la demande (on-demand), 
- dont l'utilisation est payée à l'usage (pay per use, pay as you go)

#### 2020 : Big Data & IA

Puissance de calcul et des réseaux ouvrent de nouveaux horizons.

# II. Définitions et symboles

## A. Définition fonctionnelle d'un réseau

Un réseau informatique désigne un ensemble de prériphériques (entité / équipement / noeud / device / terminaux) interconnectés dans le but d'effectuer des communications.

### Vue macroscopique :

Réseau d'entreprise (utilisateurs, interne, caméras, etc...)

Réseau internet (réseau de réseaux)

### Vue microscopique :

Réseau personnel (PC, imprimantes, ...).

## B. Périphériques finaux/intermédiaires

### finaux

C'est pour les périphériques finaux que le réseau est créé.

Ils sont les émetteurs initiaux de données ou les recepteurs finaux.

ex: ordinateur, imprimante, smartphone, ...

Les périphériques intermédiaires 

### intermédiaires

Les périphériques intermédiaires servent à faire fonctionner le réseau.

ex: switch, Hub, Routeur, Borne Wifi.

## C. Etendue d'un réseau

Distance qui sépare les 2 périphériques les plus éloignés dans le réseau :

(Schema étendue des réseaux)

## D. Symboles

(screen symboles)

# III. Le modèle de référence TCP-IP

Chaque constructeur réseau mettait en avant sa solution réseau (avec ses propres normes) ce qui freinait le développement des réseaux. Il a alors été mis en place un modèle de référence définissant les règles de la communication, dans le but de les uniformisés.

Construit en 4 couches:

4 - Application (Données)

3 - Transport (Segment(TCP) / Datagramme (UDP))

2 - Internet (Paquet)

1 - Accès Réseau (Trames)

sens de circulation des informations des couches 4 --> 1 = encapsulation.

sens de circulation des informations des couches 1--> 4 = décapsulation.

(capture schema modèle)

La couche application met en forme la données (chiffrement, déchiffrement, UTF8, ASCII...)

La couche transport permet de faire communiquer les applications entre elles.

La couche internet permet de faire arriver le datagramme ou segment dans le réseau du destinataire final.

PDU = Protocole Data Unit (représenter l'élément à chaque couche de l'application).

La couche accès réseau permet de faire circuler le paquet au sein d'un réseau.

