<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="./css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="./css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="../css/lines.css" rel='stylesheet' type='text/css' />
<link href="./css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="./js/jquery.min.js"></script>
<!----webfonts--->
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!-- Nav CSS -->
<link href="./css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="./js/metisMenu.min.js"></script>
<script src="./js/custom.js"></script>
<!-- Graph JavaScript -->
<script src="./js/d3.v3.js"></script>
<script src="./js/rickshaw.js"></script>
<link rel="stylesheet" href="./css/myStyle.css">
</head>
<body onload="showtime()">
<div id="wrapper">
     <!-- Navigation -->
        <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="studentIndex.jsp">Modern</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">

			    <li class="dropdown">
	        		<a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src=".../images/1.png"></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header text-center">
							<strong>Account</strong>
						</li>
						<li class="m_2"><a href="#"><i class="fa fa-lock"></i> Logout</a></li>
	        		</ul>
	      		</li>
			</ul>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="studentIndex.jsp"><i class="fa fa-dashboard fa-fw nav_icon"></i>Dashboard</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

      <div id="page-wrapper">
         <div class="graphs">
                 <div class="b"  style="margin-top:50px">
         		   <span id="clock"></span>
         	    </div>
                <h1>欢迎使用</h1>
                <div class="wrap">
                       <span><strong>成绩管理系统</strong></span>
                 </div>
                <h2>当前登录：${name}</h2>
                <h2>教师号:  ${id}</h2>
		 </div>
      </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
    <script language=JavaScript>
    		function showtime() {
    			var today;
    			var hour;
    			var second;
    			var minute;
    			var year;
    			var month;
    			var date;
    			var strDate;
    			today = new Date();
    			var n_day = today.getDay();
    			switch (n_day) {
    			case 0: {
    				strDate = "星期日"
    			}
    				break;
    			case 1: {
    				strDate = "星期一"
    			}
    				break;
    			case 2: {
    				strDate = "星期二"
    			}
    				break;
    			case 3: {
    				strDate = "星期三"
    			}
    				break;
    			case 4: {
    				strDate = "星期四"
    			}
    				break;
    			case 5: {
    				strDate = "星期五"
    			}
    				break;
    			case 6: {
    				strDate = "星期六"
    			}
    				break;
    			case 7: {
    				strDate = "星期日"
    			}
    				break;
    			}
    			year = today.getYear() - 100 + 2000;
    			month = today.getMonth() + 1;
    			date = today.getDate();
    			hour = today.getHours();
    			minute = today.getMinutes();
    			second = today.getSeconds();
    			if (month < 10)
    				month = "0" + month;
    			if (date < 10)
    				date = "0" + date;
    			if (hour < 10)
    				hour = "0" + hour;
    			if (minute < 10)
    				minute = "0" + minute;
    			if (second < 10)
    				second = "0" + second;
    			document.getElementById('clock').innerHTML = year + "年" + month
    					+ "月" + date + "日 " + strDate + " " + hour + ":" + minute
    					+ ":" + second;
    			setTimeout("showtime();", 1000);
    		}
    </script>
</body>
</html>
