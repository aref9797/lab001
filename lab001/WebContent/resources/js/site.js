$ = jQuery;
$(document).ready(function(){
	$("#myForm\\:reemail").click(function(){
	    $("#emailicon").css("visibility","visible");
	});
	$("#myForm\\:reemail").keyup(function(){
		
		if ($("#myForm\\:email").val!="")
		{
			if ($("#myForm\\:email").val()==$("#myForm\\:reemail").val())
			{
				$("#emailicon").attr("src","../resources/images/true.jpg");
			}
			else
			{
				$("#emailicon").attr("src","../resources/images/false.png");
			}
		}
		
	});
	
	
	$("#myForm\\:repass").click(function(){
	    $("#passicon").css("visibility","visible");
	});
	$("#myForm\\:repass").keyup(function(){
		
		if ($("myForm\\:#pass").val!="")
		{
			if ($("#myForm\\:pass").val()==$("#myForm\\:repass").val())
			{
				$("#passicon").attr("src","../resources/images/true.jpg");
			}
			else
			{
				$("#passicon").attr("src","../resources/images/false.png");
			}
		}
		
	});
	
	$('#myForm\\:pass').strengthMeter('progressBar', {
        container: $('#example-progress-bar-container')
    });

	
	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

		  ga('create', 'UA-46156385-1', 'cssscript.com');
		  ga('send', 'pageview');
});



$(document).ready(function(){
    $("#panel").mouseenter(function(){
        $("#panel").css("background-color","grey");
    });

    $("#panel").mouseleave(function(){
        $("#panel").css("box-shadow","0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)");
    });


});