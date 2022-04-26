<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% int total = (int) request.getAttribute("total"); %>

<% String sessionNick = (String) session.getAttribute("usernick"); %>

<style type="text/css">

#btnDiv {text-align:center;}

button {
	border: 2px solid #ddd;
	background-color: #eaf3fd;
	padding: 5px;
}

button:active {
	border: 2px solid #ddd;
	background-color: #709dcf;
	padding: 5px;
}

.title {
	text-align: center;
    border: 2px solid #dddddd;
    background-color: #eaf3fd;
    padding: 5px;
}

.content {
	text-align: center;
    border: 2px solid #dddddd;
    background-color: #eaf3fd;
    padding: 5px;
}

strong {font-size: 60px;}
</style>

<br>

<div class="title">
	<h3><%=sessionNick%>님의 식습관 점수는??</h3>
</div>
<br>
<div class="content">
		<% if (20<= total && total <=49) { %>
		
		<strong><%=total %>점</strong> 
		<p style="color: red;"><br>당신은 식습관이 나쁜 편입니다. 
		<br>나쁜 식습관은 만성질병을 일으킬 수 있습니다. 
		<br>식사지침 의 키포인트를 항상 염두에 두시어 생활하시길 바라며, 보건소 영양사와 상담하시길 바랍니다.</p>
		
		<% } else if (50<=total && total<=79){ %>
		
		<strong><%=total %>점</strong> 
		<p style="color: #8e9d00;"><br>당신은 식습관이 보통 입니다.
		<br>좋은 식습관도 있지만 그렇지 않은 부분도 있습니다.
		<br>더 좋은 식생활을 위해 노력이 필요하며 식사지침의 키포인트를 항상 염두에 두시어 생활하시길 바랍니다.</p>
		
		<% } else { %>
		
		<strong><%=total %>점</strong> 
		<p style="color: #00930b;"><br>당신은 식습관이 좋은 편입니다.
		<br>현재와 같은 식습관을 유지하시고 식사지침의 키포인트를 항상 염두에 두시어 생활하시길 바랍니다.</p>
		
		<% } %>
</div>
<br>
<div id="btnDiv">
	<button onClick="window.location.reload()">재검사</button>
	<button onclick="location.href='/nutrient/recommend'">영양소 추천받기</button>
</div>
