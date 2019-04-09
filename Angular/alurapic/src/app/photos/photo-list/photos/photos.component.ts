import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';

import { Photo } from '../../photo/photo';

@Component({
  selector: 'ap-photos',
  templateUrl: './photos.component.html',
  styleUrls: ['./photos.component.css']
})
export class PhotosComponent implements OnChanges {
  
  @Input() photos: Photo[] = [];
  rows: any[] = [];
  
  constructor() { }
  
  ngOnChanges(changes: SimpleChanges): void {
    
    //através da instância de SimpleChanges conseguimos saber sobre as mudanças ocorridas nas inbound properties do component.
    if(changes.photos)
      this.rows = this.groupColumns(this.photos);
    
  }

 
groupColumns(photos: Photo[]) {
    const newRows = [];
    // faz uma iteração de 3 em 3 para mostrar as imagens de 3 em na tela, ou seja, cada linha terá 3 colunas
    // o slice pegará esse array de photos de 3 em 3 (), pois ele recebe como parametro a posição inicial e a final
    // inicial = 0 e final 0+3, o slice pegará as fotos de 0 a 2 e assim por diante, na proxima iteração pegara de 3 a 6 (3,4,5)
    for(let index = 0; index < photos.length; index+=3) {
        newRows.push(photos.slice(index, index + 3));
    }
    return newRows;
}

}
