import { NgModule } from '@angular/core';
import { ServerModule } from '@angular/platform-server';
import { AppModule } from './app.module';
import { AppComponent } from './app.component';
import { ModalModule } from 'ngx-bootstrap/modal'; 
import { BrowserModule } from '@angular/platform-browser';



@NgModule({
  imports: [
    AppModule,
    ServerModule,
    BrowserModule,
    ModalModule.forRoot() // Add ModalModule to imports
  ],
  bootstrap: [AppComponent],
})
export class AppServerModule {}
