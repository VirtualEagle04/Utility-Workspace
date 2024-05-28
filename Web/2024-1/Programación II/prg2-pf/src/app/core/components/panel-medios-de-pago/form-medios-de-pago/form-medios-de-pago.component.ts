import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { MediosDePagoService } from '../../../services/medios-de-pago.service';
import { MediosDePago } from '../../../models/medios-de-pago';

@Component({
  selector: 'app-form-medios-de-pago',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-medios-de-pago.component.html',
  styleUrl: './form-medios-de-pago.component.css'
})
export class FormMediosDePagoComponent implements OnInit{

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private mediosDePagoService = inject(MediosDePagoService)
  
  form?: FormGroup;
  medioDePago?: MediosDePago;
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
    if(id){
      this.mediosDePagoService.getMediosDePagoById(parseInt(id))
      .subscribe(medioDePago => {
        this.medioDePago = medioDePago;
        this.form = this.fb.group({
          id: [medioDePago.id],
          descripcion: [medioDePago.descripcion, Validators.required],
          estado: [medioDePago.estado, Validators.required]
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
    
    const medioDePagoForm = this.form!.value;
    this.mediosDePagoService.save(medioDePagoForm)
      .subscribe(() => {
        this.router.navigate(['admin/mediosDePago']);
      });
    
  }
  
}
