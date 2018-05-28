import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {System} from '../models/System';
import {SystemsDataService} from '../services/systems-data.service';
import {Feature} from '../models/Feature';
import {StatusHistoryDataService} from '../services/StatusHistory-data.service';
import {HttpRequest} from '../models/HttpRequest';
import {forEachComment} from 'tslint';
import {forEach} from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-system-page',
  templateUrl: './system-page.component.html',
  styleUrls: ['./system-page.component.css']
})
export class SystemPageComponent implements OnInit {

  system$: System;
  createSystemFeature = new Feature();
  httpRequests$: HttpRequest[] = [];
  createSystemFeatureAcceptedCode: number;
  constructor(private statusHistory: StatusHistoryDataService, private systemDataService: SystemsDataService, private route: ActivatedRoute, private router: Router) {
    this.route.params.subscribe( params => this.getSystem(params) );
  }

  private getSystem(params: Params) {
    if (params.id !== undefined) {
      this.systemDataService.getSystem(params.id).subscribe((system) => {
        this.system$ = system;
        this.getHttpPosts();

      });
    } else {
      this.router.navigateByUrl('/');

    }
  }


  ngOnInit() {
  }

  private createFeature() {
    this.createSystemFeature.acceptedResponseCodes.push(this.createSystemFeatureAcceptedCode);
    this.systemDataService.addFeatureToSystem(this.system$.id, this.createSystemFeature).subscribe(value => {
      this.system$.systemFeatures.unshift(this.createSystemFeature);
    }, error2 => {
      alert(error2);
    });
  }

  private getHttpPosts() {
    this.system$.systemFeatures.forEach( feature => {
      this.statusHistory.getAllStatusRequests(feature.id).subscribe(value => {
        value.forEach(obj => {
          this.httpRequests$.unshift(obj);
        });
      });
    });

  }

}
