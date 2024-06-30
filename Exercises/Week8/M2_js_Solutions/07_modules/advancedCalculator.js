import * as basicCalc from './basicCalculator.js';

const bmiCalculator = (weight, height) => basicCalc.divide(weight,basicCalc.multiply(height,height));
const vatCalculator = (amount, percentage) => basicCalc.multiply(amount,basicCalc.sum(1,basicCalc.divide(percentage,100)));
const feetToMeter = feet => basicCalc.multiply(feet,0.304);

export {bmiCalculator, vatCalculator, feetToMeter};