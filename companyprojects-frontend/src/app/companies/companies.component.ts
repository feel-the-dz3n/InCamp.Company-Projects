import {Component, OnInit} from '@angular/core';
import {Company} from "../company.model";

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.scss']
})
export class CompaniesComponent implements OnInit {
  isLoading: boolean = false;
  companies: Company[] | undefined;

  ngOnInit(): void {
    // TODO: fetch companies from service here
  }

}
