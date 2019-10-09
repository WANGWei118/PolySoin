import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgZorroAntdModule, NZ_I18N, fr_FR } from 'ng-zorro-antd';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { registerLocaleData } from '@angular/common';
import fr from '@angular/common/locales/fr';
import { MedicineViewListComponent } from './medicine-view-list/medicine-view-list.component';
import { MedicineDetailViewComponent } from './medicine-detail-view/medicine-detail-view.component';
import { MedicineCardViewComponent } from './medicine-card-view/medicine-card-view.component';
import { HomePageComponent } from './home-page/home-page.component';
import {BarecodeScannerLivestreamModule, BarecodeScannerLivestreamOverlayModule} from "ngx-barcode-scanner";
import { AddMedicineComponent } from './add-medicine/add-medicine.component';

registerLocaleData(fr);

@NgModule({
  declarations: [
    AppComponent,
    MedicineViewListComponent,
    MedicineDetailViewComponent,
    MedicineCardViewComponent,
    HomePageComponent,
    AddMedicineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgZorroAntdModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    BarecodeScannerLivestreamModule,
    BarecodeScannerLivestreamOverlayModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: NZ_I18N, useValue: fr_FR }],
  bootstrap: [AppComponent]
})
export class AppModule { }
