<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>

	<?php

	// PROCEDURAL

		//commentaire sur une ligne
		/*
			commentaire sur des lignes
		*/
		//Convention de nommage = Camel Case
		//Anglais
		//explicite
		//Ne doit pas commencer par un chiffre
		/*$myLastname = "soufian";
		$myLastname = 'soufian';
		$myAge = 30;
		$average = 16.5;
		$teacher = true;
		$tolerance = null;
		
		echo $myAge;//30
		echo $myAge++;//30
		echo $myAge;//31
		echo ++$myAge;//32
		echo $myAge+=1;//33
		echo $myAge = $myAge +1;//34
		
		if($myAge === 18){
			echo "tout juste majeur";
		}else if($myAge > 18){
			echo "majeur";
		}else{
			echo "mineur";
		}
		
		$gender = "Mr";
		
		switch($gender){
			case "Mr":
				echo "Monsieur";
				break;
			case "Mme":
				echo "Madame";
				break;
			default:
				echo "Autre";
				break;
		}

		$majeur = true;

		if($majeur){
			echo "vous êtes majeur";
		}else{
			echo "vous êtes mineur";
		}

		echo "vous êtes ".(($majeur)?"majeur":"mineur");*/
		
		/*
		for($i=0;$i<10;$i++){
			echo $i;
		}

		$j=0;
		while($j<10){
			echo $j;
			$j++;
		}

		$age = 30;
		do{
			echo 'test';
		}while($age<18);
		
		//création d'un tableau
		$array = [];
		$array = ["Pierre","Luc","Jean","Laura"];

		foreach ($array as $value) {
			echo $value."<br>";
		}

		foreach ($array as $key => $value) {
			echo $value."<br>";
		}*/ 

		//tableau 3 dimensions
		/*$school = 	[
						[
							["Pierre","Steven"]
						]
					];

		$student = ['firstname'=>'marc','lastname'=>'pierre',16,14];
		//affiche marc pierre à une moyenne de 15.
		echo $student['firstname']." ".$student['lastname']." à une moyenne de 15";
		//affiche 16 pierre à une moyenne de 15.
		echo $student[0]." ".$student['lastname']." à une moyenne de 15";

		$word = "Test";
		showWord($word);
		echo $word;

		function showWord(&$word){
			$word = "Test2";
			echo $word;
		}

		function showWord2(){
			global $word;
			$word = "Test2";
			echo $word;
		}*/

	// OBJET

		
	?>

</body>
</html>
