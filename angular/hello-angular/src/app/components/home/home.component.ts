import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-home',
  // your component view can be found in an external file (templateUrl) or in line (template)
  //template: `<h1>hey! This is my home component!!!</h1>`,
   templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

/*
Components in angular have lifecycles managed by the framework itself 
Angular creates and renders components, creates and renders
their children, checks when the data-bound properties change, then 
destroys it before removing it from the DOM 

Angular offers lifecycle hooks that provide visibility/access
to these lifecycle steps and the ability to act when they occur
*/
export class HomeComponent implements OnInit, OnDestroy {

 

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
    console.log('initializing HOME component')
  }
  /*
  Here is where we can add our class methods
  */

  ngOnDestroy(){
    console.log('destroying HOME component')
  }
}
