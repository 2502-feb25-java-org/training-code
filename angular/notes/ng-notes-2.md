# Angular Fundamentals

This set of notes is going to cover the fundamentals of Angular (nG) to set us on the right path to build great nG applications. Before continuing you should at least have a basic understanding of Node.js, TypeScript (TS), Webpack, and the general structure of an nG application. The goal of this section is to cover the following topics:

* Components
* Templates
* Directives
* Services


# Building Blocks of Angular Applications

Now that we have some basic familiarity with nG, lets look at the building blocks of all nG applications. At the heart of every nG application are one or more *components*. Real-world applications have dozens, sometimes hundreds of components.

A component encapsulates the data, the HTML markup, and the logic of the view. Imagine we are building a website using nG. Our entire page could be viewed as one large component (`AppComponent`) that is broken into smaller sub-components (`NavComponent`, `SidebarComponent`, etc.). A key feature of our components is that they are reusable, providing a consistency in not only the look and feel of our application, but also its functionality. Additionally, the idea of using components means that we can work on smaller, more maintainable pieces of our application.

All nG applications have a root component, known as the `AppComponent`. All other components branch outward from this root component in a tree-like structure. In nG, there is also a concept of *modules* which are groupings of related components. All nG applications have at least one module, known as the `AppModule`. As our applications become larger, it may become appropriate to break our application up into smaller, more maintainable modules.


## Components

There are basically three steps that you need to follow in order to use a component:

1) Create the component

2) Register the component in a module

3) Add an element in the HTML markup

We have two options to choose from when it comes to creating nG components. We can either create them ourselves manually, or we can use the nG CLI to generate them automatically. The first way we will look at this is by creating them manually.

Inside of the `src` folder of our demo application (ng-demo), we will add a new file and give it the name: `courses.component.ts`. This is the naming convention you will use when creating components in nG. If your component's name has more than one word, then separate them using a hyphen.

#### See *courses.component.ts* file in ng-demo for more notes on manually creating a component.


The other, and more convenient method of creating components in nG is by utilizing the nG CLI. The following command can be used to generate a component:

    ng generate component course

The shorthand syntax for the above command is as follows:

    ng g c course

Notice that the nG CLI automatically creates a folder containing the HTML, CSS, and TS files related to our new component. It also, automatically registers the newly created component with the module we are creating it within (in this case, the AppModule). Exploring the generated files reveals that the nG CLI has automatically generated boilerplate code for us.

## Templates

We already know that a component encapsulates the data, the logic, and the HTML markup for a view. Templates are the aspects of our component that represent its presentation logic. We can use data-binding techniques such as interpolation, class binding, style binding, and two-way binding to wire the internal logic of our component to the view.

#### See *courses.component.ts* file in ng-demo for more notes on templates


## Directives

Directives are used to manipulate the Document Object Model (DOM). We can use directives to create elements, remove elements, change the class, styling, or attributes of an element. Additionally, we can create our own custom directives that have user-defined functionalities.

Directives _extend_ the behavior of HTML, enabling you to create custom HTML elements, attributes, and classes with functionality specific to an application. nG provides many built-in directives which provide the capability to interact with form elements, bind data in a component to the view, and interact with browser events.

### Understanding Directives

Directives are a combination of nG template marup and supporting TS code. nG directive markups can be HTML attributes, element names, or CSS classes. The TS directive code defines the template data and behavior of the HTML elements.

The nG compiler traverses the template DOM and compiles all of the directives. Then it links the directives by combining a directive with a scope to produce a new live view. The live view contains the DOM elements and functionality defined in the directive.

### Using Built-in Directives

Much of the nG functionality that is needs to be implemented in HTML elements is provided through built-in directives. These directives provide a wide variety of support for nG applications. nG directives fall into one of the three categories:

* *Component:* A directive with a template
* *Structural* A directive that manipulates the DOM
* *Attribute* A directive that manipulates the appearance or behavior of a DOM element

#### Structural Directives

We have already discussed nG components, so we will move to *structural directives*. nG includes many built-in directives that dynamically update, create, and remove elements from the DOM. These directives create the layout, look, and feel of an application. Below is a list of the built-in structural directives:

* `ngFor`
    * used to create a copy of a template for each item within an iterable object

* `ngIf`
    * used to display a template if a certain condition is met, otherwise remove it

* `ngSwitch`
    * displays a template based upon the value passed to it, a default template (`ngSwitchDefault`) is provided if the value given does not match any specified cases (`ngSwitchCase`)

##### See *structural-directive-demo* folder in ng-demo for more notes on structural directives


#### Attribute Directives

nG attribute directives modify how HTML elements look and behave. The are injected straight into the HTML and dynamically modify how the user interacts with an HTML segment. Attribute directives are so named because they loop like normal HTML attributes. Below is a list of the built-in nG attribute directives:

* `ngModel`
    * watches a variable for changes and then updates display values based on those changes

* `ngForm`
    * creates a form group and allows it to track the values and validation within that form group. By using `ngSubmit`, you can pass the form data as an object to the submission event.

* `ngStyle`
    * updates the styles of an HTML element

* `ngClass`
    * updates the class of an HTML element

##### See the *attribute-directive-demo* folder in ng-demo for more notes on attribute directives

##### See *courses.component.ts* file in ng-demo for more notes on directives in general


## Services

In our `CoursesComponent`, we have hard-coded our list of courses into the component's logic. In real-world applications, this list of courses would be something that is retrieved from the server. We could include the logic for calling an HTTP endpoint in our component, but there are some problems with this approach. First, the addition of this logic will tightly couple our component to that HTTP endpoint, this will make unit testing much more difficult. Second, this logic is likely to be reused elsewhere in our application and we would not want to keep writing it over and over each place it is necessary. Lastly, by including the logic to call an HTTP endpoint we would violate the principle that our component should only be responsible for presentation logic.

Our solution, instead, should be to create a *service* with handles this extra functionality. We will use the nG CLI to automatically generate a service that will handle the retrieval of courses. The below command will do this:

    ng generate service courses

The shorthand syntax for this is:

    ng g s courses

Services in nG do not get the `@Component` decorator, like our components do. Instead they can optionally include the `@Injectable` decorator which will allow nG to inject other services into the current service, but only if they are included in its constructor. Services can injected into components and other services as a dependencies. Doing this will allow us to keep our components and the services they use loosely coupled, and this is known as *dependency injection*.

The purpose of a service to provide a concise bit of code that performs a specific task. A service can do something as simple as providing a value definition, or as complex as providing full HTTP communication to a web server.

A service provides a container for reusable functionality that is readily available to nG applications. Services are defined and registered with the dependency injection mechanism in nG. Which allows us to inject our services into modules, components, and even other services.

nG comes with several built-in services that are included in the nG module, using dependency injection. Once included within a module, services can be used throughout an application. Below are the most commonly used built-in services:

* `HttpClient`
    * replaces the deprecated `http` service
    * provides a simple-to-use functionality to send HTTP request to the web server or other services

* `forms`
    * provides a service that allows for dynamic and reactive forms with simple form validation

* `router`
    * provides navigation between views and between sections within views

* `animate`
    * provides animation hooks to link into both CSS and JS-based animations

##### See *courses.service.ts* file in ng-demo for more notes on services