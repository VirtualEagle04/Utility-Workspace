import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faUser } from '@fortawesome/free-regular-svg-icons';
import { faRightFromBracket } from '@fortawesome/free-solid-svg-icons';

import { UsuarioService } from '../../../services/usuario.service';
import { Usuario } from '../../../models/usuario';

@Component({
  selector: 'app-user-header',
  standalone: true,
  imports: [FontAwesomeModule],
  templateUrl: './user-header.component.html',
  styleUrl: './user-header.component.css'
})
export class UserHeaderComponent implements OnInit{

  private route = inject(ActivatedRoute);
  private usuarioService = inject(UsuarioService);
  
  faUser = faUser;
  faRightFromBracket = faRightFromBracket;
  usuario?: Usuario;
  userName: string = ''
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    if(id){
      this.usuarioService.getUsuarioById(parseInt(id))
    .subscribe(usuario => {
      this.usuario = usuario;
      this.userName = this.usuario.login;
    })
    }
    
  }
  
}
