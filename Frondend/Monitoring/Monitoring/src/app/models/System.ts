import {Country} from './Country';
import {Feature} from './Feature';

export class System {

  id: number;
  componentName: string;
  country: Country;
  url: String;
  systemFeatures: Feature[];

  constructor(values: Object = {}) {
    Object.assign(this, values);

  }

}

