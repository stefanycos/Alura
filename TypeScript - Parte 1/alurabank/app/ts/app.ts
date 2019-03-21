const controller = new  NegociacaoController();

document
    .querySelector('form')
    .addEventListener('submit', controller.adiciona.bind(controller));

/*
* Dessa forma também funciona, desde que tenha configurado a lib do jQuery
* $('.form').submit(controller.adiciona.bind(controller));
*/