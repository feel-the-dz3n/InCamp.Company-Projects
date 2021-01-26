import {Technology} from "./technology.model";
import {Project} from "./project.model";
import {Person} from "./person.model";

export interface Contribution {
  id: number | undefined;
  project: Project;
  technologies: Technology[];
  person: Person;
  startDate: string | undefined;
  endDate: string | undefined;
}
