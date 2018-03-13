<?php

class Ma_Newsletter_Widget extends WP_Widget
{
	
	function __construct()
	{
		parent::__construct('ma_newsletter', 'Newsletter', array('description'=>'Un formulaire d\'inscription à la newsletter'));
	}

	function form($instance){
		$title = isset($instance['title']) ? $instance['title'] : '';
		echo '

		<p>
			<label for="'.$this->get_field_name('title').'"> Title : </label>
			<input id="'.$this->get_field_id('title').'" name="'.$this->get_field_name('title').'" type="text" value="'.$title.'" />
		</p>

		';
	}

	function widget($args, $instance){
		echo $args['before_widget'];
		echo $args['before_title'];
		echo apply_filters('widget_title', $instance['title']);
		echo $args['after_title'];
		echo '
			<form action="" method="POST">
				<label for="ma_newsletter_email">Votre adresse mail : </label>
				<input id="ma_newsletter_email" name="ma_newsletter_email" type="email"/>
				<input type="submit"/>
			</form>
		';
		echo $args['after_widget'];
	}
}