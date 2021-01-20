import {Component, OnInit} from '@angular/core';
import {Company} from "../company.model";
import {CompanyService} from "../company.service";

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.scss']
})
export class CompaniesComponent implements OnInit {
  isLoading: boolean = false;
  companies: Company[] | undefined;

  constructor(private companyService: CompanyService) {
  }

  ngOnInit(): void {
    this.isLoading = true;
    this.companyService.getCompanies().subscribe(
      response => {
        this.companies = response;
        this.isLoading = false;
      },
      error => {
        alert('Failed to fetch companies, try again later');
        console.log(error);
        this.isLoading = false;
      }
    );
  }

}
