import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {AppRoutingModule} from './app-routing.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { SystemListComponent } from './system-modules/system-list/system-list.component';
import { SystemOverviewComponent } from './system-overview/system-overview.component';
import { SystemComponent } from './system-modules/system/system.component';

import {HttpClient, HttpClientModule} from '@angular/common/http';
import {SystemsDataService} from './services/systems-data.service';
import {CountryDataService} from './services/country-data.service';
import { SystemPageComponent } from './system-page/system-page.component';
import {StatusHistoryDataService} from './services/StatusHistory-data.service';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SystemListComponent,
    SystemOverviewComponent,
    SystemComponent,
    SystemPageComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    SystemsDataService,
    StatusHistoryDataService,
    CountryDataService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
