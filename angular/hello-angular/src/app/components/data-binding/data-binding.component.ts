import { Component, OnInit, OnChanges } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit, OnChanges {
  name =  'Genesis';
  count = 0;
  time: Date;
  colorProp = '#123456';
  constructor() {
    setInterval(
      () => {
        this.time = new Date();
      }, 1000);
   }

  ngOnInit() {
  }

  increment() {
    this.count++;
  }

  ngOnChanges(){
    console.log('DATABINDING component changes');
  }
  
}
