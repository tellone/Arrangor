
<%@page language="java" contentType="text/html"%>
// <jsp:useBean id="Arrangor" class="classes.Arrangor"/> 
<html>
	<head>
		<title> Lägg till arragörer </title>
		<script type="text/javascript" src="1.91.min.js"></script>
		<script>
			$(document).ready( function() ( { 
				$("form").submit(function() {
				if ( $(this).name() = "Email") {
				isEmail = true

				var isEmail = false
				$(this).find(":text").each(function() {
					if ==	
					CheckifValid(
				 
		</script>
	</head>
	<body>	
		<h1> Sätt in namn, Telefon nummer och Email </h1>
		<form id="arr_form" method="post" action="input_data.jsp" onSubmit=" r" >
			<table width="68%" border="3" cellspacing="2" cellpadding="0" >
				<tr>
					<td width="22%">&nbsp;</td>
					<td width="78%">&nbsp;</td>
				</tr>
				<tr>
					<td>Namn </td>
					<td><input type="text" name="Arrangör Namn"></td>
				</tr>
				<tr>
					<td>Telefon nummer</td>
					<td><input type="text" name="telefon nummer"></td>
				</tr>
				<tr>
					<td>Email adress</td>
					<td><input type="text" name="Email"></td>
				</tr>
				<tr>
					<td>Email adress igen</td>
					<td><input type="text" name="Email Valdid"></td>
				</tr>

				
			</table>
</form>
</body>
