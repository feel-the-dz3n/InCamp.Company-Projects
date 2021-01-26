import {Component, OnInit} from '@angular/core';
import {PeopleService} from "../people.service";
import {ActivatedRoute} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {Person} from "../person.model";
import {ContributionProject} from "../contribution-project.model";
import {Technology} from "../technology.model";
import {Contribution} from "../contribution.model";

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.scss']
})
export class PersonComponent implements OnInit {
  isLoading: boolean = false;
  person: Person | undefined;
  contributions: Contribution[] = [];

  constructor(private peopleService: PeopleService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.isLoading = true;

    this.route.paramMap.pipe(switchMap(p => this.peopleService.get(p.get('id'))))
      .subscribe(
        r => {
          this.person = r;
          this.isLoading = false;
        },
        e => {
          alert("Failed to fetch person");
          console.log(e);
          this.isLoading = false;
        });

    this.route.paramMap.pipe(switchMap(p => this.peopleService.getContributions(p.get('id'))))
      .subscribe(
        r => {
          this.contributions = r;
          this.isLoading = false;
        },
        e => {
          alert("Failed to fetch contributions");
          console.log(e);
          this.isLoading = false;
        });
  }

  getSkills(): Technology[] {
    return this.person && this.person.skills ? this.person.skills : [];
  }

  formatDateDigit(num: any) {
    if ((num + '').length <= 1) {
      return '0' + num;
    }
    else {
      return num;
    }
  }

  getFormattedDate(date: Date) {
      let day = this.formatDateDigit(date.getDate());
      let month = this.formatDateDigit(date.getMonth() + 1);
      let year = date.getFullYear();
      return `${day}.${month}.${year}`;
  }

  getDatePeriod(startDateISO: any, endDateISO: any) {
    let startDate = new Date(startDateISO);
    let endDate = new Date(endDateISO);

    return `${this.getFormattedDate(startDate)} - ${this.getFormattedDate(endDate)}`;
  }
}
