$().ready(function() {
	$("#login_form").validate({
		rules: {
			username: "required",
			password: {
				required: true,
				minlength: 5
			},
		},
		messages: {
			username: "请输入姓名",
			password: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符")
			},
		},
		submitHandler:function(form){
              form.submit();
              var username = $('#login_username').val();
              var password= $("#login_password").val();
              $.ajax({
					type:"post",
					url:"/admin/login",
					data:{
						username:username,
						password:password
					},
					beforeSend:function(){
						i=show_wait();
					},
					success:function(result){
						if(result.status == 1){
							parent.location.href = '/admin/index';
							close_wait(i);
						}else if(result.code != 0){
							layer.msg('用户名或密码错误', {icon:5, shade:[0.5, '#000000'], shadeClose:true});
							close_wait(i);
						}
					},
					error:function(){
						layer.alert("获取数据失败！");
						close_wait(i);
					}
				    });
				    $("#username").val('');
				    $("#password").val('');
				    return false;
		      });
        }

	});
	$("#register_form").validate({
		rules: {
			username: "required",
			password: {
				required: true,
				minlength: 5
			},
			rpassword: {
				equalTo: "#register_password"
			}
		},
		messages: {
			username: "请输入姓名",
			password: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符")
			},
			rpassword: {
				equalTo: "两次密码不一样"
			}
		}
	});
});
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
});

