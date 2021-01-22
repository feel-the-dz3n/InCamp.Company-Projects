import {Component, OnInit} from '@angular/core';
import {switchMap} from "rxjs/operators";
import {ActivatedRoute} from "@angular/router";
import {ProjectService} from "../project.service";
import {Project} from "../project.model";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  isLoading: boolean = false;
  project: Project | undefined;

  constructor(private route: ActivatedRoute,
              private projectService: ProjectService) {
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
  }

  getPeople() {
    return this.project && this.project.people ? this.project.people : [];
  }
}
