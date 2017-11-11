import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';

import { ApiService } from './api.service';
import { LocationService } from './location.service';
import { CoordinatesPipe } from './coordinates.pipe';


@NgModule({
  declarations: [
    AppComponent,
    CoordinatesPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ApiService, LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
