import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Person} from "./person.model";
import {ContributionProject} from "./contribution-project.model";

@Injectable({
  providedIn: 'root'
})
export class PeopleService {
  private endpoint: string = 'http://127.0.0.1:8080/people';

  constructor(private http: HttpClient) { }

  get(personId: any) {
    return this.http.get<Person>(this.endpoint + `/${personId}`);
  }

  getContributions(personId: any) {
    return this.http.get<ContributionProject[]>(this.endpoint + `/${personId}/contributions`);
  }
}
