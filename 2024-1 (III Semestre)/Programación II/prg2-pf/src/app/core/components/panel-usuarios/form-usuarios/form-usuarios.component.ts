import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

import { UsuarioService } from '../../../services/usuario.service';
import { Usuario } from '../../../models/usuario';

import { TipoUsuarioService } from '../../../services/tipo-usuario.service';
import { TipoUsuario } from '../../../models/tipo-usuario';

import { AuditoriaService } from '../../../services/auditoria.service';
import { Auditoria } from '../../../models/auditoria';

@Component({
  selector: 'app-form-usuarios',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-usuarios.component.html',
  styleUrl: './form-usuarios.component.css'
})
export class FormUsuariosComponent implements OnInit{

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private usuarioService = inject(UsuarioService);
  
  private tipoUsuarioService = inject(TipoUsuarioService);
  
  private auditoriaService = inject(AuditoriaService);
  formAuditoria?: FormGroup;
  auditoria?: Auditoria;
  
  tiposUsuario: TipoUsuario[] = [];
  
  form?: FormGroup;
  usuario?: Usuario;
  
  ngOnInit(): void {
    this.loadTiposUsuario();
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
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
        
        this.formAuditoria = this.fb.group({
          id: ['0'],
          fchaAudtria: [''],
          usrioAudtria: ['admin'],
          accionAudtria: ['Actualización'],
          comentarioAudtria: ['Usuario: ' + usuario.id],
          addressAudtria: ['...']
        });
        
      })
    } //ID no existe, porque se llama para la creacion
    else {
      this.form = this.fb.group({
        id: [''],
        login: ['', Validators.required],
        clave: ['', Validators.required],
        nombres: ['', Validators.required],
        apellidos: ['', Validators.required],
        idTipoUsuario: ['3', Validators.required],
        estado: ['A', Validators.required]
      });
      
      this.formAuditoria = this.fb.group({
        id: ['0'],
        fchaAudtria: [''],
        usrioAudtria: ['admin'],
        accionAudtria: ['Creación'],
        comentarioAudtria: ['Usuario: ' + this.form.value.login],
        addressAudtria: ['...']
      });
    }
  }
  
  save() {
    if(this.form?.invalid){
      this.form.markAllAsTouched();
      return;
    }
    
    const usuarioForm = this.form!.value;
    this.usuarioService.save(usuarioForm)
      .subscribe(() => {
        this.generateAuditoria();
        this.router.navigate(['admin/usuarios']);
      });
    
  }
  
  loadTiposUsuario() {
    this.tipoUsuarioService.getAll()
    .subscribe(tiposUsuarios => {
      this.tiposUsuario = tiposUsuarios;
    })
  }
  
  generateAuditoria(){
    const auditoriaForm = this.formAuditoria!.value;
    this.auditoriaService.save(auditoriaForm);
  }
  
}
