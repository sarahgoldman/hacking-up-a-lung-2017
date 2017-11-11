import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ApiService, RefData } from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {

  weatherOptions: RefData[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.getWeatherOptions();
  }

  getWeatherOptions(): void {
    this.apiService.getWeatherOptions().subscribe(options => {
      this.weatherOptions = options;
    });
  }

  findPlacesWithWeather(weatherId: number) {
    this.apiService.findPlacesWithWeather(weatherId).subscribe(results => {
      console.log(results);
    });
  }

}
