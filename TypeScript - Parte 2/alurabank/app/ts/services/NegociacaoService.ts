import { NegociacaoParcial, Negociacao } from '../models/index';

export class NegociacaoService {

    //obtem uma lista de negocições em JSON, atravez da URL setada
    obterNegociacoes(handler: HandlerFunction) : Promise<any> {

        return fetch('http://localhost:8080/dados')
            //handler: é a interface que tem a assinatura de uma função, essa função quando implentada deve receber e retornar uma Response
            .then(res => handler(res)) //verifica se a resposta é ok, antes de continuar
            .then(res => res.json()) // converte a resposnta em JSON
            .then((dados: NegociacaoParcial[]) =>
                dados.map(dado => new Negociacao(new Date(), dado.vezes, dado.montante)) // adiciona a negociação no map
            )
            .catch(err => {
                console.log(err)
                throw new Error('Não foi possivel importar as negociações.')
            });
                
        }
}

//Interface para definir a estrutura de funções
//Qualquer função que recebe um response e retorna um response, não importando sua implementação
export interface HandlerFunction{
    
    //assinatura da função
    (res: Response) : Response

}