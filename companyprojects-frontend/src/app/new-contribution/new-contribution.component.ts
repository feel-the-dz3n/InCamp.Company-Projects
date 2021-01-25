import {Component, OnInit} from '@angular/core';
import {switchMap} from "rxjs/operators";
import {ActivatedRoute} from "@angular/router";
import {PeopleService} from "../people.service";
import {Person} from "../person.model";
import {Technology} from "../technology.model";
import {SelectableTechnology} from "../selectable-technology.model";
import {SkillsService} from "../skills.service";
import {Project} from "../project.model";
import {CompanyService} from "../company.service";

@Component({
  selector: 'app-new-contribution',
  templateUrl: './new-contribution.component.html',
  styleUrls: ['./new-contribution.component.scss']
})
export class NewContributionComponent implements OnInit {
  person?: Person;
  technologies?: SelectableTechnology[];
  projects: Project[] = [];

  constructor(private route: ActivatedRoute,
              private peopleService: PeopleService,
              private skillsService: SkillsService) {
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

    this.route.paramMap.pipe(switchMap(p => this.peopleService.get(p.get('id')))).subscribe(
      person => {
        this.person = person;
      },
      e => {
        console.log(e);
      });

    this.route.paramMap.pipe(switchMap(p => this.peopleService.getMembershipProject(p.get('id')))).subscribe(
      projects => {
        this.projects = projects;
      },
      e => {
        console.log(e);
      });
  }

}
