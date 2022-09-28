import { Component, OnInit } from '@angular/core';
import { APIServicesService } from '../services/apiservices.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  List:any=[];
  constructor(private dataG :APIServicesService) { }

  ngOnInit(): void {
    this.Get();
  }


  Get(){
    this.dataG.GeData()
    .subscribe((result) => {
      this.List = result;
    })
  }

}
