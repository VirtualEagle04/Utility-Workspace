import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit{

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private authService = inject(AuthService);
  
  form?: FormGroup;
  usuario?: Usuario;
  
  ngOnInit(): void {
    this.form = this.fb.group({
      id: [''],
      login: ['', Validators.required],
      clave: ['', Validators.required],
      nombres: ['', Validators.required],
      apellidos: ['', Validators.required],
      idTipoUsuario: ['3', Validators.required],
      estado: ['A', Validators.required]
    });
  }
  
  signupReq(){
    const usuarioForm = this.form!.value;
    this.authService.signup(usuarioForm)
      .subscribe(() => {
        this.router.navigate(['/']);
      });
  }
  
}
