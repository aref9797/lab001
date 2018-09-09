$(document).ready(function(){
	
    $(".delete").mouseenter(function()
    {
    	
       $(this).attr('src','../resources/images/delete-hover.png');
    });
    
    $(".delete").mouseleave(function()
    {    	
    	$(this).attr('src','../resources/images/delete.png');
 	 });
    $(".edit").mouseenter(function()
    {
    	    	
    	$(this).attr('src','../resources/images/edit-hover.png');
    });
    	    
     $(".edit").mouseleave(function()
     {    	
    	$(this).attr('src','../resources/images/edit.png');
     });
     
     $(".seen").mouseenter(function()
     {   	    	
    	$(this).attr('src','../resources/images/seen-hover.png');
     });
    		    	    
      $(".seen").mouseleave(function()
 	   {    	
       	$(this).attr('src','../resources/images/seen.png');
       });
      $(".chek").mouseenter(function()
       {
    	$(this).attr('src','../resources/images/chek-hover.png');
        });
      $(".chek").mouseleave(function()
        {
    	 $(this).attr('src','../resources/images/chek.png');
        });


});