# TD

Création de deux postes et d'un switch 2960-24

Relier le switch aux postes par un câble

Définir l'IP et le MASK des machines

tester un ping de l'une des machines vers la seconde



Le protocole ping est un protocole de couche internet (ICMP = Internet Control Message Protocol), il permet d'envoyer une requête (echo) en demandant un retour (reply). Elle permet de tester la joignabilité d'un hôte sur un réseau.



Interface Ethernt = 10 Mgbits/sec

FastEthernet = 100 Mgbits/sec

GigabitEthernet = 1 Gbits/sec

TenGigabitEthernet = 10 Gbits/sec



Mode utilisateur simple (distingué par Routeur>), permet de voir :

SHOW restrictif

-> UP TIME

-> Heure du système

Mode utilisateur privilégié (distingué par un Routeur#) :

SHOW exhaustif

-> lire la configuration

-> Commandes de debug

Mode utilisateur privilégié en configuration (distingué par Routeur(config)#)

-> Configuration du routeur

Régresser de mode : exit

Augmenter de rôle simple à priviligié = enable

Augmenter de rôle priviligié à priviligié en configuration = configure terminal



On peux abrégé "configuration terminal" par "conf t"



On ajoute l'ip du routeur dans le Gateway (passerelle entre les deux réseaux).