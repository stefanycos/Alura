export function domInject(selector: string){

    return function(target: any, key: string){
        
        let elemento: JQuery;

        const getter = function(){
            if(!elemento){
                console.log(`buscando ${selector} para injetar em ${key}`);
                elemento = $(selector);
            }
            return elemento;
        }

        //cria o getter, onde o get vei receber o getter criado logo acima
        Object.defineProperty(target, key, {
            get: getter
        });
    }
}