import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';

export interface Location {
  lat: number;
  lon: number;
}

@Injectable()
export class LocationService {

  private GOOGLE_MAP_KEY = 'AIzaSyBcs7S_Ff6OqrFm-jCYe_BA9gk6WaTV0yc';

  constructor() { }

  getCurrentUserLocation(): Observable<Location> {
    let observable = Observable.create(observer => {
      navigator.geolocation.getCurrentPosition(position => {
        observer.next({ lat: position.coords.latitude, lon: position.coords.longitude });
        observer.complete();
      }, err => {
        Observable.throw(null);
      });
    });

    return observable;
  }

  getStaticMapImgSrc(position: Location): string {
    let latlon: string = position.lat + "," + position.lon;
    return 'https://maps.googleapis.com/maps/api/staticmap?center='+latlon+'&zoom=5&size=400x300&sensor=false&style=element:labels|visibility:off&style=element:geometry.stroke|visibility:off&style=feature:landscape|element:geometry|saturation:-100&style=feature:water|saturation:-100|invert_lightness:true&key='+this.GOOGLE_MAP_KEY;
  }

}
