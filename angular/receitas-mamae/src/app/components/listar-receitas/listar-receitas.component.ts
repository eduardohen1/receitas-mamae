import { Component, OnInit } from '@angular/core';
import { ReceitasService } from 'src/app/service/receitas.service';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-listar-receitas',
  templateUrl: './listar-receitas.component.html',
  styleUrls: ['./listar-receitas.component.css']
})
export class ListarReceitasComponent implements OnInit {
  
    lstReceitas: any[] = [];
    receitaSelecionada: any;
  
    constructor(private receitasService: ReceitasService) { }
  
    ngOnInit(): void {
      this.buscarReceitas();
    }

    buscarReceitas() : void {
      this.receitasService.buscarReceitas().subscribe(
        (data) => {
          this.lstReceitas = data;
        }
      );
    }

    abrirModal(receita: any) : void {
      this.receitaSelecionada = receita;
      const modalElement = document.getElementById('receitaModal');
      console.log(modalElement)
      if(modalElement){
        const modal = new bootstrap.Modal(modalElement);
        modal.show();
      }
    }

    imprimirReceita() : void {
      alert(`Imprimindo receita: ${this.receitaSelecionada.titulo}`);
    }

}
