import { NgModule } from "@angular/core";
import { Routes, RouterModule } from '@angular/router';

import { PhotoListComponent } from "./photos/photo-list/photo-list.component";
import { PhotoFormComponent } from "./photos/photo-form/photo-form.component";
import { NotFoundComponent } from "./errors/not-found/not-found.component";

const routes: Routes = [ // configura cada rota da aplicação, onde cada rota carregará o componente adequado
    { path: 'user/:userName', component: PhotoListComponent }, //user/:userName --> define que qualquer userName passado, depois de user/, será aceito
    { path: 'p/add', component: PhotoFormComponent },
    { path: '**', component: NotFoundComponent } // ** especifica qualquer outra rota que o usuario for desconhecida pela aplicação.
]

@NgModule({
    imports: [ RouterModule.forRoot(routes) ], // relaciona o array de routes com o módulo de rotas do Angular.
    exports: [ RouterModule ]
})
export class AppRoutingModule {

}