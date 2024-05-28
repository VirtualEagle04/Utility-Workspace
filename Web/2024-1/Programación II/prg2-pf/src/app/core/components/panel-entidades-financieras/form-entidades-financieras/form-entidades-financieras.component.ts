import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { EntidadFinancieraService } from '../../../services/entidad-financiera.service';
import { EntidadFinanciera } from '../../../models/entidad-financiera';

@Component({
  selector: 'app-form-entidades-financieras',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-entidades-financieras.component.html',
  styleUrl: './form-entidades-financieras.component.css'
})
export class FormEntidadesFinancierasComponent implements OnInit{
  
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private entidadFinancieraService = inject(EntidadFinancieraService)
  
  form?: FormGroup;
  entidadFinanciera?: EntidadFinanciera;
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
    if(id){
      this.entidadFinancieraService.getEntidadFinancieraById(parseInt(id))
      .subscribe(entidadFinanciera => {
        this.entidadFinanciera = entidadFinanciera;
        this.form = this.fb.group({
          id: [entidadFinanciera.id],
          nombre: [entidadFinanciera.nombre, Validators.required],
          estado: [entidadFinanciera.estado, Validators.required]
        });
      })
    } //ID no existe, porque se llama para la creacion
    else {
      this.form = this.fb.group({
        id: [''],
        nombre: [''],
        estado: ['A', Validators.required]
      });
    }
  }
  
  save() {
    if(this.form?.invalid){
      this.form.markAllAsTouched();
      return;
    }
    
    const entidadFinancieraForm = this.form!.value;
    this.entidadFinancieraService.save(entidadFinancieraForm)
      .subscribe(() => {
        this.router.navigate(['admin/entidadesFinancieras']);
      });
    
  }

}
