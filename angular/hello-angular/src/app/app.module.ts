import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // for using [(ngModel)]
import { HttpModule } from '@angular/http'; // for HTTP
import { HttpClientModule } from '@angular/common/http'; // for HTTP

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { TestComponent } from './components/test/test.component';
import { NavbarComponent } from './components/navbar/navbar.component';
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

// @NgModule indicates that the class it decorates is an Angular Module
@NgModule({
  declarations: [
    /* The declarations property in the @NgModule decorator 
    holds an array of classes that are related to a view 
    There can be three types of classes listed here - 
    components, directives, and pipes 
    */
    AppComponent,
    HomeComponent,
    TestComponent,
    NavbarComponent
  ],
  imports: [
    /*
    imports array holds modules whose classes are needed
    by classes within this current module 
    */
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
    HttpClientModule
  ],
  /**
    , exports:[]
    the potential exports array would hold classes that need to be
    accessible to classes of other modules. In this module, we are 
    not exporting anything because it is our root module, but we see 
    this in other modules like our app-routing
   */
  providers: [
    /* 
    provider array holds all "Services" which are classes that
    will 'provide' functionality to various places in our application 
    Services are classes decorated with @Injectable 
    */
  ],
  bootstrap: [
    /**
     Bootstrap refers to the root component -- the root view of the app
      */
     AppComponent]
})
export class AppModule { }
