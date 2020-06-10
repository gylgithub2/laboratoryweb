window.Alert = function(messages, callback) {
	if ($(".ec_tip").length < 1) {
		$("body").append("<div class=\"ec_tip\">" + messages + "</div>");
	}
	leftW = (document.body.clientWidth - $(".ec_tip").width()) / 2;
	topH = (document.body.clientHeight - $(".ec_tip").height()) / 3;
	$(".ec_tip").css("top", topH + "px").css("left", leftW + "px");
	$(".ec_tip").fadeIn(1000).animate({
		opacity : 0
	}, 1000, function() {
		$(".ec_tip").remove();
	});
	
}