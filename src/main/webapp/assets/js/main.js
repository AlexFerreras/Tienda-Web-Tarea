$(document).ready(function(){
    
 let remove =element=>{
                let id= {id:element.id};
                $.ajax(
                {
                    type: "GET",
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
    });


