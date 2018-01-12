<?php

class View{

	private $v;
	private $t;
	private $data = [];

	function __construct($vue = "default", $template = "front"){

		$this->v = $vue.".view.php";
		$this->t = $template.".tpl.php";

		if(!file_exists("views/".$this->v)){
			die("La vue ".$this->v." n'existe pas !");
		}

		if(!file_exists("views/templates/".$this->t)){
			die("Le template ".$this->t." n'existe pas !");
		}
	}

	public function assign($key,$value){
		$this->data[$key] = $value;
	}

	function __destruct(){
		global $a, $c;
		extract($this->data);
		include "views/templates/".$this->t;
	}
}