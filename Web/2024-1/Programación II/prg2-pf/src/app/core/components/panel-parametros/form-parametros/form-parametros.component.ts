import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ParametroService } from '../../../services/parametro.service';
import { Parametro } from '../../../models/parametro';

@Component({
  selector: 'app-form-parametros',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-parametros.component.html',
  styleUrl: './form-parametros.component.css'
})
export class FormParametrosComponent implements OnInit{

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private parametroService = inject(ParametroService);
  
  form?: FormGroup;
  parametro?: Parametro;
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
    if(id){
      this.parametroService.getParametroById(parseInt(id))
      .subscribe(parametro => {
        this.parametro = parametro;
        this.form = this.fb.group({
          id: [parametro.id],
          descripcion: [parametro.descripcion, Validators.required],
          fchaFinal: [parametro.fchaFinal, Validators.required],
          fchaInicial: [parametro.fchaInicial, Validators.required],
          valorNumero: [parametro.valorNumero, Validators.required],
          valorTexto: [parametro.valorTexto, Validators.required],
          estado: [parametro.estado, Validators.required]
        });
      })
    } //ID no existe, porque se llama para la creacion
    else {
      this.form = this.fb.group({
        id: [''],
        descripcion: ['', Validators.required],
        fchaFinal: ['', Validators.required],
        fchaInicial: ['', Validators.required],
        valorNumero: ['', Validators.required],
        valorTexto: ['', Validators.required],
        estado: ['A', Validators.required]
      });
    }
  }
  
  save() {
    if(this.form?.invalid){
      this.form.markAllAsTouched();
      return;
    }
    
    const parametroForm = this.form!.value;
    this.parametroService.save(parametroForm)
      .subscribe(() => {
        this.router.navigate(['/admin/parametros']);
      });
    
  }
}
