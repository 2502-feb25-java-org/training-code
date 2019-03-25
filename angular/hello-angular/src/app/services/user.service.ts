import { Injectable } from '@angular/core';


/*
A service is a special class that can contain a value, function or
 collection of behavior and state that is needed by your application.
 Most services are specialized functions that your application needs
 in multiple areas. For example, logging is typically implemented as
 a service because you use it throughout your entire application. Other
 examples, might be a data access service or a service that consumes
 some public API.
Most services are just special classes. You export them like any other
 TypeScript class. The difference appears when you try and create a
 service for use in a class. Most often you only want one instance of
 a service running within your application. This allows for data
 consistency and better performance as you don’t have multiple instances
 of the same functionality being tracked in memory. Typically, you have
 to inject a service into a class for use.
So what is dependency injection? Well, at a high level it is a design
 pattern. The framework that you’re using, in this case Angular, manages
 your class instantiation and provision to other classes for you. You simply
 declare what a class needs as opposed to creating instances yourself.
*/
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }
}
