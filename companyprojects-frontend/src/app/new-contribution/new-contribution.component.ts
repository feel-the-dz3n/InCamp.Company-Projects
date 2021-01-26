import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {filter, switchMap} from "rxjs/operators";
import {ActivatedRoute} from "@angular/router";
import {PeopleService} from "../people.service";
import {Person} from "../person.model";
import {Technology} from "../technology.model";
import {SelectableTechnology} from "../selectable-technology.model";
import {SkillsService} from "../skills.service";
import {Project} from "../project.model";
import {CompanyService} from "../company.service";
import {CandidatesService} from "../candidates.service";
import {Contribution} from "../contribution.model";

@Component({
  selector: 'app-new-contribution',
  templateUrl: './new-contribution.component.html',
  styleUrls: ['./new-contribution.component.scss']
})
export class NewContributionComponent implements OnInit {
  @Output() submitContrib = new EventEmitter();
  @Input() project?: Project;
  technologies: SelectableTechnology[] = [];
  people: Person[] = [];
  startDate?: string;
  endDate?: string;
  person?: Person;

  constructor(private route: ActivatedRoute,
              private peopleService: PeopleService,
              private skillsService: SkillsService,
              private candidatesService: CandidatesService) {
  }

  ngOnInit(): void {
    this.skillsService.get().subscribe(
      r => {
        this.technologies = r.map(t => new SelectableTechnology(t));
      },
      e => {
        alert('Failed to fetch skills');
        console.log(e);
      }
    );

    this.candidatesService.get(
      this.project?.id,
      false,
      true,
      false,
      true).subscribe(
      people => {
        this.people = people;
      },
      e => {
        console.log(e);
      });
  }

  submit() {
    let contrib = new Contribution();
    contrib.person = this.person;
    contrib.project = this.project;
    contrib.technologies =
      this.technologies.filter(st => st.selected).map(st => st.technology);
    contrib.startDate = this.startDate;
    contrib.endDate = this.endDate;
    this.submitContrib.emit(contrib);
  }

}
