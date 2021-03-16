import math
# Fix Python 2.x.
try: input = raw_input
except NameError: pass

def enter_subtotal():
    temp = input("Subtotal       [] $")
    if temp.replace(".","",1).isdigit():
        return float(temp)
    else:
        return enter_subtotal()

def enter_tax(subtotal):
    default = '15'
    temp = input("Tax          ["+default+"%] ")
    temp = temp.replace('%','')
    if temp.replace(".","",1).isdigit():
        return float(temp)
    elif temp=='':
        return float(default)
    else:
        return enter_tax(subtotal)

def enter_tip_percent():
    default = '15'
    temp = input("Tip Percent ["+default+"%] ")
    temp = temp.replace('%','')
    if temp.replace(".","",1).isdigit():
        return float(temp)
    elif temp=='':
        return float(default)
    else:
        return enter_tip()

def choose_tip_on_tax():
    temp = input("Tip on tax?  [no] ").lower()
    if temp=='':
        return False
    elif temp=='no' or temp=='n':
        return False
    elif temp=='yes' or temp=='y':
        return True
    else:
        return choose_tip_on_tax()

def print_fancy(str_in):
    width = 40
    bracket = '----'
    bracket_len = bracket.__len__()
    bracket_end = width-bracket_len
    str_len = str_in.__len__()
    if width<str_len:
        return False
    start_char = (math.floor((width/2)) - math.floor((str_len/2))) - 1
    if start_char<bracket_len:
        return False
    str_out = bracket
    c=bracket_len-1
    while True:
        c+=1
        if c==start_char:
            str_out+=str_in
            c+=str_len
        elif c==bracket_end:
            str_out+=bracket
            break
        else:
            str_out+=' '
    print(str_out)

def dec2(inp):
    try:
        return "%.2f" % inp
    except:
        return ''

print("Tip Calculator\n")

subtotal = enter_subtotal()
tax_percent = enter_tax(subtotal)
tip_percent = enter_tip_percent()
tax = subtotal*(tax_percent/100)
if choose_tip_on_tax():
    tip = (subtotal+tax)*(tip_percent/100)
else:
    tip = subtotal*(tip_percent/100)
total = subtotal+tip+tax

print("")
print_fancy("RECEIPT")
print_fancy("")
print_fancy("MEAL - $"+dec2(subtotal))
print_fancy("TAX - $"+dec2(tax))
print_fancy("TIP - $"+dec2(tip))
print_fancy("TOTAL - $"+dec2(total))
print_fancy("")
print_fancy("THANK YOU FOR YOUR BUSINESS!")
