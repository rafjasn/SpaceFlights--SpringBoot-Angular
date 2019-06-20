import { Injectable } from '@angular/core';
import { API_URL } from 'src/app/app.constants';
import { HttpClient } from '@angular/common/http';
import { Flight } from 'src/app/flight-list/flight-list.component';


@Injectable({
  providedIn: 'root'
})
export class FlightDataService {


  constructor(
    private http:HttpClient
  ) { }

  retrieveAllFlights() {
    return this.http.get<Flight[]>(`${API_URL}/flights`);
    //console.log("Execute Hello World Bean Service")
  }

  deleteFlight( id){
    return this.http.delete(`${API_URL}/flights/${id}`);
  }

  retrieveFlight( id){
    return this.http.get<Flight>(`${API_URL}/flights/${id}`);
  }

  updateFlight( id, flight){
    return this.http.put(
          `${API_URL}/flights/${id}`
                , flight);
  }

  createFlight( flight){
    return this.http.post(
              `${API_URL}/flights`
                , flight);
  }

}
