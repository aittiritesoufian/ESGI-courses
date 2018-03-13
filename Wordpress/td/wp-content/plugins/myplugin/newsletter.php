<?php

//inclure la partie fonctionnelle sur un autre fichier
include_once plugin_dir_path(__FILE__).'/newsletterwidget.php';

class Ma_Newsletter
{
	
	function __construct()
	{
		add_action("widgets_init",function(){
			register_widget("Ma_Newsletter_Widget");
		});
	}
}

new Ma_Newsletter();