#
eur_to_usd = 1.08
usd_to_eur = 0.92
#
mult = 0.00
result = 0.00
#
Input_coin = ""
Output_coin = ""
#
while True:
    choice = int(input("Welcome\n1. EUR to USD\n2. USD to EUR\n--->"))
    #
    if choice == 1:
        Input_coin = "EUR"
        Output_coin = "USD"
        mult = eur_to_usd
        break
    #
    elif choice == 2:
        Input_coin = "USD"
        Output_coin = "EUR"
        mult = usd_to_eur
        break
    #
    else:
        print("Syntax ERR\nPlease try again\n")
#
amount = float(input("\nInsert amount in {}\n--->".format(Input_coin)))
#
result = amount * mult
print("\n---> {} {}".format(result, Output_coin))
#
