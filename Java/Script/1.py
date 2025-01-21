#
n = 0
#
def calculator(x):
  for i in x:
    i -= 1
    n += 1
    num = input("Input the nuumber {}".format(n))
    while True:
        if n != 1:
            operation = input("Input the kind of operation.\n1. +\n2. -\n3. *\n4. /\n")
            if operation == 1:
                total += num
            elif operation == 2:
                total -= num
            elif operation == 3:
                total *= num
            elif operation == 4:
                total /= num
            else:
                print("Operation not valid. Please try again.")
        elif n == 1:
            total += num
        if i == 0:
            print("The total is {}".format(total))
        break
#
while True:
  nums = input("Enter the amount of numbers that you will want to calculate with:\n--->")
  #
  def calculator(nums):
    print