import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  // your component view can be found in an external file (templateUrl) or in line (template)
  //template: `<h1>hey! This is my home component!!!</h1>`,
   templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  name =  'Genesis';

  time: Date;
  /*
  Standard TS constructor to instantiate 
  classes
  */
  constructor() {
    setInterval(
      () => {
        this.time = new Date();
      }, 1000);
    }


  /*
  This is angular's method that executes once
  the template and component have been fully loaded 
  */
  ngOnInit() {
  }

}
