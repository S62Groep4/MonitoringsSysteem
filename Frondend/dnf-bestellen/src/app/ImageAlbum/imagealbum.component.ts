import {Component, OnInit} from '@angular/core';

import {AppDataService} from '../services/app-data.service';
import {ImageAlbum} from '../models/ImageAlbum';

@Component({
  selector: 'app-user',
  templateUrl: './imagealbum.component.html',
  styleUrls: ['./imagealbum.component.css']
})
export class UserComponent implements OnInit {
  imagealbums$: ImageAlbum[] = [];

  constructor(private appDataService: AppDataService) {
  }

  ngOnInit() {
     this.appDataService.getMyAlbums().subscribe((albums) => {
       this.imagealbums$ = albums;
     }
       );
  }
}
