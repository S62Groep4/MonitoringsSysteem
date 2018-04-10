import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './login/login.component';
import {AdminComponent} from './admin/admin.component';
import {AuthGuard} from './guards/auth-guard.service';
import {AdminAuthGuard} from './guards/admin-auth-guard.service';

import {HomeComponent} from './home/home.component';
import {UserComponent} from './ImageAlbum/imagealbum.component';
import {OrdersComponent} from './admin/orders/orders.component';
import {CustomersComponent} from './admin/customers/customers.component';
import {ShootsComponent} from './admin/shoots/shoots.component';
import {CreateUserComponent} from './admin/customers/create-user/create-user.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard, AdminAuthGuard],
    children: [
      {
        path: 'bestellingen',
        component: OrdersComponent
      },
      {
        path: 'klanten',
        component: CustomersComponent
      },
      {
        path: 'shoots',
        component: ShootsComponent
      },
      {
        path: 'create',
        component: CreateUserComponent
      }
    ]
  },
  {
    path: 'user',
    component: UserComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '**',
    redirectTo: '/home'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
