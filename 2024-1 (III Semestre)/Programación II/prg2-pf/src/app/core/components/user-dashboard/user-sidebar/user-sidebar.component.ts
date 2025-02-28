import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, Router, RouterModule} from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faCartShopping } from '@fortawesome/free-solid-svg-icons';
import { faCreditCard } from '@fortawesome/free-regular-svg-icons';
import { faUser } from '@fortawesome/free-regular-svg-icons';

import { UsuarioService } from '../../../services/usuario.service';
import { Usuario } from '../../../models/usuario';

@Component({
  selector: 'app-user-sidebar',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './user-sidebar.component.html',
  styleUrl: './user-sidebar.component.css'
})
export class UserSidebarComponent implements OnInit{

  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private usuarioService = inject(UsuarioService);
  
  faCartShopping = faCartShopping;
  faCreditCard = faCreditCard;
  faUser = faUser;
  
  usuario?: Usuario;
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    if(id){
      this.usuarioService.getUsuarioById(parseInt(id))
      .subscribe(usuario => {
        this.usuario = usuario;
      })
    }
    
  }
  
  browse(){
    this.router.navigate([`${this.usuario?.id}/user/browse`]);
    
  }
  
  transactions(){
    this.router.navigate([`${this.usuario?.id}/user/transactions`]);
  }
  
  editProfile(){
    this.router.navigate([`${this.usuario?.id}/user/profile`]);
  }
}
