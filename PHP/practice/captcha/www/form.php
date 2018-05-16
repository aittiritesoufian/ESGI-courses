<?php session_start(); ?>
<!DOCTYPE html>
<html>
<head>
	<title>Form</title>
</head>
<body>

	<form method="POST">
		<input type="text" name="email" placeholder="votre email"><br>
		<input type="password" name="password"><br>
		<img src="index.php">
		<input type="text" name="captcha">
		<input type="submit" name="Envoyer">
	</form>

	<?php
	if(isset($_POST['captcha']) && isset($_SESSION['captcha'])) {
		if( $_POST['captcha'] == $_SESSION['captcha'] ) {
			echo "ok";
		} else {
			echo 'nok';
		}
	}
	?>

</body>
</html>