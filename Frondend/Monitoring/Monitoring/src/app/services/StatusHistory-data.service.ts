import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'; // don't forget this, or you'll get a runtime error
import {System} from '../models/System';
import {tryCatch} from 'rxjs/util/tryCatch';
import {Feature} from '../models/Feature';
import {HttpRequest} from '../models/HttpRequest';

const httpHeaders = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class StatusHistoryDataService {


  constructor(private http: HttpClient) {
  }

  public getAllStatusRequests(featureId: number): Observable<HttpRequest[]> {
    return this.http
      .get('/api/status/' + featureId  )
      .map(res => res as HttpRequest[])
      .catch(error => {
        console.error('SystemDataService::handleError', error);
        return Observable.throw(error);
      });
  }


}
