import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, Router} from '@angular/router';

@Injectable()
export class ProductGuardService implements CanActivate {
  canActivate(route: ActivatedRouteSnapshot): boolean {
    let id = +route.url[1].path;
    if (isNaN(id) || id < 1) {
      console.error('Invalid product Id :' + id);
      this.router.navigate(['/products']);
      return false;
    }

    return true;

  }

  constructor(private router: Router) {}

}
