import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {SystemOverviewComponent} from './system-overview/system-overview.component';

const routes: Routes = [

  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: '**',
    component: SystemOverviewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
