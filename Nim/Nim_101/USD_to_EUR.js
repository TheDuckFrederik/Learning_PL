//
const eurToUsd = 1.08;
const usdToEur = 0.92;
//
let mult = 0.00;
let result = 0.00;
let inputCoin = "";
let outputCoin = "";
//
const prompt = require('prompt-sync')(); // Use 'prompt-sync' module in Node.js
//
function getConversionChoice() {
    while (true) {
        const choice = parseInt(prompt("Welcome\n1. EUR to USD\n2. USD to EUR\n--->"));
        //
        if (choice === 1) {
            inputCoin = "EUR";
            outputCoin = "USD";
            mult = eurToUsd;
            break;
        //
        } else if (choice === 2) {
            inputCoin = "USD";
            outputCoin = "EUR";
            mult = usdToEur;
            break;
        //
        } else {
            console.log("Syntax ERR\nPlease try again\n");
        }
    }
}
//
getConversionChoice();
//
// Get the amount from the user
const amount = parseFloat(prompt(`\nInsert amount in ${inputCoin}\n--->`));
//
result = amount * mult;
//
console.log(`\n---> ${result} ${outputCoin}`);
//
