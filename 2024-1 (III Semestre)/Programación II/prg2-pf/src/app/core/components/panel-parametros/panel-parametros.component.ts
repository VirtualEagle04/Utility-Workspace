import { Component, OnInit, inject } from '@angular/core';
import { ParametroService } from '../../services/parametro.service';
import { RouterModule } from '@angular/router';
import { Parametro } from '../../models/parametro';
import { DatePipe } from '@angular/common';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-parametros',
  standalone: true,
  imports: [RouterModule, DatePipe, FontAwesomeModule],
  templateUrl: './panel-parametros.component.html',
  styleUrl: './panel-parametros.component.css'
})
export class PanelParametrosComponent implements OnInit{
  private parametroService = inject(ParametroService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  parametros: Parametro[] = []
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll() {
    this.parametroService.getAll()
      .subscribe(parametros => {
        this.parametros = parametros;
      });
  }
  
  delete(parametro: Parametro) {
    this.parametroService.delete(parametro.id)
    .subscribe(parametro => {
      console.log('Parámetro eliminado', parametro);
      this.loadAll();
    })
  }
  
}
