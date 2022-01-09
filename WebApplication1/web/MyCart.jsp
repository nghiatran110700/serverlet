<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/cart.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	<title>Document</title>
</head>
<body>
     
    
         <div class="card">
		<div class="row">
			<div class="col-md-8 cart">
				<div class="title">
					<div class="row">
						<div class="col">
							<h4><b>Shopping Cart</b></h4>
						</div>
						<div class="col align-self-center text-right text-muted">${size} items</div>
					</div>
				</div>
                            <c:forEach items="${lstcart}" var="o">
                                <div class="row border-top border-bottom">
					<div class="row main align-items-center">
						<div class="col-2"><img class="img-fluid" src="${o.image}"></div>
						<div class="col">
							<div class="row text-muted">Name</div>
							<div class="row">${o.nameProduct}</div>
						</div>
						<div class="col"> <a href="reductionAmount?id=${o.idProduct}">-</a><a href="#" class="border">${o.amount}</a><a href="addAmount?id=${o.idProduct}">+</a> </div>
                                                <div class="col">&euro; ${o.price} <a href="deleteItem?id=${o.idProduct}"><span class="close">&#10005;</span></a></div>
					</div>
				</div>
                            </c:forEach>
				
				
				<div class="back-to-shop"><a href="home">&leftarrow; Back to shop</a></div>
			</div>
			<div class="col-md-4 summary">
				<div>
					<h5><b>Summary</b></h5>
				</div>
				<hr>
				<div class="row">
					<div class="col" style="padding-left:0;">ITEMS ${size}</div>
					<div class="col text-right">&euro; ${total}</div>
				</div>
				
				<div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
					<div class="col">TOTAL PRICE</div>
					<div class="col text-right">&euro; ${total}</div>
				</div> 
				<a class="btn" href="checkout" style="background-color: black; color:white;">CHECKOUT</a>
			</div>
		</div>
	</div>
 
	
</body>
</html>