import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  // your component view can be found in an external file (templateUrl) or in line (template)
  //template: `<h1>hey! This is my home component!!!</h1>`,
   templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

 

  /*
  Standard TS constructor to instantiate 
  classes
  */
  constructor() {
  
    }


  /*
  This is angular's method that executes once
  the template and component have been fully loaded 
  */
  ngOnInit() {
  }
  /*
  Here is where we can add our class methods
  */

}
