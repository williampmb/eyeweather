listLocations = [];

getLocation = function(userid) {
	
	  console.log('getting location from the user: ' + userid);
    $.ajax({
        url: 'latlon/users/'+userid+'/locations',
        type: 'get',
        dataType: 'json',
        success: function(response) {
      	  console.log(response);
      	  listLocations = response;
            toHtml(listLocations, userid);
        },
        error: function(resonse) {
            alert("Could not load the user list");
        }
    });
}

createLocation = function(userid){
	console.log('create location');
	var latitude = $('#latText').val();
	var longitude = $('#lonText').val();
	console.log('lat: ' + latitude );
	
	$.ajax({
		url: 'latlon/users/8ba5c6fe-0128-4a79-a157-4490ade6bb43/locations',
		type: 'post',
		data:{ lat: latitude, lon: longitude},
		dataType:'json',
		success: function(loc){
			console.log('toHtml');
			listLocations = loc
			toHtml(listLocations, userid);
		},
		error: function(xhr, status, errorThrown ){
			alert( "Sorry, there was a problem!" );
	        console.log( "Error: " + errorThrown );
	        console.log( "Status: " + status );
	        console.dir( xhr );

		},
	    complete: function( xhr, status ) {
	        alert( "The request is complete!" );
	    }

	});
	
}

deleteLocation = function (locId,userid){
	console.log('locId' + locId + " userid: " + userid );
	$.ajax({
		url: 'latlon/users/'+userid+'/locations/'+locId,
		type: 'delete',
		success: function(response){
			console.log('success delete');
			listLocations = response
			toHtml(listLocations, userid);
		},
		error: function(xhr, status, errorThrown ){
			console.log('error delete!')
	        console.log( "Error: " + errorThrown );
	        console.log( "Status: " + status );
	        console.dir( xhr );

		},
	    complete: function( xhr, status ) {
	        console.log('complete delete!')
	    }
	});
}

toHtml = function(listLocations, userid){
	console.log('running toHtml');
	console.log(listLocations[0]);
	var locationNode = document.getElementById("locations");
	
	while(locationNode.firstChild){
		locationNode.removeChild(locationNode.firstChild);
	}
	
	listLocations.forEach(function(val, i){
		var divPanelPrimary = document.createElement('div');
		var divPanelHeading = document.createElement('div');
		var divRow = document.createElement('div');
		var divFirstCol = document.createElement('div');
		var divSecondCol = document.createElement('div');
		var h3 = document.createElement('h3');
		var divImg = document.createElement('div');
		var img = document.createElement('img');
		
		var divPanelBody = document.createElement('div');
		var coordSpan = document.createElement('span');
		var firstBr = document.createElement('br');
		var timeSpan = document.createElement('span'); 
		var secondBr = document.createElement('br');
		var wthbSpan = document.createElement('span');
		var thirdBr = document.createElement('br');
		var currentSpan = document.createElement('span');
		var fourthBr = document.createElement('br');
		var forecSpan = document.createElement('span');
		var lastBr = document.createElement('br');
		
		divPanelPrimary.className = "panel panel-primary";
		divPanelHeading.className = "panel-heading";
		divRow.className = "row";
		divFirstCol.className = "col-md-6 col-xs-6";
		divSecondCol.className = "col-md-6 col-xs-6 to-left";
		divPanelBody.className = "panel-body";
		h3.className = "panel-title";
		img.className = "trash";
		
		img.src = "resources/trash-icon.png";
		img.alt = "remove";
		img.setAttribute("onclick", "deleteLocation('"+val.id+"','"+userid+"')");
		
		
		divPanelPrimary.appendChild(divPanelHeading);
		divPanelHeading.appendChild(divRow);
		divRow.appendChild(divFirstCol);
		divRow.appendChild(divSecondCol);
		divPanelPrimary.appendChild(divPanelBody);
		divFirstCol.appendChild(h3);
		divSecondCol.appendChild(divImg);
		divImg.appendChild(img);
		
		
		divPanelBody.appendChild(coordSpan);
		divPanelBody.appendChild(firstBr);
		divPanelBody.appendChild(timeSpan);
		divPanelBody.appendChild(secondBr)
		divPanelBody.appendChild(wthbSpan);
		divPanelBody.appendChild(thirdBr);
		divPanelBody.appendChild(currentSpan);
		divPanelBody.appendChild(fourthBr);
		divPanelBody.appendChild(forecSpan);
		divPanelBody.appendChild(lastBr);
		
		h3.appendChild(document.createTextNode(val.address.fullAddress));
		coordSpan.appendChild(document.createTextNode("Coordinates: (" + val.latitude + ", "+ val.longitude + ")"));
		timeSpan.appendChild(document.createTextNode("Time: " + val.time));
		wthbSpan.appendChild(document.createTextNode("Wind: " + val.climate.currentObv.wind + ", Temperature: " 
				+ val.climate.currentObv.temperature + ", Humidity: " + val.climate.currentObv.humidity + ", Barometric: " 
				+ val.climate.currentObv.barometric ));
		currentSpan.appendChild(document.createTextNode("Current: " + val.climate.currentObv.currentWeather));
		forecSpan.appendChild(document.createTextNode("Forecast: " + val.climate.data.todayForecast));
		
		locationNode.appendChild(divPanelPrimary);
	});
}