import {ConvertToSpacesPipe} from '../shared/convert-to-space.pipe';
import {StarComponent} from '../shared/star.component';
import {ProductDetailComponent} from './product-detail.component';
import {ProductGuardService} from './product-guard.service';
import {ProductListComponent} from './productlist.component';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {SharedModule} from '../shared/shared.module';

@NgModule({
  imports: [
    RouterModule.forChild([
      {path: 'products', component: ProductListComponent},
      {
        path: 'products/:id',
        canActivate: [ProductGuardService],
        component: ProductDetailComponent
      }
    ]),
    SharedModule

  ],
  declarations: [
    ProductListComponent,
    ConvertToSpacesPipe,
    ProductDetailComponent
  ],
  providers: [ProductGuardService]
})
export class ProductModule {}
