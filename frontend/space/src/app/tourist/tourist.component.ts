import { Component, OnInit } from '@angular/core';
import { Tourist } from '../tourist-list/tourist-list.component';
import { TouristDataService } from '../service/data/tourist-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ArrayType } from '@angular/compiler';

@Component({
  selector: 'app-tourist',
  templateUrl: './tourist.component.html',
  styleUrls: ['./tourist.component.css']
})
export class TouristComponent implements OnInit {


  id:number
  tourist: Tourist

  constructor(
    private touristService: TouristDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    
    this.id = this.route.snapshot.params['id'];
    
    this.tourist = new Tourist(this.id,'','','','','',new Date(), [] );
  
    if(this.id!=-1) {
      this.touristService.retrieveTourist( this.id)
          .subscribe (
            data => this.tourist = data
          )
    }
  }

  saveTourist() {
    if(this.id == -1) { //=== ==
      this.touristService.createTourist( this.tourist)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['tourists'])
            }
          )
    } else {
      this.touristService.updateTourist( this.id, this.tourist)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['tourists'])
            }
          )
    }
  }

}
