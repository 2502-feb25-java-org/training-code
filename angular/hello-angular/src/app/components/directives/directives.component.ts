import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {
  items = ['wine', 'steak', 'travel', 'other things that are expensive'];

  constructor() { }

  ngOnInit() {
  }

}
