import csv
import os

script_dir = os.path.dirname(os.path.abspath(__file__))
csv_path = os.path.join(script_dir, "Popular_Baby_Names.csv")
with open(csv_path, 'r') as f:
    reader = csv.reader(f.readlines())
    names_list = list(reader)
names = []
counts = []
for entry in names_list:
    names.append(entry[3])
for count in names_list:
    counts.append(count[4])

names = []
counts = []
for name in names:
    name = name[0] + name[1:].lower()
    names.append(name)
for count in counts:
    #weight = round((float(weight) * 1000),4)
    counts.append(count)
counted_names = list(zip(names,counts))

print(counted_names)