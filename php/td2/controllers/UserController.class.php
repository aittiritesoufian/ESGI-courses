<?php
class UserController{


	public function indexAction($params){
		echo "Action par défaut de user";
	}

	public function addAction($params){
		$name = "Test hello";
		$v = new View("ajout","front");
		$v->assign("name", $name);

		$user = new User();
		$user->setLastname("AIT TIRITE");
		$user->setFirstname("Soufian");
		$user->setEmail("soufian@soufian.esgi");
		$user->setPwd("blablabla");
		$user->setStatus(1);
		$user->save();
	}

	public function deleteAction($params){
		echo "Action de suppression d'un user<br>";
		var_dump($params);
		
	}
}