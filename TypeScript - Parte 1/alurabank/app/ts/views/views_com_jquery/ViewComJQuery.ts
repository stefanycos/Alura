abstract class ViewComJQuery<T> { 
    /*
    * Copia da classe View, porem utilizando uma lib do jQuery
    * Dessa forma podemos blindar os problemas de compatibilidade entre os navegadores.
    */
    protected _elemento: JQuery;

    constructor(seletor: string){
        this._elemento = $(seletor);
    }
    
    update(model: T): void{
        this._elemento.html(this.template(model));
    }

    abstract template(model: T): string;

}