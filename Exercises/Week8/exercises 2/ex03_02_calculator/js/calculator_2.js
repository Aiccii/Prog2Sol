"use strict";

let txtVal1;
let txtVal2;
let result;

init();

function init() {
    let header = document.getElementById("header");
    header.innerText = "Calculator (version 2)";

    let btnAdd = document.getElementById("btnAdd");
    btnAdd.addEventListener("click", () => {
        result.innerText = parseInt(txtVal1.value) +
            parseInt(txtVal2.value);
    });
    let btnSubtract = document.getElementById("btnSubtract");
    btnSubtract.addEventListener("click", () => {
        result.innerText = parseInt(txtVal1.value) -
            parseInt(txtVal2.value);
    });

    let btnMultiply = document.getElementById("btnMultiply");
    btnMultiply.addEventListener("click", () => {
        result.innerText = parseInt(txtVal1.value) *
            parseInt(txtVal2.value);
    });

    let btnDivide = document.getElementById("btnDivide");
    btnDivide.addEventListener("click", () => {
        result.innerText = parseInt(txtVal1.value) /
            parseInt(txtVal2.value);
    });

    txtVal1 = document.getElementById("txtVal1");
    txtVal1.focus();

    txtVal2 = document.getElementById("txtVal2");
    result = document.getElementById("result");
}  // init()
