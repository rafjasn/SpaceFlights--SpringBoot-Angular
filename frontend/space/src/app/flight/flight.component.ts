import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FlightDataService } from '../service/data/flight-data.service';
import { Flight } from '../flight-list/flight-list.component';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  
  id:number
  flight: Flight

  constructor(
    private flightService: FlightDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    
    this.id = this.route.snapshot.params['id'];
    
    this.flight = new Flight(this.id,new Date() ,new Date(),0, 0, [] );
  
    if(this.id!=-1) {
      this.flightService.retrieveFlight( this.id)
          .subscribe (
            data => this.flight = data
          )
    }
  }

  saveFlight() {
    if(this.id == -1) { //=== ==
      this.flightService.createFlight( this.flight)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['flights'])
            }
          )
    } else {
      this.flightService.updateFlight( this.id, this.flight)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['flights'])
            }
          )
    }
  }

}
