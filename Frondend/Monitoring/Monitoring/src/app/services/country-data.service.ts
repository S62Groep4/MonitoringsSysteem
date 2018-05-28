import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'; // don't forget this, or you'll get a runtime error
import {System} from '../models/System';
import {tryCatch} from 'rxjs/util/tryCatch';
import {Country} from '../models/Country';

const httpHeaders = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CountryDataService {


  constructor(private http: HttpClient) {
  }

  public createCountry(country: Country): Observable<Country> {

    return this.http
      .post('/api/country/', country, httpHeaders)
      .map(response => {
        return  new Country(response);
      });
  }

  public getAllCountries(): Observable<Country[]> {
    return this.http
      .get('/api/country/' )
      .map(res => res as Country[])
      .catch(error => {
        console.error('CountryDataService::handleError', error);
        return Observable.throw(error);
      });
  }


  public getCountry(id: number): Observable<Country> {

    return this.http
      .get('/api/country/1', httpHeaders)
      .map(response => {
        return  new Country(response);
      });
  }

}
