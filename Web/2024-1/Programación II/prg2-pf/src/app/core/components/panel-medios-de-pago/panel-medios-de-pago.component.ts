import { Component, OnInit, inject } from '@angular/core';
import { MediosDePagoService } from '../../services/medios-de-pago.service';
import { RouterModule } from '@angular/router';
import { MediosDePago } from '../../models/medios-de-pago';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-medios-de-pago',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './panel-medios-de-pago.component.html',
  styleUrl: './panel-medios-de-pago.component.css'
})
export class PanelMediosDePagoComponent implements OnInit{

  private mediosDePagoService = inject(MediosDePagoService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  mediosDePago: MediosDePago[] = []
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll() {
    this.mediosDePagoService.getAll()
      .subscribe(mediosDePago => {
        this.mediosDePago = mediosDePago;
      });
  }
  
  delete(mediosDePago: MediosDePago) {
    this.mediosDePagoService.delete(mediosDePago.id)
    .subscribe(mediosDePago => {
      console.log('Medio de Pago eliminado', mediosDePago);
      this.loadAll();
    })
  }
}
