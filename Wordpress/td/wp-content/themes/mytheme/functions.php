<?php

//création d'une zone de menu dans le thème
add_action('init','theme_menu');

function theme_menu(){
	register_nav_menu("main-menu","Menu principal");
	register_nav_menu("footer-menu","Menu pied de page");
}

//création de zone de widgets sur le thème
add_action('widgets_init','theme_widgets_zones');

function theme_widgets_zones(){
	register_sidebar(array(
		'id' => 'zone1',
		'name' => "Zone1",
		'Description' => "Ceci est une zone de widget de la colonne latérale"
	));
	register_sidebar(array(
		'id' => 'zone2',
		'name' => "Zone2",
		'Description' => "Ceci est une zone de widget du pied de page"
	));
}

//creation d'un champs category dans les attachments
add_action( 'init' , 'wptp_add_categories_to_attachments' );

function wptp_add_categories_to_attachments() {
	register_taxonomy_for_object_type( 'category', 'attachment' );
}

//création d'un widget
add_action('widgets_init', 'theme_register_widgets');

function theme_register_widgets(){
	register_widget('CustomWidget');
}

class CustomWidget extends WP_Widget {
	function CustomWidget() {
		parent::__construct(false, "Widget Custom Link");
		$options = array(
			"classname" => "custom-widget",
			"description" => "Un widget personnalise"
		);
		$this->WP_widget("custom-widget","Widget Custom Link",$options);
	}
	// apparence en front, rendu du widget
	function widget($args,$d){
		$checked = isset($d['blank'])?"target='_blank'":"";
		echo "<a href='".$d['url']."' ".$checked." class='custom_url'>". $d['name'] ."</a>";
	}

	function update($new,$old){
		return $new;
	}
	//formulaire à compléter dans le BO
	function form($d) {
		$default = array(
			"name" => "Google",
			"url" => "http://google.com"
		);
		$d = wp_parse_args($d,$defaut);
		$checked = isset($d['blank'])?"checked=true":"";
		echo '
		<p>
			<label for="'.$this->get_field_id('name').'">Name : </label>
			<input value="'.$d['name'].'" name="'.$this->get_field_name('name').'" id="'.$this->get_field_id('name').'" type="text" />
		</p>
		<p>
			<label for="'.$this->get_field_id('url').'">Url : </label>
			<input value="'.$d['url'].'" name="'.$this->get_field_name('url').'" id="'.$this->get_field_id('url').'" type="text" />
		</p>
		<p>
			<label for="'.$this->get_field_id('blank').'">Ouvrir dans un nouvel onglet ? </label>
			<input '.$checked.' name="'.$this->get_field_name('blank').'" id="'.$this->get_field_id('blank').'" type="checkbox" />
		</p>
		';
	}
}

//ajouter un shortcode
add_shortcode('test','test_func'); 

function test_func(){
	echo '<p>Test du shortcode réussi !</p>';
}
