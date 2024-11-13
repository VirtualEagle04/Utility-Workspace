#Ej No.16

c = input('Coma separated IDs: ')

n = input('Dash separated Names: ')

D = dict(zip(c.split(','), n.split('-')))

print(D)