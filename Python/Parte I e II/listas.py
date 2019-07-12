# Testes com listas, tuplas, sets e dicionario
######################################################

valores = [ 0, 0, 0, 1, 2, 3, 4]
frutas = ['Banana', 'Morango', 'Maçã', 'Uva']

# teste 01 - conta quantas vezes um elemento aparece em um lista
print("O número 0 aparece {} vezes na lista!".format(valores.count(0)))

# teste 02 - retorna o indice de um elemento
print("A palavra Uva está no presente no index:", frutas.index('Uva'))

# teste 03 - maior valor da lista
print("Maior número da lista:", max(valores))

# teste 04 - menor valor da lista
print("Menor número da lista:", min(valores))

# teste 05 - tuplas são parecidas com a lista porém são imutaveis
dias = ("D", "S", "T", "Q", "Q", "S", "S" )
print("Tupla dias da semana:", dias)

# teste 06 - Sets: Um set é uma coleção não ordenada de elementos. Cada elemento é único, isso significa que não existem elementos duplicados dentro do set.
colecao = {11122233344, 22233344455, 33344455566}
colecao.add(44455566677)
print("Itens da coleção:", colecao)

# teste 07 - Dicionarios
instrutores = {'Nico' : 39, 'Flavio': 37, 'Marcos' : 30}
print("Idade do intrudor Flavio:", instrutores['Flavio'])

# teste 08 - List Comprehension
frutas = ["maçã", "banana", "laranja", "melancia"]
lista = [fruta.upper() for fruta in frutas]
print("Frutas em maiusculo:", lista)

# teste 09 - List Comprehension, cria lista com numeros quadrados
inteiros = [1,3,4,5,7,8]
quadrados = [n*n for n in inteiros]
print("Números ao quadrado:", quadrados)

# teste 10 - List Comprehension, inicializa a lista com números pares
pares = [x for x in inteiros if x % 2 == 0]
print("Números pares", pares)