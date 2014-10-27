$(function() {
	$('#menu_principal li').click(function(event){
		console.log('lick');
		event.preventDefault();
	});
	if (location.href.substr(-1) == '/') {
		$('#menu_principal li:first').addClass('active');
	} else {
		$('#menu_principal li a').each(function() {
			if (location.href == this.href) {
				$(this.parentElement).addClass('active');
			}
		});
	}
});