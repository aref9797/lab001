$(document).ready(function(){
	vph = $(window).height();
	$(".content").css({"height": (vph-30)+ "px"});
	$(".content").resize(function(){
		vph = $(window).height();
		$(".content").css({"height": (vph-30)+ "px"});
	});
});
