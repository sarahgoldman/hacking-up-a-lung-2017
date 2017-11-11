import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/observable/of';

export interface RefData {
  id?: number;
  name?: string;
}

@Injectable()
export class ApiService {

  private API_URL = 'http://34.238.228.33/';  // URL to web api

  constructor(private http: HttpClient) { }

  getWeatherOptions(): Observable<RefData[]> {
    return this.http.get<RefData[]>(this.API_URL + 'conditions');
  }

  findPlacesWithWeather(weatherId: number): Observable<RefData[]> {
    return Observable.of([]);
  }

}
