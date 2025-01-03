<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/modal.css">
<script src="${pageContext.request.contextPath}/resources/auth.js"></script>
<meta charset="UTF-8">
<title>Codef API Demo</title>
</head>
<body>
	<form>
		<input type="hidden" id="path" value="${pageContext.request.contextPath }">
		<span>이름 : </span><input type="text" id="userName" name="userName" required>
		<span>주민번호13자리 : </span><input type="password" id="identity" name="identity" pattern="[0-9]{13}" required>
		<span>휴대폰번호 : </span><input type="text" id="phoneNo" name="phoneNo" pattern="[0-9]{10,11}" required>
		<select id="loginTypeLevel" name="loginTypeLevel" required>
			<option value="" disabled selected>간편인증 채널</option>
			<option value="1">1:카카오톡</option>
			<option value="2">2:페이코</option>
			<option value="3">3:삼성패스</option>
			<option value="4">4:KB모바일</option>
			<option value="5">5:통신사(PASS)</option>
			<option value="6">6:네이버</option>
			<option value="7">7:신한인증서</option>
		</select>
		<select id="telecom" name="telecom" required>
			<option value="" disabled selected>통신사</option>
			<option value="0">SKT(SKT알뜰폰)</option>
			<option value="1">KT(KT알뜰폰)</option>
			<option value="2">LG U+(LG U+알뜰폰)</option>
		</select>
		<input type="submit" value="운전면허 조회">
	</form>
	<div id="modal">
		<button id="btn">간편인증 완료</button>
	</div>
</body>
</html>