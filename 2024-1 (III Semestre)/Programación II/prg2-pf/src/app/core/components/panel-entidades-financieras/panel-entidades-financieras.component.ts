import { Component, OnInit, inject } from '@angular/core';
import { EntidadFinancieraService } from '../../services/entidad-financiera.service';
import { RouterModule } from '@angular/router';
import { EntidadFinanciera } from '../../models/entidad-financiera';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-entidades-financieras',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './panel-entidades-financieras.component.html',
  styleUrl: './panel-entidades-financieras.component.css'
})
export class PanelEntidadesFinancierasComponent implements OnInit{
  private entidadFinancieraService = inject(EntidadFinancieraService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  entidadesFinancieras: EntidadFinanciera[] = [];
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll(){
    this.entidadFinancieraService.getAll()
    .subscribe(entidadesFinancieras => {
      this.entidadesFinancieras = entidadesFinancieras;
    });
  }
  
  delete(entidadFinanciera: EntidadFinanciera) {
    this.entidadFinancieraService.delete(entidadFinanciera.id)
    .subscribe(entidadFinanciera => {
      console.log('Entidad Financiera eliminada', entidadFinanciera);
      this.loadAll();
    })
  }
}
