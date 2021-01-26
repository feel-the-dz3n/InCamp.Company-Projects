import {Technology} from "./technology.model";

export class SelectableTechnology {
  selected: boolean = false;
  technology: Technology;

  constructor(technology: Technology) {
    this.technology = technology;
  }
}
