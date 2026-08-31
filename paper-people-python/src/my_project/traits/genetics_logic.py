#Genetics Logic

from random import choice

_punnett_table = {
16: ("4",), # AA x AA
12: ("4","3"), # AA x Aa
8: ("3",), # AA x aa
9: ("4","3","3","2"), # Aa x Aa
6: ("3","2"), # Aa x aa
4: ("2",) # aa x aa
}

# random genotype from mom + dad gene
# get random value from punnett square key
def _randomize_value(key, dict):
    return choice(dict[key])

def _split_gene(trait: int) -> list[int]:
    return [int(digit) for digit in str(trait)]

#take a parent gene, split into a list of ints, multiply the two lists together to get a list of crosses(keys for punnett_table)
#randomize a value for each cross, save as baby_gene_list
#concatenate list into string, return gene string as int -> baby genotype
def parent_cross(mom_gene: int, dad_gene: int) -> int:
    cross = [a1 * a2 for a1, a2 in zip((_split_gene(mom_gene)),(_split_gene(dad_gene)))]
    baby_gene_list = [_randomize_value(gene, _punnett_table) for gene in cross]
    return int("".join(baby_gene_list))

#iterate to match genotype w/ list(value), then match list(value) with key(phenotype)
def match_to_phenotype(genotype: int, trait_dict: dict[int,list]) -> str:
    values = trait_dict.values()
    for gene_value in values:
        for gene in gene_value:
            if genotype == gene:
                return next((key for key, value in trait_dict.items() if value == gene_value), None)