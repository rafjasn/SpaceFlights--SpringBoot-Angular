import { Component, OnInit } from '@angular/core';
import { FlightDataService } from '../service/data/flight-data.service';
import { Router } from '@angular/router';


export class Flight {
  constructor(
    public id: number,
public arrivalDate: Date,
public departureDate: Date,
public numberOfSits: number,
public price: number,
public tourists: any[any]
  ){

  }

}


@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {

  flights: Flight[]

  message: string


  constructor(
    private flightService:FlightDataService,
    private router : Router
  ) { }

  ngOnInit() {
    this.refreshFlights();
  }

  refreshFlights(){
    this.flightService.retrieveAllFlights().subscribe(
      response => {
        console.log(response);
        this.flights = response;
      }
    )
  }

  deleteFlight(id) {
    console.log(`delete flight ${id}` )
    this.flightService.deleteFlight(id).subscribe (
      response => {
        console.log(response);
        this.message = `Delete Successful!`;
        this.refreshFlights();
      }
    )
  }

  updateFlight(id) {
    console.log(`update ${id}`)
    this.router.navigate(['flights',id])
  }

  addFlight() {
    this.router.navigate(['flights',-1])
  }
}
