$(function() {
	$("#register_btn").click(function() {
	    console.log("hello world");
		$("#register_form").css("display", "block");
		$("#login_form").css("display", "none");
	});
	$("#back_btn").click(function() {
		$("#register_form").css("display", "none");
		$("#login_form").css("display", "block");
	});
	$("#login_btn").click(function() {
	    var username = $('#login_username').val();
        var password= $("#login_password").val();
        var character=$("#login_character").val();
	    $.ajax({
             url : '/admin/login',
             type : 'post',
             data :{
                    id:username,
                    password :password,
                    character:character
             },
             success : function(data) {
                   console.log(data);
                   if(data.status==1){
                        parent.location.href = '/index';
                   }
                   else if(data.status==2){
                        parent.location.href = '/studentIndex';
                   }
                   else{
                        alert("用户名或者密码错误!");
                   }
             }
        });

    });
});

