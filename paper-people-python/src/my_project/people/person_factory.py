from random import choice
from traits.trait_factory import randomize_all_traits
from people.person import random_fname,random_lname,Person

def randomize_everything():
    sex = choice(("male","female"))
    Hair, Eyes = randomize_all_traits()
    return Person(random_fname(sex),(random_lname()),sex,Hair,Eyes,"user","user")