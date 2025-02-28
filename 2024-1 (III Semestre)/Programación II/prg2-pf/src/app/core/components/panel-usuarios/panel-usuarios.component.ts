import { Component, OnInit, inject } from '@angular/core';
import { UsuarioService } from '../../services/usuario.service';
import { RouterModule } from '@angular/router';
import { Usuario } from '../../models/usuario';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-usuarios',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './panel-usuarios.component.html',
  styleUrl: './panel-usuarios.component.css'
})
export class PanelUsuariosComponent implements OnInit{
  private usuarioService = inject(UsuarioService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  usuarios: Usuario[] = []
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll() {
    this.usuarioService.getAll()
      .subscribe(usuarios => {
        this.usuarios = usuarios;
      });
  }
  
  delete(usuario: Usuario) {
    this.usuarioService.delete(usuario.id)
    .subscribe(usuario => {
      console.log('Usuario eliminado', usuario);
      this.loadAll();
    })
  }
}
