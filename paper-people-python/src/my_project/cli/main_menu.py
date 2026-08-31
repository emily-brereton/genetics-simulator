from cli.create_person_menu import create_person
from cli.population import view_population,make_population

def run_main_menu():
    males = []
    females = []
    while True:
        print(("""
            ------------------------------------------------------------------
                                Paper People Project
            ------------------------------------------------------------------
                    A simulation using simple Mendelian inheritance
            ------------------------------------------------------------------
                """))
        print("""
            ------------------------------------------------------------------
                Menu:
                    1.  Create a New Person
                    2.  Have a New Baby
                    3.  Randomize a Population
                    4.  View Your Population
                    5.  View Allele Frequencies
                    6.  Exit
            ------------------------------------------------------------------
                """)  
        selection = input("Enter a command: ")
        match selection:
            case "1":
                create_person(males,females)
            case "2":
                print("Have a baby")
            case "3":
                make_population(males,females)
            case "4":
                view_population(males,females)
            case "5":
                print("Do statistics")
            case "6":
                print("end program")
                break
            case _:
                print("Invalid entry. Please try again.")
