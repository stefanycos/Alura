import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Injectable } from "@angular/core";
import { Photo } from "./photo";

const API = 'http://localhost:3000';
const SEPARATOR = '/';

// @Injectable: decorator que indica que PhotoService é injetavel. 
// providedIn: indica o escopo, ou seja, indica se a mesma instancia do PhotoService será usada por toda aplicação, ou não.
// root: indica que será de escopo raiz, isto é, todos os componentes da aplicação usarão a mesma instancia do serviço
@Injectable({providedIn: 'root'})
export class PhotoService {

    constructor(private http: HttpClient) {}

    listFromUser(userName: string): Observable<Photo[]>{
        return this.http
            .get<Photo[]>(API + SEPARATOR + userName + SEPARATOR + 'photos');
    }

}