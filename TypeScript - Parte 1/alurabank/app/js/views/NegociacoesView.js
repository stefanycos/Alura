class NegociacoesView extends View {
    update(model) {
        this._elemento.innerHTML = this.template(model);
    }
    template(model) {
        return `
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>DATA</th>
                    <th>QUANTIDADE</th>
                    <th>VALOR</th>
                    <th>VOLUME</th>
                </tr>
            </thead>

            <tbody>
                ${model.paraArray().map(negociacao => `
                            <tr>
                                <td>${negociacao.data.getDate()}/${negociacao.data.getMonth() + 1}/${negociacao.data.getFullYear()}</td>
                                <td>${negociacao.quantidade}</td>
                                <td>${negociacao.valor}</td>
                                <td>${negociacao.volume}</td>
                            </tr>
                        `).join('')}
                <tr>
                    <t>
                </tr>
            </tbody>

            <tfoot>
            </tfoot>
        </table>     
        `;
    }
}
