<!DOCTYPE html>
<html>
<head>
	<title><?php wp_title()." ".bloginfo('name'); ?></title>
	<?php wp_head(); ?>
</head>
<body>
	<h1><?php bloginfo('name'); ?></h1>
	<?php wp_nav_menu(array("theme_location" => "main-menu")); ?>