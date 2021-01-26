import {Technology} from "./technology.model";

export class SelectableTechnology {
  selected: Boolean = false;
  technology: Technology;

  constructor(selected: Boolean | undefined, technology: Technology) {
    this.technology = technology;
    if (selected)
      this.selected = selected;
  }
}
