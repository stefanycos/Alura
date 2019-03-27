import { Imprimivel } from "./Imprimivel";
import { Igualavel } from "./Igualavel";


//Interface que extends outras interfaces, apenas para faculitar na hora de codar
//Agora se usarmos essa interface para implementar uma classe, essa classe automaticamente recebe os metodos de Imprimivel e igualavel
export interface MeuObjeto<T> extends Imprimivel, Igualavel<T>{

}