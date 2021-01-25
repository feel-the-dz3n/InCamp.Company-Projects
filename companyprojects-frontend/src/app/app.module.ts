import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompaniesComponent } from './companies/companies.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { CompanyComponent } from './company/company.component';
import { PersonComponent } from './person/person.component';
import { ProjectComponent } from './project/project.component';
import {TokenInterceptor} from "./token-interceptor";

@NgModule({
  declarations: [
    AppComponent,
    CompaniesComponent,
    CompanyComponent,
    PersonComponent,
    ProjectComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
