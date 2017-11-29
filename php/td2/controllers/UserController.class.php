<?php
class UserController{


	public function indexAction($params){
		echo "Action par défaut de user";
	}

	public function addAction($params){
		echo "Action d'ajout d'un user";
	}

	public function deleteAction($params){
		echo "Action de suppression d'un user<br>";
		var_dump($params);
		
	}
}