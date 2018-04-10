export class OptionLayer {
  id: number;
  naam: string;
  layerNumber: string;
  aboveLayer: string;
  price: string;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}
