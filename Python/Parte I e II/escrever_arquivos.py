frutas = ["Uva", "melancia", "Banana", "abacaxi", "manga", "morango"]

def escrever_arquivo():
    arquivo = open("palavras.txt", "w")
    
    for fruta in frutas:
        adiciona_palavra(arquivo, fruta)

    arquivo.close()    


def adiciona_palavra(arquivo, palavra):
    arquivo.write(palavra + "\n")


if __name__ == "__main__":
    escrever_arquivo()