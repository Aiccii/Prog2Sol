import * as objectVal from './objectValidator.js'
import {feetToMeter} from "./advancedCalculator.js";
import {sort} from "./stringFunctions.js";
import {subtract} from "./basicCalculator.js";

//Height is in feet, weight in kilograms
let person = {
    name: 'John Shepard',
    height: 6,
    weight: 75
}

person.height = feetToMeter(person.height);
person.name = objectVal.checkPerson(person);
console.log(`${sort(person.name)}`);

const words = {
    movie: 'tenet',
    status: 'deified',
    name: 'sebastiaan',
    sentence: 'able was I ere I saw elba',
    drink: 'coca cola',
    timeOfDay: 'noon'
}

objectVal.checkPalindromes(words);

let product = {
    name: "chocolate chip cookies",
    price: 8,
    VAT: 21,
    discount: 2
}

objectVal.calculateTotalPrice(product);
product.totalPrice = subtract(product.totalPrice, product.discount);
console.log(`Final price: ${product.totalPrice}`);