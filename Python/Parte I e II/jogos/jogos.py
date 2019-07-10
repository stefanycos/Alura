import forca
import adivinhacao

def escolha_jogo():
    print("********************************")
    print("******** Escolha o Jogo ********")
    print("********************************")

    print("(1) Forca | (2) Adivinhação")

    jogo = int(input("Digite o número do jogo escolhido: "))

    if jogo == 1:
        print("Iniciando jogo da forca...")
        forca.jogar()
    elif jogo == 2:
        print("Iniciando jogo de adivinhação...")
        adivinhacao.jogar()

# quando o arquivo .py é executado direto na linha de comando ele preenche a variavel __name__ com o valor __main__
# quando o arquivo é importado em outro módulo a variavel __name__ vem com outro valor, então não entra no if
# desta forma o arquivo .py pode ser importado ou rodado direto na linha de comando que irá funcionar
if __name__ == "__main__":
    escolha_jogo()