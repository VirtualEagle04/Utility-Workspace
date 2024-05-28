import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { TipotxService } from '../../../services/tipotx.service';
import { Tipotx } from '../../../models/tipotx';

@Component({
  selector: 'app-form-tipostx',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-tipostx.component.html',
  styleUrl: './form-tipostx.component.css'
})
export class FormTipostxComponent implements OnInit{

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private tipotxService = inject(TipotxService);
  
  form?: FormGroup;
  tipotx?: Tipotx;
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
    if(id){
      this.tipotxService.getTipotxById(parseInt(id))
      .subscribe(tipotx => {
        this.tipotx = tipotx;
        this.form = this.fb.group({
          id: [tipotx.id],
          descripcion: [tipotx.descripcion, Validators.required],
          estado: [tipotx.estado, Validators.required]
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
    
    const tipotxForm = this.form!.value;
    this.tipotxService.save(tipotxForm)
      .subscribe(() => {
        this.router.navigate(['admin/tiposTx']);
      });
    
  }
}
