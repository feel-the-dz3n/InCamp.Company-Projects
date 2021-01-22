import { Component, OnInit } from '@angular/core';
import {Company} from "../company.model";
import {CompanyProject} from "../company-project.model";
import {ActivatedRoute} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {CompanyService} from "../company.service";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.scss']
})
export class CompanyComponent implements OnInit {
  company: Company | undefined;
  isLoading: boolean = false;
  companyProjects: CompanyProject[] = [];

  constructor(private companyService: CompanyService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(async (p) => p.get('id'))).subscribe(
      companyId => {
        this.isLoading = true;

        this.companyService.getCompany(companyId).subscribe(
          r => {
            this.company = r;
            this.isLoading = false;
          },
          e => {
            alert("Failed to fetch company");
            console.log(e);
            this.isLoading = false;
          }
        );

        this.companyService.getCompanyProjects(companyId).subscribe(
          r => {
            this.companyProjects = r;
            this.isLoading = false;
          },
          e => {
            alert("Failed to fetch company projects");
            console.log(e);
            this.isLoading = false;
          }
        );
      }
    );
  }

}
