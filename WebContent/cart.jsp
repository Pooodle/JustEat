<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="bootstrap-min.css">
<link rel="stylesheet" href="payment.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
   
    
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="search">Just Eat</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="search">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">CART</h1>
        <c:forEach var="choosedItem" items="${choosedItemlsit}" varStatus="itemidLoopCount">
        <tr><td>${choosedItem.quantity}</td></tr>
  		</c:forEach>

     </div>
</section>

<form action="payment" class ="payment" method="GET">

<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                          
                            <th scope="col">Product
                            <i class="fa fa-shopping-basket"></i>
                            </th>
                            
                            <th scope="col" class="text-center">Quantity</th>
                            <th scope="col" class="text-right">Price</th>
                           
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="choosedItem" items="${choosedItemlsit}" varStatus="itemidLoopCount">
       					<tr>
                            
                            <td>${choosedItem.item.itemName}</td>
                          
                            <td  class="text-center"><type="text"/>${choosedItem.quantity}</td>
                            <td class="text-right">${choosedItem.item.cost}</td>
                        
                        </tr>

  					</c:forEach> 
                        <tr>
                        <td></td>
                            <td  class="text-center"><strong>Total</strong></td>
                            <td class="text-right"><strong>${total}</strong></td>
                            <input type="hidden" id="total" name="total" value=${total}></input>
                        </tr>
                    </tbody>
                </table>
                
                 <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Table
                            <i class="fa fa-user-o"></i>
                            
                            </th>
                            <th scope="col" class="text-center"></th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <c:forEach var="table" items="${choosedTablelist}" varStatus="tableLoopCount">
       					<tr>
                            <td>${table.table.tableId}번</td>
                           <td class="text-center"><type="text">${table.table.capacity}인</td>
                        </tr>
       		</c:forEach> 
            
                    </tbody>
                </table>
                
                
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <button class="btn btn-block btn-light" formaction="detail">Continue Shopping</button>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase">Checkout
                    <i class="fa fa-krw" aria-hidden="true"></i>
                    </button>
                   
                    <script type="text/javascript">
                    $(document).on("click","#btn btn-lg btn-block btn-success text-uppercase",function(){
                		$( "#payment" ).submit();
                	})
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
</form>