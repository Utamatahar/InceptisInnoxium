import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {CartComponent} from './cart.component'
import {ProductService} from './product.service';

let schemas: any[] = [];
schemas.push(CUSTOM_ELEMENTS_SCHEMA);
@NgModule({
  imports: [
    BrowserModule
  ],
  declarations: [
    AppComponent,
    CartComponent,
  ],
  providers: [
    ProductService
  ],
  bootstrap: [AppComponent],
  schemas: schemas
})
export class AppModule {}