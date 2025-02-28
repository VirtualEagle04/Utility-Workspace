import { Component, OnInit, inject } from '@angular/core';
import { AuditoriaService } from '../../services/auditoria.service';
import { RouterModule } from '@angular/router';
import { Auditoria } from '../../models/auditoria';

@Component({
  selector: 'app-panel-auditorias',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './panel-auditorias.component.html',
  styleUrl: './panel-auditorias.component.css'
})
export class PanelAuditoriasComponent implements OnInit{
  private auditoriaService = inject(AuditoriaService);
  
  auditorias: Auditoria[] = []
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll() {
    this.auditoriaService.getAll()
      .subscribe(auditorias => {
        this.auditorias = auditorias;
      });
  }
}
