import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'; // don't forget this, or you'll get a runtime error
import {System} from '../models/System';
import {tryCatch} from 'rxjs/util/tryCatch';
import {Feature} from '../models/Feature';

const httpHeaders = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class SystemsDataService {


  constructor(private http: HttpClient) {
  }

  public createSystem(system: System): Observable<{} |System> {

    return this.http
      .post('/api/systemmodules/', system, httpHeaders)
      .map(response => {
        console.log(response);
        return  new System(response);
      });
  }

  public addFeatureToSystem(systemid: number, feature: Feature): Observable<{} |System> {

    return this.http
      .post('/api/systemmodules/' + systemid + '/feature', feature, httpHeaders);

  }

  public getAllSystems(): Observable<System[]> {
    return this.http
      .get('/api/systemmodules/' )
      .map(res => res as System[])
      .catch(error => {
        console.error('SystemDataService::handleError', error);
        return Observable.throw(error);
      });
  }

  public getSystem(systemId: string ): Observable<System> {
    return this.http
      .get('/api/systemmodules/' + systemId )
      .map(res => res as System)
      .catch(error => {
        console.error('SystemDataService::handleError', error);
        return Observable.throw(error);
      });
  }

}
