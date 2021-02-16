import random

def shuffle_words(input_list):
    output_list = []
    while input_list:
        output_list.append(input_list.pop(random.randint(0, len(input_list)-1)))

    return output_list

if __name__ == '__main__':
    input_list = ["Alderaan", "Bespin", "Corellia", "Coruscant", "Dagobah",
                "Endor", "Geonosis", "Hoth", "Jakku", "Kashyyyk",
                "Mandalore", "Ryloth", "Scarif", "Tatooine", "Utapau", "Yavin"]
    print(shuffle_words(input_list))
