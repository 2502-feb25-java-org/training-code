'use strict';
alert('hu');
// this won't work unless the script is loaded after the "body" node is created. 
//alert(document.body.innerHTML);
//document.body.style.backgroundColor = 'blue';

// there is a "load" event that runs on everything
// when the window is loaded, everything is loaded

// for every event, you can register a event handler with
// a property named "on<event-name>". an event handler is a function.

/*window.onload = function () {
    document.body.style.backgroundColor = 'red';
};*/

// javascript has a special object called the global object aka "window"
// every variable in global scope is actually stored on the window object.

// a more flexible way to do this:
/*window.addEventListener('load', () => {
    let header = document.body.firstElementChild;
    header.textContent = 'DOM changed this';
});*/

// ideally we don't wait all the way until window loads
// that means, all images etc have downloaded

// all we really need is the elements to exist in the DOM and not be null
// DOMContentLoaded event fires sooner

/*var table = document.getElementById("the-table");
var tableAttrs = table.attributes; // Node/Element interface
console.log(tableAttrs)
for (var i = 0; i < tableAttrs.length; i++) {
    // HTMLTableElement interface: border attribute
    if (tableAttrs[i].nodeName.toLowerCase() == "border")
        table.border = "5px";
    table.border = "solid";
}
*/

function storeSearch() {
    var searchBox = document.getElementById("searchbox").value;
    sessionStorage.search = searchBox;
}
function loadOldSearch() {
    var searchBox = document.getElementById("searchbox");
    searchBox.value = sessionStorage.search;
}

//The DOMContentLoaded event will fire as soon as the DOM hierarchy has been fully constructed, the 
//load event will do it when all the images and sub-frames have finished loading.
//http://web.archive.org/web/20150405114023/http://ie.microsoft.com/testdrive/HTML5/DOMContentLoaded/Default.html