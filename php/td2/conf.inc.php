<?php

define("DBUSER","rootSoufian");
define("DBHOST","192.168.99.1");
define("DBPWD","root");
define("DBPORT","3306");
define("DBDRIVER","mysql");
define("DBNAME","envdocker");

define("DS","/");

// echo $_SERVER['SCRIPT_NAME'];
// echo '<br>';
// echo dirname($_SERVER['SCRIPT_NAME']);
// echo '<br>';

 $scriptName = (dirname($_SERVER['SCRIPT_NAME']) == "/")?"".DS:$_SERVER['SCRIPT_NAME'].DS;

define("DIRNAME",$scriptName);

