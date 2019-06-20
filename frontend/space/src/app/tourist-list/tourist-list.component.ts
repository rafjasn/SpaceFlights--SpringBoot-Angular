import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TouristDataService } from '../service/data/tourist-data.service';
import { ArrayType } from '@angular/compiler';


export class Tourist {
  constructor(
    public id: number,
public firstName: string,
public lastName: string,
public gender: string,
public country: string,
public remarks: string,
public dateOfBirth: Date,
public flights: number[]

){

  }
}


@Component({
  selector: 'app-tourist-list',
  templateUrl: './tourist-list.component.html',
  styleUrls: ['./tourist-list.component.css']
})
export class TouristListComponent implements OnInit {

  tourists: Tourist[]

  message: string

  constructor(
    private touristService: TouristDataService,
    private router : Router
  ) { }

  ngOnInit() {
    this.refreshTourists();
  }

  refreshTourists(){
    this.touristService.retrieveAllTourists().subscribe(
      response => {
        console.log(response);
        this.tourists = response;
      }
    )
  }

  deleteTourist(id) {
    console.log(`delete tourist ${id}` )
    this.touristService.deleteTourist( id).subscribe (
      response => {
        console.log(response);
        this.message = `Delete of Tourist ${id} Successful!`;
        this.refreshTourists();
      }
    )
  }

  updateTourist(id) {
    console.log(`update ${id}`)
    this.router.navigate(['tourists',id])
  }

  addTourist() {
    this.router.navigate(['tourists',-1])
  }
}