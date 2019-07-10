# teste 01
print("Tentativa {} de {}".format(1, 10))

# teste 02
print("Tentativa {1} de {0}".format(1, 10))

# teste 03 - 7 caracteres no total, sendo 2 depois do ponto
print("R$ {:7.2f}".format(1234.59))

# teste 04 - 7 caracteres no total, sendo 2 depois do ponto e adicionando 0 se estiver vazio
print("R$ {:07.2f}".format(4.59))

# teste 05 - 4 caracteres no total, sendo 2 depois do ponto e adicionando 0 se estiver vazio
print("R$ {:04d}".format(4))

# teste 06 - data
print("Data: {:02d}/{:02d}/{:02d}".format(9,4,19))

# teste 07
nome = 'Matheus'
print(f'Meu nome é {nome}')

# teste 08
nome = 'Matheus'
print(f'Meu nome é {nome.lower()}')