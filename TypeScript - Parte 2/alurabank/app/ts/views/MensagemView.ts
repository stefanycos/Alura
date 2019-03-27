import { View } from './View';

export class MensagemView extends View<string> {

    template(model: string, tipo_mensagem = 'info'): string {
        return `<p class="alert alert-${tipo_mensagem}">${model}</p>`;
    }

}