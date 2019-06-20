import { RouteGuardService } from './service/route-guard.service';
import { LogoutComponent } from './logout/logout.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { TouristListComponent } from './tourist-list/tourist-list.component';
import { TouristComponent } from './tourist/tourist.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { FlightComponent } from './flight/flight.component';

// welcome 
const routes: Routes = [
  { path: '', component: LoginComponent, canActivate:[RouteGuardService]  },//canActivate, RouteGuardService
  { path: 'login', component: LoginComponent },
  { path: 'welcome', component: WelcomeComponent,  canActivate:[RouteGuardService]},
  { path: 'logout', component: LogoutComponent },
  { path: 'tourists', component: TouristListComponent, canActivate:[RouteGuardService]},
  { path: 'tourists/:id', component: TouristComponent, canActivate:[RouteGuardService]},
  { path: 'flights', component: FlightListComponent, canActivate:[RouteGuardService]},
  { path: 'flights/:id', component: FlightComponent, canActivate:[RouteGuardService]},

  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
