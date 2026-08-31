# Choice 3 and 4 in main menu -> randomize population, view population
# print males and females
# view by family? generation?

from people.person_factory import randomize_everything



def view_population(males: list, females: list):
    _print_persons(males,"All Males")
    _print_persons(females,"All Females")

def _print_persons(persons: list, title: str):
    print(f"{title}:")
    for i, person in enumerate(persons):
        print(f"{i}. {person}")

def make_population(males,females):
    print("How many randomized people would you like to create? Select a number between 1 and 500. ")
    while True:
        count = input("Number of people: ")
        if count.isdigit() and int(count) > 0 and int(count) < 501:
            for _ in range(int(count)):
                person = randomize_everything()
                if person.sex == "male":
                        males.append(person)
                else:
                        females.append(person)
            break
        else:
            print("Invalid entry. Please enter a numerical value between 1 and 500")
    print(f"{count} individuals added to your population.")
