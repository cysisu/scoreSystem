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

    $("#sign_up").click(function() {
           console.log("sign_up");
    	    var username = $('#sign_username').val();
            var password= $("#password1").val();
            var password1=$("#password2").val();
            var character=$("#sign_character").val();
            if(password!=password1){
                 alert("两次输入密码不相同!");
                 return;
            }
    	    $.ajax({
                 url : '/admin/register',
                 type : 'post',
                 data :{
                        id:username,
                        password :password,
                        character:character
                 },
                 success : function(data) {
                       console.log(data);
                       if(data.status==1){
                            alert("注册成功！");
                            parent.location.href = '/';
                       }
                       else{
                            alert("用户名已经存在!");
                       }
                 }
            });

    });
});

