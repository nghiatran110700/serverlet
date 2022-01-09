<%-- 
    Document   : CheckOut
    Created on : Dec 11, 2021, 11:59:03 AM
    Author     : TRONG NGHIA
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/cart.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	<title>Document</title>
</head>
<body>
     <jsp:include page = "Header.jsp"></jsp:include>
    <div class="container mt-5">
        <div class="d-flex justify-content-center row">
            <div class="col-md-8">
                <div class="p-3 bg-white rounded">
                    <div class="row">
                        <div class="col-md-6">
                            <h1 class="text-uppercase">Invoice</h1>
                            <div class="billed"><span class="font-weight-bold text-uppercase">Billed:</span><span class="ml-1">${user}</span></div>
                            <div class="billed"><span class="font-weight-bold text-uppercase">Date:</span><span class="ml-1">${date}</span></div>
                            <div class="billed"><span class="font-weight-bold text-uppercase">Order ID:</span><span class="ml-1">#1345345</span></div>
                        </div>
                        <div class="col-md-6 text-right mt-3">
                            <h4 class="text-danger mb-0">Rae jones</h4><span>bbbootstrap.com</span>
                        </div>
                    </div>
                    <div class="mt-3">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>image</th>
                                        <th>Product</th>
                                        <th>Unit</th>
                                        <th>Price</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${lstcart}" var="o">
                                     <tr>
                                        <td><img src="${o.image}" style="width:40px;height:40px;" alt=""></td>
                                        <td>${o.nameProduct}</td>
                                        <td>${o.amount}</td>
                                        <td>&euro; ${o.price}</td>
                                        <td>${o.price*o.amount}</td>
                                    </tr>
                                </c:forEach>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td>Total</td>
                                        <td>${total}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                                    <div class="text-right mb-3"><a class="btn btn-danger btn-sm mr-5" href="ContinueBuy">Continue Buy</a></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>