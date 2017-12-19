<?php
session_start();
require "conf.inc.php";
echo "hello<br>";

function myAutoLoader($class){
	if(file_exists("core/".$class.".class.php")){
		include "core/".$class.".class.php";
	}
}

spl_autoload_register("myAutoLoader");

$uriExplode = explode("/", str_ireplace(DIRNAME, "",$_SERVER['REQUEST_URI']));

$c = $uriExplode[1]?$uriExplode[1]:"index";
$a = $uriExplode[2]?$uriExplode[2]:"index";

$a = explode("?", $a)[0];

// echo $c = $c?$c:"index";
// echo "<br>";
// echo $a = $a?$a:"index";

//Controller : NomController
$c = ucfirst(strtolower($c))."Controller";
//Action : nomAction
$a = strtolower($a)."Action";

unset($uriExplode[0]);
unset($uriExplode[1]);
//params
$params = [
			"POST"=>$_POST,
			"GET"=>$_GET,
			"URL"=>array_values($uriExplode),
		];




echo "<pre>";

if (file_exists("controllers/".$c.".class.php")){
	include "controllers/".$c.".class.php";
	if (class_exists($c)){
		$objC = new $c();
		if(method_exists($objC, $a)){
			$objC->$a($params);
		} else {
			die("L'action ".$a." n'existe pas");
		}
	} else {
		die("Le controller ".$c.".class.php");
	}
} else {
	die("Le fichier ".$c." n'existe pas !");
}
echo "</pre>";