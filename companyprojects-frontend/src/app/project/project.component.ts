import {Component, OnInit} from '@angular/core';
import {switchMap} from "rxjs/operators";
import {ActivatedRoute} from "@angular/router";
import {ProjectService} from "../project.service";
import {Project} from "../project.model";
import {Person} from "../person.model";
import {CandidatesService} from "../candidates.service";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  isLoading: boolean = false;
  project: Project | undefined;
  candidates: Person[] = [];

  constructor(private route: ActivatedRoute,
              private projectService: ProjectService,
              private candidatesService: CandidatesService) {
  }

  ngOnInit(): void {
    this.isLoading = true;

    this.route.paramMap.pipe(switchMap(p => this.projectService.get(p.get('id'))))
      .subscribe(
        r => {
          this.project = r;
          this.isLoading = false;
        },
        e => {
          alert("Failed to fetch project");
          console.log(e);
          this.isLoading = false;
        });

    this.route.paramMap.pipe(switchMap(p => this.candidatesService.getForProject(p.get('id'))))
      .subscribe(
        r => {
          this.candidates = r;
          this.isLoading = false;
        },
        e => {
          alert("Failed to fetch candidates");
          console.log(e);
          this.isLoading = false;
        });
  }

  getPeople() {
    return this.project && this.project.people ? this.project.people : [];
  }
}
