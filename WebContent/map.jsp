<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link rel="stylesheet" href="search.css">
    <link rel="stylesheet" href="bootstrap-min.css">
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
    
    <style>
      /* Set the size of the div element that contains the map */
      #map {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
    </style>
    
<title>search</title>
  </head>
  <body>

    <div class="s010">

    
	 <form action = "search" class="btnsearch">	   
        <div class="inner-form">
          <div class="basic-search">

              
          </div>
          <div class="advance-search">
          
    
    <!--The div element for the map -->
    <div id="map"></div>
    <script>
    
	// Initialize and add the map
	function initMap() {

		var latlngset = new google.maps.LatLng('${latitude}', '${longitude}');
		var latlngset2 = new google.maps.LatLng(37.278688, 127.040913);
		var latlngset3 = new google.maps.LatLng(37.276255, 127.042670);
		var latlngset4 = new google.maps.LatLng(37.274378, 127.049203);
		var latlngset5 = new google.maps.LatLng(37.281187, 127.050230);
		var latlngset6 = new google.maps.LatLng(37.277058, 127.041415);
		var latlngset7 = new google.maps.LatLng(37.278647, 127.050099);
		var latlngset8 = new google.maps.LatLng(37.277125, 127.038153);
		var latlngset9 = new google.maps.LatLng(37.277018, 127.042303);
		var latlngset10 = new google.maps.LatLng(37.273526, 127.046424);
		
		var informations;
		
		 var contentString1 = '<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">'+
		  '</nav>'+
		  '<form action="detail" method="GET">'+
		    '<h3 id="firstHeading" class="firstHeading">${restaurantName}</h3>'+
		    '<div class="row text-center" id=bodyContent>'+
		      '<div class="col-lg-3 col-md-6 mb-4">'+
		        '<div class="card h-100">'+
		          '<img class="text-center" id= "image" src=${photo} style = "width:100px;  hight:200px;">'+
		          '<input type=hidden id="restaurantId" name ="restaurantId" value= ${restaurantId}></input>'+
		      '</div>'+
		    '</div>'+

		        '<div class="text-left"">'+
		          '<p>전화번호:${phoneNum}</p>'+
		          '<p>주소:${address}</p>'+
		        '</div>'+

		    '</div>'+
		    '<div class="card-footer">'+
		    '<button class="btn-order" style="width: 100px; height: 30px; color: #ffffff; background-color: #007bff;  border-color: #007bff;border-style: solid; border-width: 3px;">주문</button>'+
		    '</div>'+
		  '</form>';
		  
			 var contentString2 = '<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">'+
			  '</nav>'+
			  '<form action="detail" method="GET">'+
			    '<h3 id="firstHeading" class="firstHeading">본수원</h3>'+
			    '<div class="row text-center" id=bodyContent>'+
			      '<div class="col-lg-3 col-md-6 mb-4">'+
			        '<div class="card h-100">'+
			          '<img class="text-center" id= "image" src="https://s3-ap-northeast-1.amazonaws.com/dcreviewsresized/20200617082702_photo1_9b1b25fe8c40.jpg" style = "width:100px;  hight:200px;">'+
			          '<input type=hidden id="restaurantId" name ="restaurantId" value= ${restaurantId}></input>'+
			      '</div>'+
			    '</div>'+

			        '<div class="text-left"">'+
			          '<p>전화번호:031-211-8434</p>'+
			          '<p>주소: 수원시 팔달구 우만동 103-1</p>'+
			        '</div>'+

			    '</div>'+
			    '<div class="card-footer">'+
			    '<button class="btn-order" style="width: 100px; height: 30px; color: #ffffff; background-color: #007bff;  border-color: #007bff;border-style: solid; border-width: 3px;">주문</button>'+
			    '</div>'+
			  '</form>';
		
		informations = [
			[latlngset,"키와마루아지",contentString1],
			[latlngset2,"본수원",contentString2],
			[latlngset3,"태화장",contentString1],
			[latlngset4,"신라갈비",contentString1],
			[latlngset5,"정진식당",contentString1],
			[latlngset6,"이모네손칼국수",contentString1],
			[latlngset7,"티철판요리전문점",contentString1],
			[latlngset8,"일인자감자탕",contentString1],
			[latlngset9,"두메산골",contentString1],
			[latlngset10,"군포해물탕",contentString1],
		      ]
		
     	var map = new google.maps.Map(document.getElementById('map'), {
	          zoom: 15,
	          center: latlngset
	        });
  

		var infowindow = new google.maps.InfoWindow({
			});
	
		// marker 반복문
		for (var i = 0; i < informations.length ; i++) {
				var marker = new google.maps.Marker({
				    position: informations[i][0],
				    map: map,
				    title: informations[i][2]

				});
				
				google.maps.event.addListener(marker, 'click', function() {
		  			infowindow.setContent(this.title);
		  			infowindow.open(map, this);
		  		  	maxWidth: 200
		  		  }); 

			}

	}
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBlwSWGOFWka4EJVwl1u23W8x48fEkw0sk&callback=initMap">
    </script>
    
            <span class="desc"></span>
            
            <div class="row third">
              <div class="input-field">
				<div>
                <p style="color:#808080;">  "<b>${search}</b>" 검색결과  <b>${count}</b> </p></div>
                <div>
                  <button class="btn-search">SEARCH</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
    <script>
    
      const customSelects = document.querySelectorAll("select");
      const deleteBtn = document.getElementById('delete')
      const choices = new Choices('select',
      {
        searchEnabled: false,
        itemSelectText: '',
        removeItemButton: true,
      });
      for (let i = 0; i < customSelects.length; i++)
      {
        customSelects[i].addEventListener('addItem', function(event)
        {
          if (event.detail.value)
          {
            let parent = this.parentNode.parentNode
            parent.classList.add('valid')
            parent.classList.remove('invalid')
          }
          else
          {
            let parent = this.parentNode.parentNode
            parent.classList.add('invalid')
            parent.classList.remove('valid')
          }
        }, false);
      }
      deleteBtn.addEventListener("click", function(e)
      {
        e.preventDefault()
        const deleteAll = document.querySelectorAll('.choices__button')
        for (let i = 0; i < deleteAll.length; i++)
        {
          deleteAll[i].click();
        }
      });
      
      
      $(document).on("click","#btn-search",function(){
  		$( "#btnsearch" ).submit();
  	})
  	
  	      $(document).on("click","#btn-order",function(){
  		$( "#btnorder" ).submit();
  	})

    </script>
  </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>