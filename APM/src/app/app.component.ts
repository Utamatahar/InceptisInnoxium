import {ProductService} from './products/product.service';
import {ProductListComponent} from './products/productlist.component';
import {Component} from '@angular/core';

@Component({
  selector: 'pm-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  pageTitle: string = 'Acme Product Management';
}
