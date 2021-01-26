import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Contribution} from "./contribution.model";

@Injectable({
  providedIn: 'root'
})
export class ContributionService {
  endpoint: string = environment.apiUrl + "/contribution";

  constructor(private http: HttpClient) {
  }

  add(contrib: Contribution) {
    return this.http.post(this.endpoint, contrib);
  }

  delete(id: any) {
    return this.http.delete(this.endpoint + `/${id}`);
  }
}
