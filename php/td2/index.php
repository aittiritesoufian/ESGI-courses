<?php
session_start();
require "conf.inc.php";

function myAutoLoader($class){
	if(file_exists("core/".$class.".class.php")){
		include "core/".$class.".class.php";
	} else if(file_exists("models/".$class.".class.php")){
		include "models/".$class.".class.php";
	}
}

spl_autoload_register("myAutoLoader");

$uri = substr(urldecode($_SERVER['REQUEST_URI']), strlen(dirname($_SERVER['SCRIPT_NAME'])));

$uri = ltrim($uri,"/");

$uri = explode("?", $uri);
$uriExplode = explode("/", $uri[0]);

$c = $uriExplode[0]?$uriExplode[0]:"index";
$a = $uriExplode[1]?$uriExplode[1]:"index";

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