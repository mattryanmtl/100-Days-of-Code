def menu_select(num):
	if(num == 1):
		binary = input("Enter binary number: ")
		decimal = binary_to_decimal(binary)
		return(decimal)
		
	elif(num == 2):
		decimal = input("Enter decimal number: ")
		binary = decimal_to_binary(decimal)
		return(binary)
		

def binary_to_decimal(num):
	b = list(num)
	n = len(list(num))
	decimal = 0
	hold = 0
	i = 0
	exp = n-1
	while (i < n):
		x = int(b[i])
		quot= 2**exp
		hold = x*quot
		i += 1
		exp -= 1
		decimal = decimal + hold
	return(decimal)

def decimal_to_binary(num):
	quot = int(num)
	base = 0
	counter = 0
	binary=[]
	while (quot > 0):
		rem = quot%2
		binary.append(str(rem))
		quot = quot//2
		counter +=1

	binary.reverse()
	return(int(''.join(binary)))

print("Day 22: Binary-Decimal Converter\n")
print("What type do you want to convert? : \n")
print("1- Binary\n")
print("2- Decimal\n")

choice = input("Select: ")
s = menu_select(int(choice))
print("Result : ", s)
