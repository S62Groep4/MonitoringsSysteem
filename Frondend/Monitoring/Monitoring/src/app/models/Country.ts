import {forEach} from '@angular/router/src/utils/collection';

export class Country {

  id: number;
  name: string;
  isExternal: boolean;

  constructor(values: Object = {}) {
    Object.assign(this, values);

  }
}

