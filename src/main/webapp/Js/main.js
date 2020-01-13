$(document).ready(function(){
    
   $("#addproductbtn").click
   ((e)=>{
       e.preventDefault();
       $.post(
        "Product",
        $("#addproductform").serialize(),
        (response)=>
        {
            console.log(response);
           if(response==="exito"){
             // window.location="index.jsp?page=init";
           }
           else{
                console.log(response);
           }
        });
        
      });
   
   $("#editproductform").click
   (function(){
       $.put(
        "Product",
        $("#editproductform").serialize(),
        function(response)
        {
           if(response==="exito"){
              window.location="index.jsp?page=init";
           }
           else{
              console.log(response); 
           }
        });
        
      });
    
});

 function remove(elem){
                 var id= {id:elem.id};
                $.ajax(
                {type: "GET",
                url: "Editor",
                data:id,
                success: function(response)
                {
                   if(response==="exito"){
                    window.location="index.jsp?page=inicio";
                    }
                    else{
               console.log(response);
                        }
                }
                });
                }
 


