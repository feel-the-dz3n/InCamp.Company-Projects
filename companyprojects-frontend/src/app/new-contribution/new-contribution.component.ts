import {Component, Input, OnInit} from '@angular/core';
import {switchMap} from "rxjs/operators";
import {ActivatedRoute} from "@angular/router";
import {PeopleService} from "../people.service";
import {Person} from "../person.model";
import {Technology} from "../technology.model";
import {SelectableTechnology} from "../selectable-technology.model";
import {SkillsService} from "../skills.service";
import {Project} from "../project.model";
import {CompanyService} from "../company.service";
import {CandidatesService} from "../candidates.service";

@Component({
  selector: 'app-new-contribution',
  templateUrl: './new-contribution.component.html',
  styleUrls: ['./new-contribution.component.scss']
})
export class NewContributionComponent implements OnInit {
  @Input() project?: Project;
  technologies?: SelectableTechnology[];
  people: Person[] = [];

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
      true,
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

}
