# What is Angular?

A framework for building client applications in HTML, CSS, and JavaScript/TypeScript.

## Why Angular? 
### Why not JavaScript or jQuery?

Sure we can, and that is actually how many web applications are built. However as our applications get more complex, vanilla JS/jQ code becomes harder to maintain.

Angular (nG) provides us with a way to properly structure or code, without having to understand complex JS design patterns (i.e. Revealing Module or Prototype patterns)

Applications built with JS/jQ are also more difficult to test, and nG simplifies this task.

#### Benefits of nG

* Gives our applications a clean structure
* Includes a lot of reusable code
* Makes our applications more testable (both unit and integration testing)


# Architecture of Angular applications

A lot of applications have at least two parts: a front-end and a back-end. The front-end, 
or client, is the part that runs in the web browser and is what user interacts with (UI). We can use HTML, CSS, TS, and nG to build our front-end.

The back-end sits on a web server, or multiple web servers hosted on the cloud. It is responsible for 
storing the data and any kind of processing (business logic). Our front-end talks to the back-end to 
get or persist data through an HTTP service (a collection of endpoints that are accessible via the 
HTTP protocol).

#### Back-end:
* Data + APIs
* Business Logic

#### Front-end:
* HTML templates
* Presentation Logic



# Setting Up the Development Environment (Our first Angular App)

1) Install the latest version of Node.js.
    
* Node.js is a runtime environment for executing JS code outside of the browser. (nG apps require 
    Node.js version 6.9+)
    
* Link: [Node.js](https://nodejs.org/en/)

* Check for success:
    * In your terminal type the following command to see your installed version of Node.js: 
        
        `node --version`

2) With Node.js installed, use Node Package Manager (NPM) to install third-party libraries. In our
case we use it to install the Angular Command Line Interface (CLI), using the following command:

`npm install -g @angular/cli`

* The nG CLI is a command-line tool that is used to create our nG project and its various services, components, etc.

* The `-g` installs our nG CLI globally. Without it, the nG CLI will only be installed in the current folder and will not accessible anywhere else.

* The installation process takes a minute.

* Check for success:

    * In the terminal type the following command to see the installed versions of the nG CLI, Node.js, and your machine's OS:

        `ng --version`

3) To create a new nG project type the following command into the terminal:

`ng new hello-world`

* This generates a lot of files for us and uses NPM to download any third-party libraries that are required.

4) Once the project is created, we can launch it on a Node server using the following command:

`ng serve`

* By default, our live development server is deployed on localhost port 4200.



# Structure of an Angular Application

* e2e 
    * End-to-end tests are automated tests that simulate a real user's interaction with our web page

* node_modules
    * the storage location of all of the third-party libraries our nG application depends upon
    * only used for development

* src
    * the actual source code of our nG application
    * contains the following:

        * app
            * contains a module and a component

        * assets
            * storage location for static assets for the web page (images, audio, etc.)

        * environments
            * contains configuration settings for different environment
            * contains one file for the production environment and one for the development environment

        * favicon.ico
            * icon displayed in the browser tab

        * index.html
            * a simple HTML file that contains our nG application
            * has no references to external stylesheet, since they will be added dynamically later

        * main.ts
            * starting point of the nG application
            * location where we bootstrap the application's main module using the statement:

                    `platformBrowserDynamic().bootstrapModule(AppModule);`

        * polyfills.ts
            * imports some scripts required to run nG, since nG framework uses features of JS that are
            not in the current version of JS.

        * style.css
            * the location where we can add global styles for the application (each component can have
            its own styles, as well)

        * test.ts
            * used to set up a testing environment

    * .angular-cli.json
        * configuration file for the nG CLI

    * .editorconfig
        * used to ensure that all developers working on a project have their editors configured in the
        same manner

    * karma.conf.js
        * another configuration file for a test runner known as Karma, used to testing JS code

    * package.json
        * a standard file that all Node projects have
        * contains a list of dependencies and the versions used (needed for production)
        * contains a list of development dependencies and the versions used (needed for developers only)

    * protractor.conf.js
        + a configuration file used for  the e2e testing framework Protractor
    
    * tsconfig.json
        + a settings file for the TS compiler

    * tslint.json
        + includes settings for tslint, a static analysis tool for TS code (checks TS code for readability,
        maintainability, and functionality)



# What is Webpack?

nG CLI uses a tool known as Webpack, which is a build automation tool. Webpack is responsible for gathering scripts and stylesheets, bundling them, then minifying them for optimization.

Common bundles managed by the nG CLI (These bundles are injected into the index.html):

* polyfills.bundle.js (necessary non-standard JS features)
* main.bundle.js (nG source code)
* styles.bundle.js (stylesheets)
* vendor.bundle.js (third-party dependencies)
* inline.bundle.js (Webpack loader)


# Angular Version History

* AngularJS
    * introduced in 2010, as a JS framework for building client applications
    
* Angular2
    * introduced in September 2016
    * written in TS

* Angular4
    * introduced in March 2017
    * still written in TS
    * new features (not all inclusive):
        * changes to nG Routing
        * support for animations (without writing functions)
        * changes and additions to built-in directives
        * Angular Universal (running nG apps outside of the browser and on a web server)


* Angular5
    * introduced in November 2017
    * still written in TS
    * new features (not all inclusive):
        * BuildOptimizer
        * Additional features for Angular Universal
        * HttpClient (officially replaces the deprecated Http)
        * Compiler improvements
        * CLI v1.5
        * new Router lifecycle events


* Angular6
    * introduced in April 2018
    * still written in TS
    * new features (not all inclusive):
        * Webpack v4
        * support for RxJS 6 library
        * new nG CLI commands (`ng add`, `ng update`, etc.)

## Why no Angular3?

Angular consists of a few different libraries that are distributed as separate packages. Before Angular4 was released, the latest versions of these libraries were:

            @angular/core       v2.3.0
            @angular/compiler   v2.3.0
            @angular/http       v2.3.0
            @angular/router     v3.3.0

Notice that the nG router package's version was out of sync with the other nG packages. In order to get all of the packages back in sync, the nG development team decided to skip an Angular3 release, and go straight to Angular4. Although technically, the version number was officially dropped from the name to help emphasize that there are only two version of Angular: AngularJS and Angular. The latter being all versions of Angular from v2 and beyond.


# Pulsecheck: Assess Knowledge

1. What is Angular?
2. When building client apps with Angular, where is the application data stored and processed?
3. When designing the architecture of our applications, what kind of logic is implemented on the client?
4. How can we create a new Angular project using the Angular CLI?
5. What is Webpack?
6. What is the difference between AngularJS and Angular?
7. Why was there no Angular3?

