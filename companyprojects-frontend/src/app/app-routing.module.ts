import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompaniesComponent } from "./companies/companies.component";
import { CompanyComponent } from "./company/company.component";
import { PersonComponent } from "./person/person.component";

const routes: Routes = [
  { path: 'companies', component: CompaniesComponent },
  { path: 'company/:id', component: CompanyComponent },
  { path: 'person/:id', component: PersonComponent },
  { path: '', redirectTo: '/companies', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
