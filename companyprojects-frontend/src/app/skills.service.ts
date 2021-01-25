import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Technology} from "./technology.model";
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SkillsService {
  endpoint: string = environment.apiUrl + "/skills";

  constructor(private http: HttpClient) {
  }

  get(): Observable<Technology[]> {
    return this.http.get<Technology[]>(this.endpoint);
  }
}
