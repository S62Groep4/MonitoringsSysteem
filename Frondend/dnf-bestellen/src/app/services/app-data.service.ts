import {Injectable} from '@angular/core';
import {AuthHttp} from 'angular2-jwt';
import {environment} from '../../environments/environment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {ImageAlbum} from '../models/ImageAlbum';
import {OptionLayer} from '../models/OptionLayer';
import {Customer} from '../models/Customer';

const API_URL = environment.apiUrl;


@Injectable()
export class AppDataService {
  constructor(private http: AuthHttp) {
  }

  private handleError (error: Response | any) {
    console.error('AppDataService::handleError', error);
    return Observable.throw(error);
  }


  public getMyAlbums(): Observable<ImageAlbum[]> {
    return this.http
      .get(API_URL + '/bestellen/MyPhotos')
      .map(response => {
        const albums = response.json();
        console.log(albums.data);
        return albums.data.map((o) => new ImageAlbum(o));
      })
      .catch(this.handleError);
  }
  // Get option layers
  public getOptionLayers(current: OptionLayer[][] ): Observable<OptionLayer[][]> {
    return this.http
      .post(API_URL + '/bestellen/OptionLayers', current)
      .map(response => {
        const layers = response.json();
        return layers.data.map((o) => new OptionLayer(o) );
      })
      .catch(this.handleError);
  }

  // create user
  public createUser(current: Customer): Observable<Customer> {
    return this.http
      .post(API_URL + '/users/create', current)
      .map(response => {
        const image = response.json();
        return image.data.map((o) => new Customer(o) );
      })
      .catch(this.handleError);
  }

  getUsers() {
    return this.http.get('/springjwt/users').map(res => res.json());
  }
}
