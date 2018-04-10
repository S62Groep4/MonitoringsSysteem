export class Customer {
  public id: number;
  public email: string;
  public name: string;
  public lastName: String;
  public note: string;
  public hash: string;
  public dateCreated: Date;
  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}
