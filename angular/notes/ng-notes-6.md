# Directives

Although, we have already touched upon the topic of nG directives (structural and attribute) and how they work. We need to cover them in more depth to fully understand how they work within our nG applications. This note set will cover the following directives and topics:

* ngFor
* ngIf
* ngSwitchCase

## ngIf

There are times when we will want to show or hide parts of our page based upon some condition. The `ngIf` structural directive is nG's built-in solution to this scenario.

To explore this directive more, let's work with an example. In our `AppComponent` we can define a field `courses` that is set to an array with two items:

    import { Component } from '@angular/core';

    @Component({
        selector: 'app-root',
        templateUrl: './app.component.html',
        stylesUrl: ['./app.component.css']
    })
    export class AppComponent {
        courses = [1, 2];
    }

In the component template, if we have any courses in our array we will want to render them to a list. Otherwise, we want to display a message to the user, something like: "There are no courses yet". So our template file will look like:

    <div>
        List of courses
    </div>
    <div>
        No courses yet
    </div>

This is good, but both `div` elements will render to the screen. We need to use the `ngIf` directive in order to show or hide these elements based upon the number of items in our `courses` array:

    <div *ngIf="courses.length > 0">
        List of courses
    </div>
    <div *ngIf="courses.length == 0">
        No courses yet
    </div>

This works! If we go to the browser and inspect our page, we will see that only the first `div` will be displayed. Inspecting the page using Chrome Developer Tools will also reveal that the second `div` is not even a part of the DOM. When you use `ngIf`, if the condition evalutes to a truthy value: then the element is added to the DOM. If the condition evaluates to a falsy value: then the element is removed from the DOM.

Angular 4 brought some improvements to the `ngIf` directive, and helps us to clean up the redundant use of our `ngIf` directive using nG's built-in `<ng-template>` element, template variables, and an `else` statement within our first `div` element's `ngIf` conditional assignment. So, after refactoring our template, it will look like:

    <div *ngIf="courses.length > 0; else noCourses">
        List of courses
    </div>
    <ng-template #noCourses>
        No courses yet
    </ng-template>

Notice that we have replaced our second `div` element with the nG built-in element, `<ng-template>`. Also, we have used a template variable to associate this element with a name that we can reference in other parts of our template. Lastly, we have added a semi-colon followed by an simple `else` statement that directs nG to render the element to which the `#noCourses` template variable is associated with.

There is something else that we can do to make this markup a little cleaner and more understandable. By including another `<ng-template>` that will replace the `div` displayed if the condition evaluated is truthy. We will use a template variable to reference this element, and include it within a `then` clause in our `ngIf` directive. So, now our markup looks like:

    <div *ngIf="courses.length > 0; then #coursesList else #noCourses></div>
    <ng-template #coursesList>
        List of courses
    <ng-template>
    <ng-template #noCourses>
        No courses yet
    <ng-template>


## Hidden Property

An alternative method of optionally displaying elements on the user's screen is to use the `hidden` attribute of all HTML elements. This HTML attribute corresponds to the `hidden` property of DOM objects, which means that we can leverage property binding to optionally display elements on a page:

    <div [hidden]="courses.length == 0">
        No courses yet
    </div>
    <div [hidden]="courses.length > 0">
        List of courses
    </div>

Something interesting to note is that both of these elements are present on the DOM. We can see this by using Chrome's Developer Tools to inspect the markup. This is the key difference between using property binding on the `hidden` DOM property and using the `ngIf` directive, because `ngIf` will remove the element not displayed from the DOM entirely. It is recommended to use the `ngIf` directive if you are working with large element trees, because these elements can take up substantial resources. nG has a change detection mechanism that it uses to keep our views in sync with our component, and if elements are still on the DOM then nG will apply changes to them - even though they are not visible. However, if the portion of the page is costly to build and it will be optionally shown by toggling by the user, like using a button, then using `ngIf` will decrease the performance of the page.


## ngSwitchCase

The `ngSwitchCase` is very similar to the concept of a `switch` in other programming languages, like Java or C#. Image that we want to build a page to display properties in a map or in a list. For this example, we won't worry about actually displaying data in these formats, but instead on the act of toggling between the cases. Our template file will look like:

    <ul class="nav nav-pills">
        <li class="active"><a href="">Map View</a></li>
        <li><a href="">List View</a></li>
    </ul>
    <div>
        <div>Map View Content</div>
        <div>List View Content</div>
    </div>

Before we make use of the `ngSwitchCase` directive, we just a field within our component that will store a value which we will use to determine which view should be displayed. So our component will look like:

    import { Component } from '@angular/core';

    @Component({
        selector: 'app-root',
        templateUrl: './app.component.ts',
        styleUrls: ['./app.component.css']
    })
    export class AppComponent {
        viewMode = "map";
    }

With this field in place, we can leverage the `ngSwitchCase` directive in order to toggle between our views. To do this, we first need to include a property binding expression in the parent `div` element that binds to our `viewMode` component field. The property will will bind this field to is the built in nG property `ngSwitch`, and each of our views will include the `ngSwitchCase` directive set to a specific value of `viewMode`. Additionally, we will include a third `div` that will only display as a default, in case the value of `viewMode` does not match any of our switch cases.

    <ul class="nav nav-pills">
        <li class="active"><a href="">Map View</a></li>
        <li><a href="">List View</a></li>
    </ul>
    <div [ngSwitch]="viewMode">
        <div *ngSwitchCase="'map'">Map View Content</div>
        <div *ngSwitchCase="'list'">List View Content</div>
        <div *ngSwitchDefault>Otherwise</div>
    </div>
    
From here, we need to do some event binding on our two `a` elements to dynamically update the value of `viewMode`. We also should use class binding on the `li` elements to optionally apply the `active` class based upon the value of `viewMode`. So the finished version of our template looks like:

    <ul class="nav nav-pills">
        <li [class.active]="viewMode == 'map'"><a (click)="viewMode = 'map'">Map View</a></li>
        <li [class.active]="viewMode == 'list'"><a (click)="viewmode = 'list'">List View</a></li>
    </ul>
    <div [ngSwitch]="viewMode">
        <div *ngSwitchCase="'map'">Map View Content</div>
        <div *ngSwitchCase="'list'">List View Content</div>
        <div *ngSwitchDefault>Otherwise</div>
    </div>

Going to our browser, we can see that we can easily toggle between views by clicking the buttons we created. Also, if we go into our component and set the `viewMode` field to something other than "map" or "list", we will see that the third, default, `div` element is displayed back in the browser.


## ngFor

This directive is used to render a list of elements. We have seen a few examples of this directive already, but let's explore it in more detail. In addition to the usage we have already seen, there are also *exported values* from the `ngFor` directive. These exported values give us the ability to do a lot of things such as declare local variables, define a displayed element as a header, or even do something for alternating elements. Below we have show the declaration of local variables on the template using `ngFor`:

    <ul>
        <li *ngFor="let course of courses; index as i">
            {{ i }} - {{ course.name }}
        </li>
    </ul>

You can find all of the exported values of the `ngFor` directive by exploring the nG documentation regarding `ngFor`. Reference: [Angular Docs](http://angular.io/api/common/NgForOf). In the documentation, we can see that there is are the exported values of `even` and `odd`, which are both boolean values. We can use these values to apply alternating styling to elements that are displayed. The example below is much simpler, we are simply just displaying a `span` element only if the index of the current element within the `ngFor` is even:

    <ul>
        <li *ngFor="let course of courses; even as isEven">
            {{ course.name }} <span *ngIf="isEven">(EVEN)</span>
        </li>
    </ul>


## Why the Leading Asterisk for Some Structural Directives?

You may have noticed that for most of our structural directives, we include a leading asterisk (*) before the name of the directive. Using `ngIf` as an example, this asterisk is necessary because it tells nG to rewrite the current markup, and place in an `<ng-template>` element to contain the area of the page that will be displayed. After this `<ng-template>` element is created, nG uses property binding to bind the `ngIf` property of the `<ng-template>` DOM object to the conditional. Likewise, this property binding is also done on the `<ng-template>` which will be used in case the conditional is falsy.
