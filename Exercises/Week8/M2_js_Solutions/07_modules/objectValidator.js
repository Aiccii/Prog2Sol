import {bmiCalculator, vatCalculator} from "./advancedCalculator.js";
import {reverse, shuffle} from "./stringFunctions.js";

const checkPerson = function(person){
    if(person.name && person.weight && person.height){
        const bmi = bmiCalculator(person.weight, person.height);
        console.log(`${person.name} has a BMI of ${bmi}`);
        let scrambled = shuffle(person.name);
        console.log(`Their scrambled name is ${scrambled}`);
        return scrambled;
    }else{
        console.log("Person has no name, height or weight!");
    }
}

const checkPalindromes = function (texts){
    for (let text in texts){
        if(texts[text] === reverse(texts[text])){
            console.log(`${text}: \"${texts[text]}\" is a palindrome.`)
        } else{
            console.log(`${text}: \"${texts[text]}\" is not a palindrome.`)
        }
    }
}

const calculateTotalPrice = function(product){
    if(product.price && product.VAT){
        product.totalPrice = vatCalculator(product.price, product.VAT);
    } else{
        console.log("Invalid product!");
    }
}

export {checkPerson, checkPalindromes, calculateTotalPrice};