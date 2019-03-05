# Project 0

* Create a web application for game with basic static pages like 
  * Home
  * Contacts Us
  * Game Page
  * Sign In 
  * Sign up
  
_sample wireframe is in the github root folder named wireframe-project_

* Home Page:
	leverage various html5 semantics (for textual content)

* Contact Us :
	This would be a basic form with basic validations and an thank you note once user submits the query.
	Its optional if you add location of Revature's office using Geoloaction API
* Sign In :
	Give a basic Javascript Login to it (username as Admin and password as Password 123)
	Use can enter Game page after successful signing in

* Sign Up: This will be the basic form with validations.
  - Required: firstname, last name, age, gender, address line1, zipcode, city, state, country
  - Range : Age (16 to 100)
  - Same values: check if firstname, last name and middle name is same 
  - Phone validation
  - only digits: zip code and phone
  - zipcode validation
  - Only US as country (unless you apply international zipcode API)
		
	- _User will be landed to Home page after successful signing up_
  
	- _zipcode API could be implemented depending up time and curosity._


* Game Page: This is all your imagination

## challenge yourself :
  - use [DRY principle](https://stackoverflow.com/questions/18712338/make-header-and-footer-files-to-be-included-in-multiple-html-pages) : how headers and footers are shared through all pages
  
  - use of [zipcode API](https://www.zipcodeapi.com/)
  
  - use of [Geo location API](https://developer.mozilla.org/en-US/docs/Web/API/Geolocation_API)