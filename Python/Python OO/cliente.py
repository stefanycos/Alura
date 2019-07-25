class Cliente:

    def __init__(self, nome):
        self.__nome = nome

    @property # pode ser invocado diretamente, até mesmo sem parentes
    def nome(self):
        print("Chamando @property nome()")
        return self.__nome.title()

    @nome.setter # pode ser invocado diretamente: cliente.nome = 'bla bla'
    def nome(self, nome):
        print("Chamando setter nome()")
        self.__nome = nome
