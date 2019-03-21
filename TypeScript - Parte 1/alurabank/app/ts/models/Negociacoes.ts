class Negociacoes{
    //private _negociacoes: Negociacao[]] = []; pode-se declarar também dessa maneira
    private _negociacoes: Array<Negociacao> = [];

    adiciona(negociacao: Negociacao): void{
        this._negociacoes.push(negociacao);
    }

    paraArray(): Negociacao[] {
        //concat: retorna a copia da lista de negociação
        return [].concat(this._negociacoes);
    }
}