import {AfterViewInit, Component, HostListener, OnInit, ViewChild} from '@angular/core';
import {BarecodeScannerLivestreamComponent, BarecodeScannerLivestreamOverlayComponent} from "ngx-barcode-scanner";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit, AfterViewInit {

  visible = false;
  loading = false;
  innerWidth: any;
  listOfMedicine = ['1', '2', '3', '4', '5', '6', '7', '8'];
  menuChoosed = 'Today';
  isScanner = false;
  data = [
    {
      title: 'Today',
      image: '../../assets/today.png'
    },
    {
      title: 'All',
      image: '../../assets/quanbudingdan.png'
    },
    {
      title: 'History',
      image: '../../assets/history.png'
    },
    {
      title: 'Notification',
      image: '../../assets/notification.png'
    }
  ];
  options = [
    {
      option: 'Scanner',
      id: 1
    },
    {
      option: 'Enregistrer manuelle',
      id: 2,
    }
  ];

  @ViewChild(BarecodeScannerLivestreamComponent, {static: true})
  barecodeScanner: BarecodeScannerLivestreamComponent;

  @ViewChild(BarecodeScannerLivestreamOverlayComponent, {static: true})
  barecodeScannerOverlay: BarecodeScannerLivestreamOverlayComponent;

  barcodeValue = {
    medicine: 'Pepto Bismol',
    information: '5 SYMPTOM Digestive Relief: Upset stomach, heartburn, indigestion, nausea, diarrhea'
  };

  constructor() {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
  }

  open(): void {
    this.visible = true;
  }

  close(): void {
    this.visible = false;
  }

  openItem(title) {
    console.log(title);
    this.menuChoosed = title;
    this.close();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
    console.log(this.innerWidth);
  }

  onValueChanges(result) {
    this.barcodeValue = {
      medicine: 'Pepto Bismol',
      information: '5 SYMPTOM Digestive Relief: Upset stomach, heartburn, indigestion, nausea, diarrhea'
    };
    console.log(this.barcodeValue);
  }

  ngAfterViewInit(): void {
  }

  openMenu(id: number) {
    this.isScanner = id === 1;
    if (this.isScanner) {
      this.barecodeScannerOverlay.show();
    }
  }
}
