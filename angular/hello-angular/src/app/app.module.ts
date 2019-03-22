import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
/*
Angular provides its own system of organization of
code and functionality. This is accomplished by
containers called modules.

A module is a cohesive block of code with a related 
set of capabilities which have a specific application
domain or workflow.

All Angular applications have at least one module, the
root module, typically defined in the file app.module.ts
This module ties together all of your components,
services, other modules, and imported modules.
It defines where to begin the bootstrapping process
of the application (root component, called AppComponent)

BOOTSTRAPPING
- an essential process in Angular where the application
is loaded
- the bootstrap process loads main.ts - the entry point
of the application
- this process also starts the dependency injection
system in Angular

DEPENDENCY INJECTION
- a concept that predates Angular. DI is a "flavor of"
Inversion of Control(IoC) that is used to simplify
dependency management in software by reducing the
amount of information that the component needs to know
about its dependencies

*/
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
