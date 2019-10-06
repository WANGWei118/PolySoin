import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineDetailViewComponent } from './medicine-detail-view.component';

describe('MedicineDetailViewComponent', () => {
  let component: MedicineDetailViewComponent;
  let fixture: ComponentFixture<MedicineDetailViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicineDetailViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineDetailViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
