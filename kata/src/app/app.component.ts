import {Component, OnInit} from '@angular/core';

import {IProduct} from './product';
import {ProductService} from './product.service'

@Component({
  selector: 'pm-root',
  templateUrl: 'app.component.html'
})
export class AppComponent {
  pageTitle: string = 'Kata';
  imageWidth: number = 50;
  imageMargin: number = 2;

  products: IProduct[] = [];

  ngOnInit(): void {
    this.products = this._productService.getProducts();
  }

  constructor(private _productService: ProductService) {

  }

  addProduct(product: IProduct): void {
    this._productService.addProductToCart(product);
  }
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/