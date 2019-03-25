import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {
  items = ['wine', 'steak', 'travel', 'other things that are expensive'];
  employees = [
    { 
      name: 'Genesis', 
      role: 'Trainer'
    },
    { 
      name: 'Pushpinder', 
      role: 'Trainer'
    },
    { 
      name: 'Patrick', 
      role: 'Trainer'
    },
    { 
      name: 'David', 
      role: 'Associate'
    },
    { 
      name: 'Alex', 
      role: 'Associate'
    },
    { 
      name: 'Tiffany', 
      role: 'Associate'
    },
    
  ];
  constructor() { }

  ngOnInit() {
  }

}
