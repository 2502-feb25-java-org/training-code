"use strict"
console.log("first run");

var add=function(a){
    var total=0;
    return function(b){
        return function(c){
            return a+b+c;
        }
    }
}

var addToNested=add(5);//
var addToInnerMost=addToNested(6);//
//console.log(addToInnerMost(7));
//console.log(add(5)(6)(7));// currying process
var requestURL = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';
var xhr=new XMLHttpRequest();
var data={};//incase u want to send data to server
var header=document.getElementById("h1");
xhr.onreadystatechange=function(){
    if(this.readyState==4&&this.status==200)
    //console.log(this.readyState);
    data=JSON.parse(this.responseText);
    console.log(data);
    header.innerHTML=data.squadName;
}
xhr.open('GET',requestURL,true);//by default async is true
xhr.send();