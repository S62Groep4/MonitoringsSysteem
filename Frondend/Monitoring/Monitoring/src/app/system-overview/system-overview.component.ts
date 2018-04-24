import { Component, OnInit } from '@angular/core';
import {System} from '../models/System';
import {SystemsDataService} from '../services/systems-data.service';
import {CountryDataService} from '../services/country-data.service';
import {Country} from '../models/Country';

@Component({
  selector: 'app-system-overview',
  templateUrl: './system-overview.component.html',
  styleUrls: ['./system-overview.component.css']
})
export class SystemOverviewComponent implements OnInit {
createSystem: System = new System();
countries$: Country[];
selectedCountryId: number;
  constructor( private countryDataService: CountryDataService, private systemDataService: SystemsDataService) { }

  ngOnInit() {
    this.loadCountries();
  }

  postSystem(): void {
    console.log(this.createSystem.componentName);
    this.countryDataService.getCountry(this.selectedCountryId).subscribe((returnCountry) => {
      this.createSystem.country = returnCountry;
      this.systemDataService.createSystem(this.createSystem)
        .subscribe((returnCountryList) => {

          this.createSystem = new System();
        });
    });

  }

  loadCountries() {
    this.countryDataService.getAllCountries().subscribe((returnCountryList) => {
      this.countries$ = returnCountryList;
    });
  }


}
