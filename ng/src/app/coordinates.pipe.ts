import { Pipe, PipeTransform } from '@angular/core';
import { Location } from './location.service';

@Pipe({
  name: 'coordinates'
})
export class CoordinatesPipe implements PipeTransform {

  transform(loc: Location, args?: any): any {
    let north = loc.lat > 0 ? 'N' : 'S',
        east = loc.lon > 0 ? 'E' : 'W',
        lat = Math.abs(loc.lat),
        lon = Math.abs(loc.lon);
    return lat+' '+north+', '+lon+' '+east;
  }

}
