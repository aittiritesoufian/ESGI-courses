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

# IV. Le modèle de référence OSI

7 couches :

7. Application (capter les données)


6. Présentation (cryptage, mise en forme)


5. Session (ouvrire, clore la donnée)


4. Transport ()


3. Réseau


2. Liaison de données

1. Physique

Encapsulation/désencapsulation:

Construits les données et les différentes informations sur chaque couches, (7-1), le serveur la désencapsule pour récupérer la donnée initiale (1-7).

Le PDU sur lequel le cryptage ce fait est la Data, le cryptage se fait dans l'application.

protocole ethernet = permet d'échanger les données sur un réseau local.

port DNS:53.

# Prochains cours

1. Routage statique.
2. DHCP (Dynamic Host Configuration Protocol).
3. VLAN (Réseaux virtuels).
4. Prise en main des équipements à distance.
5. NAT (Network Adress Translation) (relier l'entreprise à internet).

Le but du projet sera de mettre en pratique ces 5 cours dans le cadre d'un projet client.

# V. Routage Statique

## Vocabulaire:

Un routeur peut avoir autour de lui deux types de réseaux (connectés et distants).

​	Les réseaux directement connectés à un routeur sont appelés "réseaux connectés".

​	Les réseaux joignables mais pas directement connectés au routeur (connectés via un autre réseau), sont appelés "réseaux distants".

## fonctionnement d'un routeur

Lorqu'un routeur reçoit un paquet sur l'une de ses interfaces, il va devoir le rediriger vers le prochain saut (next-hop), qui va lui permettre (au paquet) d'arriver jusqu'au destinataire final.

On dis que le routeur "route les paquets".

Par défaut, un routeur sait router les paquets uniquement vers ses réseaux directement connectés.

Exemple:

Pour router un paquet, le routeur regarde sa table de routage.

(voir la table de routage depuis le routeur : show ip route).

Lors que les deux réseaux connectés entre eux, et qu'un client d'un des réseaux souhaite intéragir avec un le réseau qui ne lui est pas directement connecté, il faudra remplire la table de routage manuellement.

Pour remplire une table de routage il y à deux possibilités:

​	La route est rentrée en dur dans routeur (routage statique).

​	les routeurs dialoguent et échangent leurs routes automatiquement (routage dynamique).

Commande pour configurer une route statique dans un routeur :

```CMD
Routeur(config)# ip route A B C
```



A = réseau de destination que l'on veux joindre (réseau distant).

B = masque associé au réseau distant (A).

C = Next-hop (prochain saut par lequel faire passer notre paquet).

exemple depuis le réseau 192.168.20.0 :

```CMD
ip route 192.168.10.0 255.255.255.0 10.0.0.1
```

exemple depuis le réseau 192.168.10.0 :

```
ip route 192.168.20.0 255.255.255.0 10.0.0.2
```





