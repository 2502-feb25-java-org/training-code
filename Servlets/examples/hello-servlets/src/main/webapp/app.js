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
				$('#login').on('click', login);
				//ADD EVENT LISTENERS TO OUR HTML 
			}
		
		}
	}
	xhr.open("GET", "loadView");
	xhr.send();
}

function login(){
	var name = $('#username').val();
	var pw = $('#password').val();
	var user = {
			username: name, 
			password: pw
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
	}
	xhr.open("POST", login);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(user));
	
}