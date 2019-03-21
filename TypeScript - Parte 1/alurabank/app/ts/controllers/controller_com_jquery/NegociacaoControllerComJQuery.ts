class NegociacaoControllerComJQuery{

    /*
    * Copia da classe NEgociacaoController, porem utilizando uma lib do jQuery
    * Dessa forma podemos blindar os problemas de compatibilidade entre os navegadores.
    */

    private _inputData: JQuery;
    private _inputQuantidade: JQuery;
    private _inputValor: JQuery;
    private _negociacoes: Negociacoes = new Negociacoes();
    private _negociacoesView: NegociacoesView = new NegociacoesView('#negociacoesView');
    private _mensagemView: MensagemView = new MensagemView('#mensagemView');

    constructor(){
        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
    }

    adiciona(event: Event){
        event.preventDefault();
        const negociacao = new Negociacao(
            //substitui os "-" da data por "," que é o formato aceito pelo contrutor do Date.
            new Date(this._inputData.value.replace(/-/g, ',')), 
            parseInt(this._inputQuantidade.value), 
            parseFloat(this._inputValor.value)
        );
        
        this._negociacoes.adiciona(negociacao);
        this._negociacoesView.update(this._negociacoes);
        this._mensagemView.update('Negociação adicionada com sucesso!');
    }
}