
class Trait:
    def __init__(self,phenotype,genotype):
        self.phenotype = phenotype
        self.genotype = genotype

    def __str__(self):
        return f"{self.phenotype} ({self.genotype})"

    # getter equivalents
    def get_genotype(self):
        return self.genotype
    
    def get_phenotype(self):
        return self.phenotype
    
    # return genotype value from phenotype/genotype dict
    def set_genotype(trait_dict,phenotype):
        return trait_dict[phenotype]
    
    def set_phenotype():
        pass
