<html>
	<head>
		<title>Welcome</title>

		<style type="text/css">

		H1 {
		color: black; 
		font-family: Arial; 
		font-size: 150%;
		font-weight: bold;
		}

		P {
		color: black;
		font-family: Arial;
		font-size: 90%;
		text-align: left;
		}

		.pos {
		position:fixed;
		top:30%;
		left:30%;
		right: 30%;
		bottom: 30%;
		}

		</style>
	</head>
	<body>
		<div class="pos">
			<form name="loginform" method="post" action="loginaction.jsp">
				<table align="center" width="300" border="0">
					<tr height="50">
						<td></td>
						<td align="center"><h1>Login</h1></td>
					</tr>
					<tr height="50">
						<td><p>Login</p></td>
						<td><input type="text" size=30 name="login"></td>
					</tr>
					<tr height="50">
						<td><p>Password</p></td>
						<td><input type="text" size=30 name="pass"></td>
					</tr>
					<tr height="50">
						<td></td>
						<td align="center">
							<input align="center" type="submit" value="OK" style="width:100px; height=30px">
						</td>
					</tr>
				</table>
				
			</form>
		</div>
	</body>
</html>