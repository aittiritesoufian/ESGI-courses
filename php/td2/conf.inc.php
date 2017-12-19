<?php

define("DBUSER","root");
define("DBHOST","localhost");
define("DBPWD","root");
define("DBPORT","3306");
define("DBDRIVER","mysql");

$scriptName = ($_SERVER['SCRIPT_NAME'] == "/")?"":$_SERVER['SCRIPT_NAME'];

define("DIRNAME",dirname($scriptName.DIRECTORY_SEPARATOR));