import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private authService = inject(AuthService);
  
  form?: FormGroup;
  usuario?: Usuario;
  
  badCredentials: boolean = false;
  
  ngOnInit(): void {
    this.form = this.fb.group({
      id: [''],
      login: ['', Validators.required],
      clave: ['', Validators.required],
      nombres: ['', Validators.required],
      apellidos: ['', Validators.required],
      idTipoUsuario: ['0', Validators.required],
      estado: ['A', Validators.required]
    });
  }
  
  loginReq() {
    const usuarioForm = this.form!.value;
    this.authService.login(usuarioForm)
      .subscribe((usuario) => {
        this.usuario = usuario;
        console.log(this.usuario.id);
        
        if(this.usuario.id === 1){
          this.badCredentials = false;
          
          //Admin Dashboard
          this.router.navigate(['admin']);
        }else {
          this.badCredentials = false;
          
          //User Dashboard
          this.router.navigate([`${this.usuario.id}/user`]);
        }
      },
      error => {
        this.badCredentials = true;
      }
    );
    
  }
  
}