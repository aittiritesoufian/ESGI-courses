<?php
class UserController{


	public function indexAction($params){
		echo "Action par défaut de user";
	}

	public function addAction($params){
		$v = new View("ajout","front");
	}

	public function deleteAction($params){
		echo "Action de suppression d'un user<br>";
		var_dump($params);
		
	}
}