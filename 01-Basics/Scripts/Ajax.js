'use strict';
// runs first
console.log('1');

document.addEventListener('DOMContentLoaded', () => {
    let jokeHeader = document.getElementById('joke-text');
    let jokeButton = document.getElementById('joke-button');

    // runs third
    console.log('2');

    jokeButton.addEventListener('click', () => {
        debugger;
        // runs fifth
        console.log('3');

        // we'll write a getJoke to make a request to the joke API
        getJoke(text => {
            // this code runs when the request returns successfully
            jokeHeader.innerHTML = text;
        });
    });

    // runs fourth
    console.log('4');
});

// runs second (the handler for DOMContentLoaded has not run yet!)
console.log('5');


// 24153
// 15243
// 12345

function getJoke(onSuccess, onFailure = console.log) {
    debugger;
    // this object is provided by the browser to let us do AJAX
    // AJAX stands for Asynchronous JavaScript and XML
    //   but what it means in practice is, communication over network (usually HTTP) via JavaScript.
    let xhr = new XMLHttpRequest();

    // define what to do as the request-response lifecycle proceeds
    xhr.addEventListener('readystatechange', () => {
        console.log(`readyState: ${xhr.readyState}`);

        // readyState starts at 0 and counts upwards
        if (xhr.readyState === 4) {
            // 4 means, we've received the response
            let responseJSON = xhr.response;
            console.log(responseJSON);

            // HTTP response status 200-299 indicates success.
            if (xhr.status >= 200 && xhr.status < 300) {
                // responseJSON should contain the data I requested.
                console.log('success');

                // JSON.parse to deserialize JSON.
                // JSON.stringify to serialize JSON.

                let responseObj = JSON.parse(responseJSON);
                let text = responseObj.value.joke;
                onSuccess(text);
            } else {
                // some kind of error (e.g. 404 not found)
                // responseJSON should contain details about error
                console.log('failure');
                if (onFailure !== undefined) {
                    onFailure(responseJSON);
                }
            }
        }
    });

    // set up the request to be made
    xhr.open('get', 'http://api.icndb.com/jokes/random/');

    // send the request
    xhr.send();
}

document.addEventListener('DOMContentLoaded', () => {
    let textElement = document.getElementById('json-text');
    let button = document.getElementById('json-button');
    button.addEventListener('click', () => {
        let jsonStr = textElement.value;

        // have to declare before the try block, so it stays in scope afterwards.
        let obj;
        try {
            obj = JSON.parse(jsonStr);
        } catch (error) {
            console.log(error);
            return;
        }
        console.log(obj);
        obj.name = 'Chuck';

        let newJsonStr = JSON.stringify(obj);

        textElement.value = newJsonStr;
    });
});

// Fetch API, modern replacement for XMLHttpRequest object,
// using ES6 promises, not all browsers support.
document.addEventListener('DOMContentLoaded', () => {
    let button = document.getElementById('joke-button-fetch');
    let jokeHeader = document.getElementById('joke-text');

    button.addEventListener('click', () => {
        // certain functions return Promise objects.
        // these represent a result that's not here yet
        //  a promise can be resolved either to a success or a failure

        // you call promise.then(onSuccess) to specify when to do when
        // the promise is successfully fulfilled
        // there's a second argument for failure

        // if your then() function returns a promise itself...
        // we can chain that with further "then()" calls.

        fetch('http://api.icndb.com/jokes/random/')
            // response.json() returns a promise of the whole response
            //    body parsed from JSON.
            // as soon as we get the response headers...
            //   ...chain to that promise.
            .then(response => response.json())
            // when we get _that_ value, process it onto the page.
            .then(data => {
                jokeHeader.innerHTML = data.value.joke;
            })
            // using .catch() at the end of a promise chain will handle
            // any errors along the way.
            .catch(err => {
                console.log(err)
            });
    });
});