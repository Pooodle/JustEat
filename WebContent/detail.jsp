<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>details</title>

  <!-- Bootstrap core CSS -->
  <link href="bootstrap-min.css" rel="stylesheet">

  <!-- Custom styles for this template -->

</head>

<body>

  <!-- Navigation -->
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
            <a class="nav-link" href="#">Manage</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
      <h1>${info.retaurantName}</h1>
      <p class="lead">Restaurant ID: ${info.restaurantId}</p>

    </header>

    <!-- Page Features -->
   <form action="cart" class="orderdetail" method="GET">
   <input type ="hidden" id= "restaurantId" name="restaurantId" value=${restaurantId}>
  </container class="row text-center">

      <div class="jumbotron my-4">
        <div class="card h-100">
       
        <c:forEach var="item" items="${itemList}" varStatus="itemLoopCount">
       		
       		<div class="card-body">

            <h3 class="card-title">${item.itemName}</h3>
            <div>
              <div><a class="card-text">소요시간: <b>${item.cookingTime}</b> 분</a></div>
              <div><a class="card-text">금액: <b>${item.cost}</b> 원</a></div>
              <div>
              <input type ="hidden" id=itemId name=itemId value=${item.itemId}></input>
              <input type="number"id= "howmanyItem" name="howmanyItem" min=0 required value=0>개</input>
              </div>
            </div>
            
        </div>

		</c:forEach>
  
      </div>
    </div>
    <div class="jumbotron my-4">
      <div class="card h-100">

        <div class="card-body">
         <c:forEach var="table" items="${tableList}" varStatus="tableLoopCount">
 
          <h7 class="card-title">${table.tableId}번 테이블</h7>
          <div>
           <h5><b class="card-text">${table.capacity}인 좌석</b></h5>
            <div><input type="checkbox" id="checkedTableid" name="checkedTableid" value=${table.tableId}></input></div>
          </div>

		</c:forEach>

        </div>
      </div>
    </div>
  </div>
    <!-- /.row -->
  <div class ="jumbotron" style="background:#ffffff">
    <a><button class="btn btn-primary" type="submit">ORDER</button></a> 
  </div>
</form>

<script>
$(document).on("click","#btn btn-primary",function(){
		$( "#orderdetail" ).submit();
	})
</script>

  </container>
  <!-- /.container -->

</body>

</html>
