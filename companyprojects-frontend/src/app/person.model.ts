import {Technology} from "./technology.model";

export interface Person {
  id: number | undefined;
  name: string | undefined;
  skills: Technology[] | undefined;
}
