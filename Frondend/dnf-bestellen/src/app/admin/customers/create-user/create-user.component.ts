import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../models/Customer';
import {AppDataService} from '../../../services/app-data.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  errorMessage: string;
  model = new Customer();

  constructor(private appDataService: AppDataService) { }

  ngOnInit() {
  }


  register() {
    this.appDataService.createUser(this.model).subscribe((returnUser) => {
      this.model = returnUser;
    });
  }

  get currentBook() {     return JSON.stringify(this.model);
  }


}
