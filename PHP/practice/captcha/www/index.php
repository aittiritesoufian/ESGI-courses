<?php
session_start();
header("Content-Type: image/png");

//Créer une image
$imgwidth = 300;
$imgheight = 200;
$image = imagecreate($imgwidth, $imgheight);
/**/


$char = "abcdefghijklmonpqrstuvwxyz0123456789";
$char = str_shuffle($char);
$length = rand(-8,-6);
$captcha = substr($char, $length);
$_SESSION['captcha'] = $captcha;

//Couleur de fond aléatoire (attention à la lisibilité)
$bg = imagecolorallocate($image, rand(150,200), rand(150,255), rand(150,255));
//Avoir un dossier avec 4 fonts en ttf
$fontsDir = glob("fonts/*.ttf");
//Appliquer aléatoirement une police par caractère - Attention le nom des polices doivent être dynamiques
//Ajouter des formes géométriques sur l'image
// -> nb aléatoire (max 10)
// -> couleur aléatoire (Attention à la lisibilité)
// -> position aléatoire

//Caractères avec des angles aléatoires

//Caractères couleurs aléatoires
//Caractères tailles aléatoires
//Caractères positions aléatoires
$x = rand(10,15);
for ( $i=0; $i<strlen($captcha); $i++ ) {
	$textcolor = imagecolorallocate($image, rand(0,100), rand(0,100), rand(0,100));
	$size = rand(25,35);
	$angle = rand(-50,50);
	$y = rand(40,$imgheight-40);
	//imagestring($image, rand(3,5), rand(0,50), rand(0,80), $captcha[$i], $textcolor);
	imagettftext($image, $size, $angle, $x, $y, $textcolor, $fontsDir[rand(0,count($fontsDir)-1)], $captcha[$i]);
	$x += $size + rand(2,7);
}

for ($j=0; $j < rand(4,10); $j++) { 
	$x1 = rand(0, $imgwidth);
	$y1 = rand(0, $imgheight);
	$x2 = rand(0, $imgwidth);
	$y2 = rand(0, $imgheight);
	$color = imagecolorallocate($image, rand(0,100), rand(0,100), rand(0,100));
	switch (rand(0,2)) {
		case 0:
			imageline($image, $x1, $y1, $x2, $y2, $color);
		break;
		case 1:
			imagerectangle($image, $x1, $y1, $x2, $y2, $color);
		break;
		default:
			imageellipse($image, $x1, $y1, $x2, $y2, $color);
		break;
	}
}
// imagestring($image, rand(3,5), rand(0,250), rand(0,180), $captcha, $textcolor);
//Ajouter d'un lecteur audio des caractères pour Arthur


//Afficher l'image (ou l'enregistrer)
imagepng($image);