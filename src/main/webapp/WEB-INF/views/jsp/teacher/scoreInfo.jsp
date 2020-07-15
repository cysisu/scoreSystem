<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>
<body>

<div class="layui-form-item" >
     <div class="layui-inline" style="margin-top:10px">
        <button id="find-score-btn" class="layui-btn" style="margin-left:25px;margin-top:20px;width:100px">搜索</button>
        <button id="add-score-btn" class="layui-btn" style="margin-left:25px;margin-top:20px;width:100px">添加</button>
    </div>
</div>

<div id="add-order-layer" style="padding: 20px">
  <form id="find-score-form" class="layui-form layui-form-pane" >
 <div class="layui-form-item" >
    <div class="layui-inline" style="margin-top:10px">
      <label class="layui-form-label">学号</label>
      <div class="layui-input-inline">
        <input type="text" id="studentId"  name="studentId"  autocomplete="off" class="layui-input" style="width:140px">
      </div>
    </div>
    <div class="layui-inline" style="margin-top:10px">
          <label class="layui-form-label">科目</label>
          <div class="layui-input-inline">
            <input type="text" id="subject"  name="subject"  autocomplete="off" class="layui-input" style="width:140px">
          </div>
    </div>

    <div class="layui-inline" style="margin-top:10px">
              <label class="layui-form-label">分数</label>
              <div class="layui-input-inline">
                <input type="text" id="score"  name="subject"  autocomplete="off" class="layui-input" style="width:140px">
              </div>
    </div>

  </div>
</form>
</div>



<!-- 更新成绩弹出层 -->
  <div id="update-score-layer" style="display: none; padding: 20px">
    <form id="update-score-form" class="layui-form layui-form-pane" lay-filter="update-user-form">

     <div class="layui-form-item" >
        <label class="layui-form-label">科目</label>
        <div class="layui-input-block">
          <input type="text" name="subject" readonly=＂true＂ class="layui-input" readonly>
        </div>
     </div>

     <div class="layui-form-item" >
             <label class="layui-form-label">学号</label>
             <div class="layui-input-block">
               <input type="text" name="studentId" readonly=＂true＂ class="layui-input" readonly>
             </div>
     </div>

     <div class="layui-form-item" >
             <label class="layui-form-label">分数</label>
             <div class="layui-input-block">
               <input type="text" name="score" class="layui-input" >
             </div>
     </div>

      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit lay-filter="update-score-form-submit">提交</button>
          <button type="reset" class="layui-btn layui-btn-primary" style="margin-left:70px">重置</button>
        </div>
      </div>
    </form>
  </div>



<table class="layui-hide" id="test" lay-filter="test"></table>



<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="../layui/layui.js" charset="utf-8"></script>

<script>
layui.use(['jquery', 'table', 'layer', 'form'], function(){
  var table = layui.table;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;
  var form = layui.form;

  table.render({
    elem: '#test'
    ,url:'/teacher/getScores'
    ,title: '用户数据表'
    ,cols: [[
      {field:'subject', title:'subject', width:350, fixed: 'center', align:'center',sort: true}
      ,{field:'studentId', title:'学生学号', width:300, align:'center',sort: true}
      ,{field:'score', title:'分数', width:300, align:'center'}
      ,{fixed: 'right', title:'备注', toolbar: '#barDemo', align:'center',width:120}
    ]]
    ,page: true
     // 表格容器id，用于表格重载
    ,id: 'user-tbl',
   });

   $('#find-score-btn').click(function() {
       var studentId=$('#studentId').val();
       var subject=$('#subject').val();
       console.log("studentId:"+studentId);

       table.reload('user-tbl', {
       page: {
              curr: 1 //重新从第 1 页开始
       }
       ,where:{studentId:studentId,subject:subject}
       , url: '/teacher/findScores'   //后台做模糊搜索接口路径
       , method: 'post'
      });
  });

     $('#add-score-btn').click(function() {
         var studentId=$('#studentId').val();
         var subject=$('#subject').val();
         var score=$('#score').val();
         console.log("studentId:"+studentId);
         $.ajax({
                url: "/teacher/setScore",
                type: "POST",
                data: JSON.stringify({studentId:studentId,subject:subject,score:score}),
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
    });


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



      //监听行工具事件
      table.on('tool(test)', function(obj){
        var data = obj.data;
        console.log(data);
        //console.log(obj)
        if(obj.event === 'del'){
          layer.confirm('真的删除行么', function(index){
            obj.del();
            layer.close(index);
            $.ajax({
            url: '/teacher/' + data.studentId+'&'+data.subject,
            type: "DELETE",
            dataType: 'json',
            success: function(data) {
                 if (data.status == 1) {
                      layer.msg('删除成功');
                      table.reload('user-tbl');
                  } else {
                        layer.msg('删除失败');
                  }
            },
            error: function() {
                   console.log("ajax error");
                }
            });
          });
        } else if(obj.event === 'edit'){
          console.log(data)
          form.val('update-user-form', {
                 "subject": data.subject,
                 "studentId": data.studentId,
                 "score": data.score
          });
          layer.open({
                 type: 1,
                 title: '更新订单',
                 skin: 'layui-layer-molv',
                 area: ['600px'],
                 content: $('#update-score-layer')
          });
           form.on('submit(update-score-form-submit)', function(data) {
               console.log(data);
                      // ajax方式更新用户
               $.ajax({
               url: "/teacher/updateScore",
               type: "POST",
               data: data.field,
               dataType: 'json',
               success: function(data) {
                    if (data.status == 1) {
                        layer.close(layer.index);
                        layer.msg('修改成功');
                        table.reload('user-tbl');
                    } else {
                        layer.msg('修改失败');
                    }
               },
               error: function() {
                    console.log("ajax error");
               }
               });
                // 阻止表单跳转
               return false;
            });
        }
      });

});
</script>


</body>
</html>