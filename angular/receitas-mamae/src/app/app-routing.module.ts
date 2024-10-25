import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ListarReceitasComponent } from './components/listar-receitas/listar-receitas.component';
import { ReceitasService } from './service/receitas.service';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'listar', component: ListarReceitasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
