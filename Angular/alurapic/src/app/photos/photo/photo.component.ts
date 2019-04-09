import { Component, Input } from "@angular/core";

@Component({
    selector: 'ap-photo',
    templateUrl: 'photo.component.html'
})
export class PhotoComponent{
    //@Input (Inbound property) - permite receber valor de sua forma declarativa, ou seja, a description será preenchida com o valor passado na utilização do photo-component
    @Input() description = '';
    @Input() url = '';
}