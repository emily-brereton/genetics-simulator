# Choice 1 in main menu -> create person
# print menu
# get variables
# make person
# save person

from random import choice
from people.person import Person, random_fname, random_lname
from traits.trait_factory import randomize_all_traits, select_all_traits

males = []
females = []

def create_person(males,females):
    print( """
        Let's create your person.
            
        Biologically speaking, is your person male or female? Please enter "M" for male, "F" for female, or "R" to randomize
        """)
    
    # sex
    sex = get_sex()
    print(f"Great! Your person is {sex}")

    # first name
    print(f"""
            Please enter your new person's name, or type "r" to randomize
            """)
    first_name = get_first_name(sex)
    print(f"Your person's name is {first_name}")

    # last name
    print(f"""
            Please enter your new person's last name, or type "r" to randomize
            """)
    last_name = get_last_name()

    print(f"Great! Your person's name is {first_name} {last_name}.")

    # traits
    print(f"Next, we're going to give {first_name} their traits. Would you like to randomize their traits, or select their traits manually?")
    print("""
        1. Randomize
        2. Select Manually
        """)
    Hair, Eye = get_traits()
    print(f"{first_name} has {Hair} hair and {Eye} eyes.")

    person = Person(first_name,last_name,sex,Hair,Eye,"no mom","no dad")
    save_person(person, males, females)

    print(person)


def get_sex():
    entry = input("Biological sex: ").lower()
    match entry:
        case "f":
            sex = "female"
        case "m":
            sex = "male"
        case "r":
            sex = choice(("male","female"))
    return sex

def get_first_name(sex):
    name = input("First name: ").lower()
    if name == "r":
        name = random_fname(sex)
    return name[0].upper() + name[1:]

def get_last_name():
    name = input("Last name: ").lower()
    if name == "r":
        name = random_lname()
    return name[0].upper() + name[1:]

def get_traits():
    while True:
        entry = int(input("Enter a command: "))
        if entry == 1:
            Hair, Eye = randomize_all_traits()
            break
        elif entry == 2:
            Hair, Eye = select_all_traits()
            break
        else: print("Invalid option. Please try again") #make better function. Raise...
    return Hair, Eye

def save_person(person, males, females): # save to list
    print(f"Do you want to save {person.first_name} to your population? y/n")
    c = input("Enter a command: ")
    if c.lower() == "y":
        if person.sex == "male":
            males.append(person)
        else:
            females.append(person)
        print(f"{person.first_name} saved to population")
    else:
        print("Person not saved to population")


                