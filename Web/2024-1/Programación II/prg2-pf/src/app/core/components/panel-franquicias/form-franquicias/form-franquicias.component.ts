import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FranquiciaService } from '../../../services/franquicia.service';
import { Franquicia } from '../../../models/franquicia';

@Component({
  selector: 'app-form-franquicias',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-franquicias.component.html',
  styleUrl: './form-franquicias.component.css'
})
export class FormFranquiciasComponent implements OnInit{
  
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private franquiciaService = inject(FranquiciaService)
  
  form?: FormGroup;
  franquicia?: Franquicia;
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
    if(id){
      this.franquiciaService.getFranquiciaById(parseInt(id))
      .subscribe(franquicia => {
        this.franquicia = franquicia;
        this.form = this.fb.group({
          id: [franquicia.id],
          descripcion: [franquicia.descripcion, Validators.required],
          estado: [franquicia.estado, Validators.required]
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
    
    const franquiciaForm = this.form!.value;
    this.franquiciaService.save(franquiciaForm)
      .subscribe(() => {
        this.router.navigate(['admin/franquicias']);
      });
    
  }

}
