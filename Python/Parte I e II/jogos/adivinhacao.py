import random

def jogar():
    print("********************************")
    print("Bem vindo ao jogo de Adivinhação")
    print("********************************")

    numero_secreto = round(random.randrange(1, 100))
    total_tentativas = 0
    pontos = 1000

    print("Selecione o nivel de dificuldade")
    print("(1) Fácil | (2) Médio | (3) Difícil")

    nivel = int(input("Difina o nível: "))

    if nivel == 1:
        total_tentativas = 20
    elif nivel == 2:
        total_tentativas = 10
    else:
        total_tentativas = 5

    # é possivel adicionar o step no for, assim o for pula de step by step - range(start, stop[, step])
    for rodada in range (1, total_tentativas + 1):
        chute_str = input("Digite um número entre 1 e 100: ")
        chute_int = int(chute_str)

        if (chute_int < 1 or chute_int > 100):
            print("Número tem deve estar entre 1 e 100!")
            continue

        acertou  = numero_secreto == chute_int
        eh_maior = chute_int > numero_secreto

        print("Tentativa {} de {}".format(rodada, total_tentativas))
        if acertou:
            print("Você acertou e fez {} pontos =)".format(pontos))
            break
        else: 
            if eh_maior:
                print("Você errou, seu chute foi maior que o número secreto =(")
            else:
                print("Você errou, seu chute foi menor que o número secreto =(")
            
            # abs - converte o número para absoluto quando for negativo
            pontos_perdidos = abs(numero_secreto - chute_int)
            pontos = pontos - pontos_perdidos

        rodada = rodada + 1

    print("********** Fim de Jogo *********")

# quando o arquivo .py é executado direto na linha de comando ele preenche a variavel __name__ com o valor __main__
# quando o arquivo é importado em outro módulo a variavel __name__ vem vazia, então não entra no if
# desta forma o arquivo .py pode ser importado ou rodado direto na linha de comando que irá funcionar
if __name__ == "__main__":
    jogar()