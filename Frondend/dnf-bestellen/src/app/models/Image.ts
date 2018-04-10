export class Image {
  id: number;
  name: string;
  tumbnailhash: string;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}
