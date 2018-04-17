import {IProduct} from './product'
export interface Listener {
  setProductList(products: IProduct[]): void;
}