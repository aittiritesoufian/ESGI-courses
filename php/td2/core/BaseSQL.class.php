<?php

class BaseSQL {

	private $pdo;
	private $table;
	private $columns;

	public function __construct(){
		echo "connexion";
		try{
			$this->pdo = new PDO(DBDRIVER.":host=".DBHOST.";dbname=".DBNAME,DBUSER,DBPWD);
		} catch(Exception $e){
			die('Erreur SQL : '.$e->getMessage());
		}
		$this->table = strtolower(get_called_class());
	}

	public function setColumn(){
		//$this->columns = get_class_vars(strtolower(get_called_class()));
		$this->columns = array_diff_key(get_object_vars($this), get_class_vars(get_class())) ;

	}

	public function save(){
		$this->setColumn();
		var_dump($this->columns);

		if($this->id){
			//UPDATE
		} else {
			//INSERT
			unset($this->columns['id']);
			$query = $this->pdo->prepare("INSERT INTO ".$this->table."
					(".implode(",", array_keys($this->columns)).")
					VALUES (:".implode(",:", array_keys($this->columns)).");
				");
			$query->execute($this->columns);
		}
	}
}