import {Component, OnInit} from '@angular/core';
import {switchMap} from "rxjs/operators";
import {ActivatedRoute} from "@angular/router";
import {ProjectService} from "../project.service";
import {Project} from "../project.model";
import {Person} from "../person.model";
import {CandidatesService} from "../candidates.service";
import {Contribution} from "../contribution.model";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  isLoading: boolean = false;
  project: Project | undefined;
  candidates: Person[] = [];
  contributions: Contribution[] = [];
  addingContrib: boolean = false;

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

    this.route.paramMap.pipe(switchMap(p => this.candidatesService.get(
      p.get('id'),
      true,
      true,
      true,
      false)))
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

    this.route.paramMap.pipe(switchMap(p => this.projectService.getContributions(p.get('id'))))
      .subscribe(
        r => {
          this.contributions = r;
          this.isLoading = false;
        },
        e => {
          alert("Failed to fetch contributors");
          console.log(e);
          this.isLoading = false;
        });
  }

  getPeople() {
    return this.project && this.project.people ? this.project.people : [];
  }

  removeContribution(contrib: Contribution) {
    // TODO
  }

  addContribution(contrib: Contribution) {
    // TODO
  }
}
