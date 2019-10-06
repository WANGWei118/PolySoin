import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineViewListComponent } from './medicine-view-list.component';

describe('MedicineViewListComponent', () => {
  let component: MedicineViewListComponent;
  let fixture: ComponentFixture<MedicineViewListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicineViewListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineViewListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
