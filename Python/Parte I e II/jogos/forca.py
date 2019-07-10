def jogar():
    print("********************************")
    print("** Bem vindo ao jogo de Forca **")
    print("********************************")

    print("********** Fim de Jogo *********")

# quando o arquivo .py é executado direto na linha de comando ele preenche a variavel __name__ com o valor __main__
# quando o arquivo é importado em outro módulo a variavel __name__ vem com outro valor, então não entra no if
# desta forma o arquivo .py pode ser importado ou rodado direto na linha de comando que irá funcionar
if __name__ == "__main__":
    jogar()