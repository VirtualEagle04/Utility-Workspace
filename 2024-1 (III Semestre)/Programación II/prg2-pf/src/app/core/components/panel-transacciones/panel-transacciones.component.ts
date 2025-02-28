import { Component, OnInit, inject } from '@angular/core';
import { TransaccionService } from '../../services/transaccion.service';
import { Transaccion } from '../../models/transaccion';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-panel-transacciones',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './panel-transacciones.component.html',
  styleUrl: './panel-transacciones.component.css'
})
export class PanelTransaccionesComponent implements OnInit{
  private transaccionService = inject(TransaccionService);

  transacciones: Transaccion[] = [];

  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll(){
    this.transaccionService.getAll()
      .subscribe((transacciones: any) => {
        this.transacciones = transacciones;
      });
  }
}
