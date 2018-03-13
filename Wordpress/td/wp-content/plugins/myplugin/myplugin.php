<?php
/*
Plugin Name: Mon Plugin Perso
Description: mon plugin
Author: Soufan
Author URI: atsn.me
*/

/**
* 
*/
class Mon_Plugin
{
	
	public function __construct()
	{
		include_once plugin_dir_path(__FILE__).'/newsletter.php';
		register_activation_hook(__FILE__, array('Mon_Plugin','install'));
		register_uninstall_hook(__FILE__, array('Mon_Plugin','uninstall'));
		add_action('wp_loaded', array($this,'save_email'));
	}

	public static function install(){
		global $wpdb;
		$wpdb->query("
			CREATE TABLE IF NOT EXISTS {$wpdb->prefix}ma_newsletter_list
			(id INT AUTO_INCREMENT PRIMARY KEY,
			email VARCHAR(255) NOT NULL);
			");
	}

	public function uninstall(){
		global $wpdb;
		$wpdb->query("
			DROP TABLE IF NOT EXISTS {$wpdb->prefix}ma_newsletter_list;
			");
	}

	public function save_email(){
		if(isset($_POST["ma_newsletter_email"]) && !empty($_POST["ma_newsletter_email"])){
			global $wpdb;
			$email = $_POST["ma_newsletter_email"];
			$row = $wpdb->get_row("SELECT * FROM {$wpdb->prefix}ma_newsletter_list WHERE email = ".$email);
			if(is_null($row)) {
				$wpdb->insert("{$wpdb->prefix}ma_newsletter_list", array('email' => $email));
			}
		}
	}
}
new Mon_Plugin();