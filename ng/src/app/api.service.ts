import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/observable/of';

import { LocationService, Location } from './location.service';

export interface RefData {
  id?: number;
  name?: string;
}

export interface Place {
  id?: string;
  name: string;
  country: string;
  coord: Location;
  imgSrc?: string;
}

@Injectable()
export class ApiService {

  private API_URL = 'http://34.238.228.33/';  // URL to web api

  constructor(private http: HttpClient, private locationService: LocationService) { }

  getWeatherOptions(): Observable<RefData[]> {
    return this.http.get<RefData[]>(this.API_URL + 'conditions');
  }

  findPlacesWithWeather(weatherId: number): Observable<Place[]> {
    console.log('get places with weather condition id: '+weatherId);
    return this.locationService.getCurrentUserLocation().mergeMap(loc => {
      console.log('user location:');
      console.log(loc);
      // return this.http.get<Place[]>(this.API_URL + 'places?condition='+weatherId+'&lat='+loc.lat+'&lon='+loc.lon);
      return Observable.of([
        { id: '01', name: 'Arlington', country: 'US', coord: { lon: -122.43, lat: 37.76 } },
        { id: '01', name: 'New York', country: 'US', coord: { lon: -80.43, lat: 37.76 } },
        { id: '01', name: 'Baltimore', country: 'US', coord: { lon: -42.43, lat: 37.76 } },
        { id: '01', name: 'Chicago', country: 'US', coord: { lon: 22.43, lat: 37.76 } }
      ]);
    });
  }

}
