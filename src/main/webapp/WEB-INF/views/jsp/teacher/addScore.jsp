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
</head>
<body>
     <form id="add-score-form" class="layui-form" action="" style="margin-top:100px;margin-left:30px">
          <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">学生学号</label>
              <div class="layui-input-inline">
                <input type="tel" name="studentId" lay-verify="" autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">科目</label>
              <div class="layui-input-inline">
                <input type="text" name="subject" lay-verify="" autocomplete="off" class="layui-input">
              </div>
            </div>
          </div>
          <div class="layui-form-item" style="margin-top:50px">
                <div class="layui-inline">
                     <label class="layui-form-label">成绩</label>
                     <div class="layui-input-inline">
                          <input type="text" name="score" lay-verify="" autocomplete="off" class="layui-input">
                     </div>
                </div>
          </div>

         <div class="layui-form-item" style="margin-top:50px;margin-left:100px">
              <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="add-score-form-submit">提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary" style="margin-left:50px">重置</button>
              </div>
         <div>
      </form>
     <script language=JavaScript>
		function showtime() {

		}
	 </script>

    <script>
    layui.use(['jquery', 'table', 'layer', 'form'], function(){
      var table = layui.table;
      var $ = layui.$;
      var table = layui.table;
      var layer = layui.layer;
      var form = layui.form;

        // 添加用户表单提交
      form.on('submit(add-score-form-submit)', function(data) {
               // ajax方式添加用户
               console.log(data);
               $.ajax({
               url: "/teacher/setScore",
               type: "POST",
               data: JSON.stringify(data.field),
               contentType: 'application/json',
               dataType: 'json',
               success: function(data) {
               if (data.status == 1) {
                    layer.close(layer.index);
                    layer.msg('添加成功');
                    table.reload('user-tbl');
               } else {
                    layer.msg('添加失败');
               }
               },
               error: function() {
                    console.log("ajax error");
               }
               });
               // 阻止表单跳转
               return false;
        });

    });
    </script>
</body>
</html>