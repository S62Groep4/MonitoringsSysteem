import {forEach} from '@angular/router/src/utils/collection';
import {Feature} from './Feature';

export class HttpRequest {

  id: number;
  responseStatus: string;
  responseNumber: number;
  reponseMessage: string;
  systemFeature: Feature;

  constructor(values: Object = {}) {
    Object.assign(this, values);

  }
}

