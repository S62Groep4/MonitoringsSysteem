import {Component, Input, OnInit} from '@angular/core';
import {System} from '../../models/System';

@Component({
  selector: 'app-system',
  templateUrl: './system.component.html',
  styleUrls: ['./system.component.css']
})
export class SystemComponent implements OnInit {

  @Input()
  system$: System
  constructor() { }

  ngOnInit() {
  }

}
