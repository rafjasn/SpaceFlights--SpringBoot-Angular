import { API_URL } from './../../app.constants';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tourist} from '../../tourist-list/tourist-list.component';

@Injectable({
  providedIn: 'root'
})
export class TouristDataService {

  constructor(
    private http:HttpClient
  ) { }

  retrieveAllTourists() {
    return this.http.get<Tourist[]>(`${API_URL}/tourists`);
    //console.log("Execute Hello World Bean Service")
  }

  deleteTourist( id){
    return this.http.delete(`${API_URL}/tourists/${id}`);
  }

  retrieveTourist(id){
    return this.http.get<Tourist>(`${API_URL}/tourists/${id}`);
  }

  updateTourist( id, tourist){
    return this.http.put(
          `${API_URL}/tourists/${id}`
                , tourist);
  }

  createTourist( tourist){
    return this.http.post(
              `${API_URL}/tourists`
                , tourist);
  }

}
