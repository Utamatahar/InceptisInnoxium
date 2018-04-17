import {Injectable, Component} from '@angular/core';

import {IProduct} from './product';
import {Listener} from './listener';

@Injectable()
export class ProductService {

  cartProduct: IProduct[] = [];
  listener: Listener[] = [];

  addProductToCart(product: IProduct): void {
    let random = Math.floor(Math.random() * 1000);
    let productCopie: IProduct = {
      "productId": random,
      "productName": product.productName,
      "price": product.price,
      "imageUrl": product.imageUrl
    };
    this.cartProduct.push(productCopie);
    this.notifyListener();
  }

  removeProductToCart(product: IProduct): void {
    let tempProducts: IProduct[] = [];
    for (let i = 0; i < this.cartProduct.length; i++) {
      if (product.productId !== this.cartProduct[i].productId) {
        tempProducts.push(this.cartProduct[i]);
      }
    }
    this.cartProduct = tempProducts;
    this.notifyListener();
  }

  notifyListener(): void {
    for (let i = 0; i < this.listener.length; i++) {
      this.listener[i].setProductList(this.cartProduct);
    }
  }

  registerListener(comp: Listener): void {
    this.listener.push(comp);
  }

  calculTotal(): number {
    let total: number = 0;
    for (let i = 0; i < this.cartProduct.length; i++) {
      total += this.cartProduct[i].price;
    }
    return total;
  }

  getProducts(): IProduct[] {
    return [
      {
        "productId": 1,
        "productName": "Leaf Rake",
        "price": 19.95,
        "imageUrl": "http://openclipart.org/image/300px/svg_to_png/26215/Anonymous_Leaf_Rake.png"
      },
      {
        "productId": 2,
        "productName": "Garden Cart",
        "price": 32.99,
        "imageUrl": "http://openclipart.org/image/300px/svg_to_png/58471/garden_cart.png"
      },
      {
        "productId": 5,
        "productName": "Hammer",
        "price": 8.9,
        "imageUrl": "http://openclipart.org/image/300px/svg_to_png/73/rejon_Hammer.png"
      },
      {
        "productId": 8,
        "productName": "Saw",
        "price": 11.55,
        "imageUrl": "http://openclipart.org/image/300px/svg_to_png/27070/egore911_saw.png"
      },
      {
        "productId": 10,
        "productName": "Video Game Controller",
        "price": 35.95,
        "imageUrl": "http://openclipart.org/image/300px/svg_to_png/120337/xbox-controller_01.png"
      }
    ];
  }

}