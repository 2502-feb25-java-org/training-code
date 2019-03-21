window.onload = function(){
	console.log('app loading..');
	loadLandingView();
}

/*
 * This function will use AJAX to send a request 
 * to our LoadViewServlet, which will return our
 * landing page partial html 
 * 
 * We will then use our response (the html) as 
 * the inner HTML of our view div
 */
function loadLandingView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//here is where we  manipulate our response.. whenever we get it 
		if(xhr.readyState==4){
			console.log('response received');
			if(xhr.status==200){
				//success
				//we know that our response will be HTML
				$('#view').html(xhr.responseText);
				//ADD EVENT LISTENERS TO OUR HTML 
			}
			if(xhr.status > 399){
				//some sort of error 
			}
		}
	}
	
	xhr.open("GET", "loadView");
	xhr.send();
}