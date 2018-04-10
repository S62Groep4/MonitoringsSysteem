import {Image} from './Image';
import {Timestamp} from 'rxjs/operators/timestamp';
import DateTimeFormat = Intl.DateTimeFormat;

export class ImageAlbum {
  id: number;
  userid: number;
  images: Image[];
  date: Date;
  dateCreated: string;

  constructor(values: Object = {}) {
    Object.assign(this, values);

  }
}
