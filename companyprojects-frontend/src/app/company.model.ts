export class Company {
  id: number | undefined;
  name: string | undefined;

  constructor(id: number | undefined, name: string | undefined) {
    this.id = id;
    this.name = name;
  }
}
