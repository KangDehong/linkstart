<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hello, World</title>
<style type="text/css">
html {
	height: 100%
}

body {
	height: 600px;
	width: 800px;
	margin: 0px;
	padding: 0px;
	margin: 0px;
}

#container {
	height: 100%
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=3.0&ak=Lo3qGnB0TQA3AcSkn1h7cbyyRrcTtGG8">
	//v3.0版本的引用方式：src="http://api.map.baidu.com/api?v=3.0&ak=您的密钥"
</script>
</head>

<body>
	<div id="container"></div>
	<script type="text/javascript">
		// 创建地图实例  
		var map = new BMap.Map("container");
		// 创建点坐标
		var point = new BMap.Point(116.404, 39.915);
		//开启鼠标滚轮缩放
		map.enableScrollWheelZoom(true);
		// 初始化地图，设置中心点坐标和地图级别
		map.centerAndZoom(point, 15);
		var marker = new BMap.Marker(point); // 创建标注    
		map.addOverlay(marker); // 将标注添加到地图中 
		//添加多个控件到百度地图中
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		map.addControl(new BMap.OverviewMapControl());
		map.addControl(new BMap.MapTypeControl());
		map.setCurrentCity("北京"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用
	</script>
</body>
</html>