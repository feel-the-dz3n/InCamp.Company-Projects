import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Person} from "./person.model";

@Injectable({
  providedIn: 'root'
})
export class CandidatesService {
  private endpoint: string = 'http://127.0.0.1:8080/candidates';

  constructor(private http: HttpClient) {
  }

  /*ublic ResponseEntity<Iterable<Person>> get(
    @RequestParam Integer projectId,
  @RequestParam boolean checkProjectMembership,
  @RequestParam boolean checkCompanyMembership,
  @RequestParam boolean checkSkills,
  @RequestParam boolean noTargetProjectContrib*/
  get(
    projectId: any,
    checkProjectMembership: boolean,
    checkCompanyMembership: boolean,
    checkSkills: boolean,
    noTargetProjectContrib: boolean) {
    return this.http.get<Person[]>(
      this.endpoint +
      `?projectId=${projectId}` +
      '&checkProjectMembership=' + checkProjectMembership +
      '&checkCompanyMembership=' + checkCompanyMembership +
      '&checkSkills=' + checkSkills +
      '&noTargetProjectContrib=' + noTargetProjectContrib);
  }
}
