import { Component, OnInit, inject } from '@angular/core';
import { TipoUsuarioService } from '../../services/tipo-usuario.service';
import { RouterModule } from '@angular/router';
import { TipoUsuario } from '../../models/tipo-usuario';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-tipos-usuarios',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './panel-tipos-usuarios.component.html',
  styleUrl: './panel-tipos-usuarios.component.css'
})
export class PanelTiposUsuariosComponent implements OnInit{
  private tipoUsuarioService = inject(TipoUsuarioService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  tiposUsuario: TipoUsuario[] = [];
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll(){
    this.tipoUsuarioService.getAll()
    .subscribe(tiposUsuario => {
      this.tiposUsuario = tiposUsuario;
    });
  }
  
  delete(tipoUsuario: TipoUsuario) {
    this.tipoUsuarioService.delete(tipoUsuario.id)
    .subscribe(tipoUsuario => {
      console.log('Tipo de Usuario eliminado', tipoUsuario);
      this.loadAll();
    })
  }
  
}
