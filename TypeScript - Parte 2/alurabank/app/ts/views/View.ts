import { logarTempoDeExecucao } from '../helpers/decorators/index';
export abstract class View<T> {

    protected _elemento: JQuery;
    private _escapar: boolean;

    constructor(seletor: string, escapar: boolean = false) {
        this._elemento = $(seletor);
        this._escapar = escapar;
    }

    //@logarTempoDeExecucao(true)
    update(model: T, tipo_mensagem = 'info') {
        let template = this.template(model, tipo_mensagem);
        if(this._escapar){
            template = template.replace(/<script>[\s\S]*?<\/script>/, '');
        }
        
        this._elemento.html(template);
    }

    abstract template(model: T, tipo_mensagem: string): string;

}

