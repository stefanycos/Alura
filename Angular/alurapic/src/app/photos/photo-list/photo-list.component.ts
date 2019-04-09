import { Component, OnInit } from '@angular/core';
import { PhotoService } from '../photo/photo.service';
import { Photo } from '../photo/photo';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'ap-photo-list',
  templateUrl: './photo-list.component.html',
  styleUrls: ['./photo-list.component.css']
})
export class PhotoListComponent implements OnInit {
  title = 'Alura Pic';
  
  photos: Photo[] = [];
  
  constructor(
    private photoService: PhotoService, 
    private activatedRoute: ActivatedRoute) {}
  
  ngOnInit(): void {

    // Segmentos de rota: pega o userName que vem da rota passada no browser
    const userName = this.activatedRoute.snapshot.params.userName

    this.photoService
      .listFromUser(userName)
      .subscribe(photos => this.photos = photos);
  
  }

}
