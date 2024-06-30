
let value1 = +document.getElementById('txtVal01').value;

let value2 = +document.getElementById('txtVal02').value;


function sum() {
    let sumV = value1 + value2;
    document.getElementById('result1').innerHTML = sumV

}

document.getElementById('btnAdd1').addEventListener('click', sum)


function sub() {
    document.getElementById('result1').innerHTML = (value1 - value2).toString();
}

document.getElementById('btnSubtract1').addEventListener('click', sub)


function mul() {
    document.getElementById('result1').innerHTML = (value1 * value2);
}
document.getElementById('btnMultiply1').addEventListener('click', mul)


function divide() {
   document.getElementById('result1').innerHTML = (value1 / value2);
}
document.getElementById('btnDivide1').addEventListener('click', divide)





