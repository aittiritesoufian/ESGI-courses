<?php

class IndexController{

	public function indexAction($params){
		$name = "soufian";

		$v = new View("default","front");

		$v->assign("name", $name);
	}
}