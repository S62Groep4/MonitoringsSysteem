import { Component, OnInit } from '@angular/core';
import {SystemsDataService} from '../../services/systems-data.service';

@Component({
  selector: 'app-system-list',
  templateUrl: './system-list.component.html',
  styleUrls: ['./system-list.component.css']
})
export class SystemListComponent implements OnInit {
  systems$ = [];

  constructor(private systemDataService: SystemsDataService) {  }
  ngOnInit() {
    this.getAllSystems();
  }

  getAllSystems(): void {
    this.systemDataService.getAllSystems().subscribe((systems) => {
      this.systems$ = systems;
    });
  }


}
