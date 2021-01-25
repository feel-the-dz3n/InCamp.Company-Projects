import {Technology} from "./technology.model";
import {Company} from "./company.model";

export interface Person {
  id: number | undefined;
  name: string | undefined;
  skills: Technology[] | undefined;
  membership?: Company[];
}
