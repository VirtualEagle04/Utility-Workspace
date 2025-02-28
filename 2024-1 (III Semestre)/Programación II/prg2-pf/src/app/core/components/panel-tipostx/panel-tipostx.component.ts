import { Component, OnInit, inject } from '@angular/core';
import { TipotxService } from '../../services/tipotx.service';
import { RouterModule } from '@angular/router';
import { Tipotx } from '../../models/tipotx';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-tipostx',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './panel-tipostx.component.html',
  styleUrl: './panel-tipostx.component.css'
})
export class PanelTipostxComponent implements OnInit{
  private tipotxService = inject(TipotxService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  tipostx: Tipotx[] = [];
  
  ngOnInit(): void {
      this.loadAll();
  }
  
  loadAll() {
    this.tipotxService.getAll()
      .subscribe(tipostx => {
        this.tipostx = tipostx;
      });
  }
  
  delete(tipostx: Tipotx) {
    this.tipotxService.delete(tipostx.id)
    .subscribe(tipostx => {
      console.log('Tipo de Transacción eliminado', tipostx);
      this.loadAll();
    })
  }
}
