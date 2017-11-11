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

  findPlacesWithWeather(weatherId: number) {
    this.loading = true;
    this.places = [];
    this.apiService.findPlacesWithWeather(weatherId).subscribe(results => {
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
