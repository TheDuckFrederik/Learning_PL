#
import strutils;
#
var eur_to_usd = 1.08;
var usd_to_eur = 0.92;
#
var mult = 0.00;
var result = 0.00;
#
var Input_coin: string = "";
var Output_coin: string = "";
#
while true:
    echo ("Welcome\n1. EUR to USD\n2. USD to EUR");
    var choiceStr = readLine(stdin);
    var choice = choiceStr.parseInt();
    #
    if choice == 1:
        Input_coin = "EUR";
        Output_coin = "USD";
        mult = eur_to_usd;
        break;
    #
    elif choice == 2:
        Input_coin = "USD";
        Output_coin = "EUR";
        mult = usd_to_eur;
        break;
    #
    else:
        echo "Syntax ERR\nPlease try again\n";
#
echo "\nInsert amount in ", Input_coin, ":";
var amountStr = readLine(stdin);
var amountInt = amountStr.parseInt();
var amount = amountInt.float;
#
result = amount * mult;
echo ("\n", result, " ", Output_coin);
#
