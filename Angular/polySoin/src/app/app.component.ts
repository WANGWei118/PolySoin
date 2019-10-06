import {Component, HostListener, OnInit} from '@angular/core';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'polySoin';
  isCollapsed = false;
  menuItemSelected = 'Aujourd\'hui';
  innerWidth: any;

  menu = ['today', 'all', 'history'];
  tabs = [1, 2, 3];

  ngOnInit(): void {
    this.innerWidth = window.innerWidth;
  }

  getMenuItem(menuItem: string) {
    console.log(menuItem);
    this.menuItemSelected = menuItem;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
    console.log(this.innerWidth);
  }
}
