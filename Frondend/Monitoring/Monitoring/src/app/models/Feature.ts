import {forEach} from '@angular/router/src/utils/collection';

export class Feature {

  id: number;
  featureName: string;
  featureUrlExtention: string;
  pollingInterval = 5;
  acceptedResponseCodes: number[];
  acceptedResponseMessages: string[];

  constructor(values: Object = {}) {
    Object.assign(this, values);

  }
}

