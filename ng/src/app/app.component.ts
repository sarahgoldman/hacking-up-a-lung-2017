import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ApiService, RefData, Place } from './api.service';
import { LocationService } from './location.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {

  weatherOptions: RefData[] = [];
  places: Place[] = [];
  condition: string;

  loading: boolean;

  constructor(private apiService: ApiService, private locationService: LocationService) { }

  ngOnInit() {
    this.getWeatherOptions();
  }

  getWeatherOptions(): void {
    this.apiService.getWeatherOptions().subscribe(options => {
      this.weatherOptions = options;
    });
  }

  findPlacesWithWeather(condition: RefData) {
    this.loading = true;
    this.places = [];
    this.condition = condition.name;
    this.apiService.findPlacesWithWeather(condition.id).subscribe(results => {
      console.log(results);
      this.places = results;
      this.populateImgSrcs();
      this.loading = false;
    });
  }

  populateImgSrcs() {
    for (let place of this.places) {
      place.imgSrc = this.locationService.getStaticMapImgSrc(place.coord);
    }
  }

}
