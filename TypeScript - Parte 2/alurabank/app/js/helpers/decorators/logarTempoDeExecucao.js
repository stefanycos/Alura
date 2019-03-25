System.register([], function (exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    function logarTempoDeExecucao(emSegundos = false) {
        return function (target, propertyKey, descriptor) {
            const metodoOriginal = descriptor.value;
            descriptor.value = function (...args) {
                let unidade = 'ms';
                let divisor = 1;
                if (emSegundos) {
                    unidade = 's';
                    divisor = 1000;
                }
                console.log('----------------------------------------------------------');
                console.log(`Parâmetros passados para o método ${propertyKey}: ${JSON.stringify(args)}`);
                const tempoInicial = performance.now();
                const retorno = metodoOriginal.apply(this, args);
                const tempoFinal = performance.now();
                console.log(`O retorno do método ${propertyKey} e ${JSON.stringify(retorno)}`);
                console.log(`O método ${propertyKey} foi executado em: ${(tempoFinal - tempoInicial) / divisor} ${unidade}. `);
                return retorno;
            };
            return descriptor;
        };
    }
    exports_1("logarTempoDeExecucao", logarTempoDeExecucao);
    return {
        setters: [],
        execute: function () {
        }
    };
});
