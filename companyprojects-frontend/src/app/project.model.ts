import {Company} from "./company.model";
import {Technology} from "./technology.model";
import {Person} from "./person.model";

export interface Project {
  id: number | undefined;
  name: string | undefined;
  company: Company | undefined;
  technologies: Technology[] | undefined;
  people: Person | undefined;
}
