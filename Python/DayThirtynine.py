def read_player_hands():
    player_hands = []
    lines = open('input').readlines()
    for line in lines:
        tokens = line.split(": ")
        name = tokens[0]
        cards = map(lambda s : s.split(" ")[0], tokens[1].split(", "))
        player_hands.append((name, cards))
    return player_hands
 
def eval_hand(hand):
    card_values = {
        'Two'   : 2,
        'Three' : 3,
        'Four'  : 4,
        'Five'  : 5,
        'Six'   : 6,
        'Seven' : 7,
        'Eight' : 8,
        'Nine'  : 9,
        'Ten'   : 10,
        'Jack'  : 10,
        'Queen' : 10,
        'King'  : 10 }
    val = 0
    aces = 0
    for card in hand:
        if card == 'Ace':
            aces += 1
        else:
            val += card_values[card]
    if aces > 0:
        aces -= 1
        val += aces
        if aces > 0:
            if val + 11 <= 21:
                val += 11
            else:
                val += 1
 
    if val <= 21 and len(hand) >= 5:
        return 22
    elif val > 21:
        return 0
    else:
        return val
 
def get_winner(hand_values):
    winning_val = max(map(lambda v : v[2], hand_values))
    if winning_val == 0:
        print("Everyone busts.")
    else:
        winners = [hand_val for hand_val in hand_values if hand_val[2] == winning_val]
        if len(winners) == 1:
            if winning_val == 22:
                print("%s wins with the 5 card trick." % winners[0][0])
            else:
                print("%s wins." % winners[0][0])
        else:
            print("Draw between %s." % " and ".join(map(lambda v : v[0], winners)))
 
def play():
    hand_values = []
    for hand in read_player_hands():
        hand_values.append((hand[0], hand[1], eval_hand(hand[1])))
    get_winner(hand_values)
 
play()
