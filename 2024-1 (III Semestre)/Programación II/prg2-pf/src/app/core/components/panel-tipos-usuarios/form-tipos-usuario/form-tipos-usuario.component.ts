import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { TipoUsuarioService } from '../../../services/tipo-usuario.service';
import { TipoUsuario } from '../../../models/tipo-usuario';

@Component({
  selector: 'app-form-tipos-usuario',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-tipos-usuario.component.html',
  styleUrl: './form-tipos-usuario.component.css'
})
export class FormTiposUsuarioComponent implements OnInit{
  
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private tipoUsuarioService = inject(TipoUsuarioService)
  
  form?: FormGroup;
  tipoUsuario?: TipoUsuario;
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
    if(id){
      this.tipoUsuarioService.getTipoUsuarioById(parseInt(id))
      .subscribe(tipoUsuario => {
        this.tipoUsuario = tipoUsuario;
        this.form = this.fb.group({
          id: [tipoUsuario.id],
          descripcion: [tipoUsuario.descripcion, Validators.required],
          estado: [tipoUsuario.estado, Validators.required]
        });
      })
    } //ID no existe, porque se llama para la creacion
    else {
      this.form = this.fb.group({
        id: [''],
        descripcion: [''],
        estado: ['A', Validators.required]
      });
    }
  }
  
  save() {
    if(this.form?.invalid){
      this.form.markAllAsTouched();
      return;
    }
    
    const tipoUsuarioForm = this.form!.value;
    this.tipoUsuarioService.save(tipoUsuarioForm)
      .subscribe(() => {
        this.router.navigate(['admin/tiposUsuario']);
      });
    
  }

}
