import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineCardViewComponent } from './medicine-card-view.component';

describe('MedicineCardViewComponent', () => {
  let component: MedicineCardViewComponent;
  let fixture: ComponentFixture<MedicineCardViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicineCardViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineCardViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
