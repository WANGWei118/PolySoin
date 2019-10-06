import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-medicine-view-list',
  templateUrl: './medicine-view-list.component.html',
  styleUrls: ['./medicine-view-list.component.css']
})
export class MedicineViewListComponent implements OnInit {
  listOfMedicine = ['1', '2', '3', '4', '5', '6', '7', '8'];
  detailView = false;

  constructor() {
  }

  ngOnInit() {
  }

  getDetail(m) {
    console.log(m);
    this.detailView = true;
  }
}
