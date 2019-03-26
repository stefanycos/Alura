import { NegociacaoParcial, Negociacao } from '../models/index';

export class NegociacaoService {

    obterNegociacoes(handler: HandlerFunction) : Promise<any> {

        return fetch('http://localhost:8080/dados')
            .then(res => handler(res))
            .then(res => res.json())
            .then((dados: NegociacaoParcial[]) => 
                dados.map(dado => new Negociacao(new Date(), dado.vezes, dado.montante))
            )
            .catch(err => console.log(err));
        }
}

//Interface para definir a estrutura de funções
//Qualquer função que recebe um response e retorna um response, não importando sua implementação
export interface HandlerFunction{
    
    //assinatura da função
    (res: Response) : Response

}