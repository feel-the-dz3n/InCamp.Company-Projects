import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Company} from "./company.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private endpoint = 'http://127.0.0.1:8080';

  constructor(private http: HttpClient) {
  }

  getCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(this.endpoint + '/company');
  }
}
