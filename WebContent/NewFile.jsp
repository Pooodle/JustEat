<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="map_canvas" style="height: 680px;"></div>
<script>    
function initMap() {
    // create the map
    var map = new google.maps.Map(document.getElementById('map_canvas'), {
     zoom: 16,
     // center: latLng,
     mapTypeId: google.maps.MapTypeId.ROADMAP
    });
    // create a bounds object
    var bounds = new google.maps.LatLngBounds();
// for each marker do this
<c:forEach var="item" items="${restaurantList}" varStatus="status">
     var latLng = new google.maps.LatLng(<c:out value="${item.latitude}"/>, <c:out value="${item.longitude}"/>);
     // include in the map bounds                    
     bounds.extend(latLng);
     var markerMap = new MarkerWithLabel({
       position: latLng,
       draggable: true,
       raiseOnDrag: false,
       map: map,
       labelContent: "Content display",
       labelAnchor: new google.maps.Point(30, 30),
       labelClass: "labels", // the CSS class for the label
       isClicked: false
     });

     var windowDialog = new google.maps.InfoWindow({
                           content: "content display dialog"                                            
     });
     google.maps.event.addListener(markerMap, "click", function (e) {
       windowDialog.open(map, this); 
     });                          
</c:forEach>
   // center and zoom map to fit the markers
   map.fitBounds(bounds);
}       
initMap();
</script>
<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBlwSWGOFWka4EJVwl1u23W8x48fEkw0sk&callback=initMap">
    </script>
</body>
</html>