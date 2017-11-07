<?php

class House{

	//attributs (propriétées)
	private $wall = 4;
	private $fundation = 1;
	private $roof = 1;
	private $floor = 0;

	//Method
	function addfloor(){
		$this->wall += 4;
		$this->wall += 1;
	}
}

$house1 = new House();
$house1->addfloor();
print_r($house1);