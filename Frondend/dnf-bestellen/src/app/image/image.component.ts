import {Component, Input, OnInit} from '@angular/core';
import {ImageAlbum} from '../models/ImageAlbum';
import {Image} from '../models/Image';
import {AppDataService} from '../services/app-data.service';
import {OptionLayer} from '../models/OptionLayer';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {
  @Input()
  image$: Image ;
  optionLayers$: OptionLayer[][]= [];
  option$: string;
  constructor(private appService: AppDataService) {
  }

  ngOnInit() {
    this.getLayers();
  }

  getLayers(): void {

    this.appService.getOptionLayers(this.optionLayers$)
      .subscribe(layers => this.optionLayers$ = layers);
  }


}
