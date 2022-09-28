import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class APIServicesService {
API_Passenger = "http://localhost:8082/User/listPassenger";
// API_Responsable_Billet = "http://localhost:8082/User/listPassenger";
// API_Responsable_Vol = "http://localhost:8082/User/listPassenger";
// API_Avion = "http://localhost:8082/User/listPassenger";
// API_Billet = "http://localhost:8082/User/listPassenger";
// API_Vol = "http://localhost:8082/User/listPassenger";
  constructor(private http: HttpClient) { 
  }
  GeData(){
    return this.http.get(this.API_Passenger);
  }
}
