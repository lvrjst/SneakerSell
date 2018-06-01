<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
	<link rel="stylesheet" type="text/css" href="css/floating_menu.css">
	<title>Air Jordan's History</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
		<jsp:include page="topMenu.jsp" />
		<jsp:include page="sideMenu.jsp" />

	<div class="contents">
		<div class="top" id="home">
			<img src="image/top.jpeg">
		</div>
		<div id="jordan">
			<h1>Who is Michael Jordan</h1>
			<img src="image/jordan.jpeg">
			<p>Michael Jeffrey Jordan (born February 17, 1963) is a professional American basketball player, Olympic athlete, businessperson and actor. Considered one of the best basketball players ever, Michael Jordan dominated the sport from the mid-1980s to the late 1990s. He led the Chicago Bulls to six National Basketball Association championships and earned the NBA's Most Valuable Player Award five times. With five regular-season MVPs and three All-Star MVPs, Jordan became the most decorated player in the NBA.</p>
		</div>

		<div id="nike">
			<h1>History of Nike and <span>Air Jordan</span></h1><br>
			<iframe width="560" height="315" src="https://www.youtube.com/embed/eEmAgKYV1uo" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe><br>
			<p>The Nike Air Jordans are a cultural icon and is primarily responsible for the birth of the sneaker collecting industry. The AJ1 debuted in 1984 and were quickly banned by the NBA for being too much for the conservative league. Coupled with some of the most innovated commercials in history along with being worn by the best basketball player to have ever played the game, the NBA was quick to adapt to the changing culture Michael Jordan was about to impose on the world.</p><br><br><br><br>
		</div>
		<div id="cloth" >
			<h1>Air Jordan Clothes</h1>
				<img src="image/cloth_hoodie.jpeg">
				<img src="image/cloth_lady.jpeg">
				<img src="image/cloth_baby.jpeg">
				<img src="image/cloth_shoes.jpeg">
		</div>
		<div id="sneaker" >
			<h1>Air Jordan Sneakers</h1>
			<div class="shoes_box">
				<div class="left_box">
					<img src="image/shoes1.jpeg" title="JordanⅠ collaborate with buggs bunny" class="shoes1" >
					<img src="image/shoes2.jpeg" title="jordanⅤ collaborate with supreme" class="shoes2" >
				</div>
				<img src="image/shoes3.jpeg" title="Eminem is wearing JordanⅣ" class="shoes3">
			</div>
		</div>

		<div id="contact" >
			<h1>Contact form</h1>
				<form>
					Email Address:<br>
					<input type="email" placeholder="Your Email Address" size="40"><br><br>
					Confirm Email Address:<br>
					<input type="email" placeholder="Confirm Your Email Address" size="40"><br><br>
					Name:<br>
					<input type="text" placeholder="Your Name" size="40"><br><br>
					Favorite Basketball Player:<br>
					<input type="text" placeholder="Player Name" size="40"><br><br>
					Message:<br>
					<textarea rows="10" cols="38" placeholder="Your Message"></textarea><br><br>
					<input type="submit" value="Send Message">
				</form>
		</div>

	<footer>
		<h3>copyright law @ MJ</h3>
	</footer>
	</div>
</body>
</html>