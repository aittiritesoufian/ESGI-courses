

document.getElementById('roulette').addEventListener('click',function(){
	spin();
})

function spin(){
	var angle = 360 + Math.random()*360;

	angle_encours += angle;
	document.getElementById('roulette').style.transform="rotate("+angle_encours+"deg)";
}

var angle_encours = 0;

document.getElementById('select_taille').addEventListener('change', 
	function(){
		resize(this.value);
	});

function resize(size){
	var taille_medium=300;
	switch(size){
			case "Small" : document.getElementById('roulette').style.width=document.getElementById('roulette').style.height=(0.5*taille_medium)+"px";
			break;

			case "Medium" : document.getElementById('roulette').style.width=document.getElementById('roulette').style.height=taille_medium+"px";
			break;

			case "Big" : document.getElementById('roulette').style.width=document.getElementById('roulette').style.height=(1.5*taille_medium)+"px";
			break;

			default : document.getElementById('roulette').style.width=document.getElementById('roulette').style.height=taille_medium+"px";
		};
}

const taille_medium=300; // on la déclare globalement pour l'utiliser dans plusieurs fonctions, du coup, il faut supprimer sa déclaration locale dans la fonction resize()

document.getElementById('range_taille').addEventListener('change', 
	function(){
		var size=taille_medium*0.5+this.value*taille_medium/100;
		document.getElementById('roulette').style.width=document.getElementById('roulette').style.height=size+"px";
	});

const nb_clics_depart=3;
var nb_clics_restants=nb_clics_depart;

updateNb();
function updateNb(){
	document.getElementById('nb_clics_restants').value=nb_clics_restants;
}

function clicRoue(){
	if(nb_clics_restants>0){
		nb_clics_restants--;
		updateNb();
		spin();
	}
	else{
		var replay = confirm('Voulez-vous recommencer ?');
		if(replay){
			nb_clics_restants=nb_clics_depart;
			updateNb();
		}
		else{
			alert('Merci d\'avoir joué !');
		}
	}
}	

document.getElementById('roulette').addEventListener('click', 
	function(){
		clicRoue();
	});