

document.getElementById('roulette').addEventListener('click',function(){
	spin();
})

function spin(){
	var angle = 360 + Math.random()*360;
	document.getElementById('roulette').style.transform="rotate("+angle+"deg)";

	angle_encours += angle;
	document.getElementById('roulette').style.transform="rotate("+angle_encours+"deg)";
}

var angle_encours = 0;