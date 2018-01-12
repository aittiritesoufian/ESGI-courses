<?php

define("DBUSER","root");
define("DBHOST","localhost");
define("DBPWD","root");
define("DBPORT","3306");
define("DBDRIVER","mysql");

define("DS","/");

// echo $_SERVER['SCRIPT_NAME'];
// echo '<br>';
// echo dirname($_SERVER['SCRIPT_NAME']);
// echo '<br>';

 $scriptName = (dirname($_SERVER['SCRIPT_NAME']) == "/")?"".DS:$_SERVER['SCRIPT_NAME'].DS;

define("DIRNAME",$scriptName);

