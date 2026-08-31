from random import choice
from .trait import Trait
from .trait_data import HAIR_COLOR, EYE_COLOR

def _randomize_phenotype(trait_dict: dict[int,list]) -> int:
    return choice(list(trait_dict.keys()))

def _randomize_trait(trait_dict):
    phenotype = _randomize_phenotype(trait_dict)
    genotype = choice(trait_dict[phenotype])
    return Trait(phenotype,genotype)

def randomize_all_traits():
    Hair_Color = _randomize_trait(HAIR_COLOR)
    Eye_Color = _randomize_trait(EYE_COLOR)
    return Hair_Color, Eye_Color

def _select_trait(trait_dict:dict,trait_name:str):
    print(f"{trait_name}:")
    for key in trait_dict.keys():
        print(key)
    while True:
        c = input("Enter a value: ")
        if c in trait_dict.keys():
            phenotype = c
            genotype = choice(trait_dict[phenotype])
            break
        else:
            print("Invalid selection. Please try again")
    return Trait(phenotype, genotype)

def select_all_traits():
    Hair_Color = _select_trait(HAIR_COLOR,"Hair Color")
    Eye_Color = _select_trait(EYE_COLOR,"Eye Color")
    return Hair_Color, Eye_Color