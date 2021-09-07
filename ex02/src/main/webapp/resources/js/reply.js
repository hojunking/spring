 
 
 let replyService=(function(){
    function add(callback, error){
        $.ajax({
            url:"../reply/",
            data:$("replyForm").serialize(),
            method:"post",
            dataType:"JSON",
            success:function(data){if(callback) callback(data)},
            error:function(){if(error) error();}
        });
    }
    
    
    function getList(param,callback,error){
        a.ajax({
            url:"../reply/",
            data:param,
            dataType:"JSON",
            success:function(data){if(callback) callback(data)},
            error:function(){if(error) error();}
        })

    }
return {add:add ,getList:getList}
})();