<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>添加成绩</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <script src="../layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>
<body onload="showInitial()">
     <div id="update-score-form" class="layui-form" action="" style="margin-top:100px;margin-left:30px">
          <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">老师编号</label>
              <div class="layui-input-inline">
                <input type="text" id="teacherId" lay-verify="" value=""  readonly=＂true＂  autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">姓名</label>
              <div class="layui-input-inline">
                <input type="text" id="name" value=""   lay-verify="" autocomplete="off" class="layui-input">
              </div>
            </div>
          </div>
          <div class="layui-form-item" style="margin-top:50px">
                <div class="layui-inline">
                     <label class="layui-form-label">电话</label>
                     <div class="layui-input-inline">
                          <input type="text" id="phone" lay-verify="phone"  value=""   autocomplete="off" class="layui-input">
                     </div>
                </div>
                <div class="layui-inline">
                      <label class="layui-form-label">邮箱</label>
                      <div class="layui-input-inline">
                              <input type="text" id="email" lay-verify="email"  value=""   autocomplete="off" class="layui-input">
                      </div>
                </div>
          </div>

         <div class="layui-form-item" style="margin-top:50px;margin-left:100px">
              <div class="layui-input-block">
                    <button class="layui-btn"  id="update-score-form-submit">保存</button>
              </div>
         <div>
      </div>
     <script language=JavaScript>
      		function showInitial() {
                  $("#teacherId").attr("value",'${sessionScope.id}');
                  $("#name").attr("value",'${sessionScope.name}');
                  $("#phone").attr("value",'${sessionScope.phone}');
                  $("#email").attr("value",'${sessionScope.email}');
      		}
     </script>
</body>
<script>
    $(function() {
        $("#update-score-form-submit").click(function() {
            var phone=$('#phone').val();
            var teacherId = $('#teacherId').val();
            var name= $("#name").val();
            var email=$("#email").val();
            console.log('phone:'+phone);
            $.ajax({
                 url : '/teacher/updateTeacherInfo',
                 type : 'post',
                 data :{
                        teacherId:teacherId,
                        name :name,
                        phone : phone,
                        email:email
                 },
                 success : function(data) {
                       if(data.status==1){
                            alert("更改保存成功!");
                       }
                       else{
                            alert("更改保存失败!");
                       }
                 }
            });

        });
    });
</script>
</html>