import {Component, OnInit} from '@angular/core';

import {IProduct} from './product';
import {ProductService} from './product.service'
import {Listener} from './listener';

@Component({
  selector: 'pm-cart',
  templateUrl: './cart.component.html'
})
export class CartComponent implements Listener {
  pageTitle: string = 'cart'
  imageWidth: number = 50;
  imageMargin: number = 2;

  total: number = 0;

  products: IProduct[] = []

  constructor(private _productService: ProductService) {

  }

  setProductList(products: IProduct[]): void {
    this.products = products;
    //this.calculTotal();
  }

  calculTotal(): void {
    this.total = 0;
    for (let i = 0; i < this.products.length; i++) {
      this.total += this.products[i].price;
    }
  }

  removeProduct(product: IProduct): void {
    this._productService.removeProductToCart(product);
    //this.calculTotal();
  }

  ngOnInit() {
    this._productService.registerListener(this);
  }

}