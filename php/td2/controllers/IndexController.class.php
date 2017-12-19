<?php

class IndexController{

	public function indexAction($params){
		$v = new View("default","front");
		echo "<br>action par défaut de Index";	
	}
}