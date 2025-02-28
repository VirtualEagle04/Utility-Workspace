import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent implements OnInit{

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private usuarioService = inject(UsuarioService);
  
  form?: FormGroup;
  usuario?: Usuario;

  ngOnInit(): void {
    const id = this.route.snapshot.parent?.paramMap.get('id');

    if(id){
     
      this.usuarioService.getUsuarioById(parseInt(id))
      .subscribe(usuario => {
        this.usuario = usuario;
        this.form = this.fb.group({
          id: [usuario.id],
          login: [usuario.login, Validators.required],
          clave: ['', Validators.required],
          nombres: [usuario.nombres, Validators.required],
          apellidos: [usuario.apellidos, Validators.required],
          idTipoUsuario: [usuario.idTipoUsuario, Validators.required],
          estado: [usuario.estado, Validators.required]
        });
      })
    }
  }
  
  back(){
    this.router.navigate([`${this.usuario?.id}/user`])
  }
  
  save() {
    if(this.form?.invalid){
      this.form.markAllAsTouched();
      return;
    }
    
    const usuarioForm = this.form!.value;
    this.usuarioService.save(usuarioForm)
      .subscribe(() => {
        this.router.navigate(['admin/usuarios']);
      });
    
  }
  
}
