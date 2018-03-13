<?php
get_header();
while ( have_posts() ){
	the_post();
	the_title();
	the_content();
}
dynamic_sidebar('zone1');
get_footer();
?>