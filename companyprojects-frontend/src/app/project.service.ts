import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Project} from "./project.model";
import {ContributionProject} from "./contribution-project.model";
import {Contribution} from "./contribution.model";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private endpoint: string = 'http://127.0.0.1:8080/project'

  constructor(private http: HttpClient) { }

  get(id: any) {
    return this.http.get<Project>(this.endpoint + `/${id}`);
  }

  getContributions(projectId: any) {
    return this.http.get<Contribution[]>(this.endpoint + `/${projectId}/contributions`);
  }
}
