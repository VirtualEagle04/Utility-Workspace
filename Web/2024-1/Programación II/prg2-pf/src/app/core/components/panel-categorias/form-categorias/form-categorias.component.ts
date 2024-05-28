import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CategoriaService } from '../../../services/categoria.service';
import { Categoria } from '../../../models/categoria';

@Component({
  selector: 'app-form-categorias',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-categorias.component.html',
  styleUrl: './form-categorias.component.css'
})
export class FormCategoriasComponent implements OnInit{
  
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private categoriaService = inject(CategoriaService)
  
  form?: FormGroup;
  categoria?: Categoria;
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
    if(id){
      this.categoriaService.getCategoriaById(parseInt(id))
      .subscribe(categoria => {
        this.categoria = categoria;
        this.form = this.fb.group({
          id: [categoria.id],
          nombre: [categoria.nombre, Validators.required],
          estado: [categoria.estado, Validators.required]
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
    
    const categoriaForm = this.form!.value;
    this.categoriaService.save(categoriaForm)
      .subscribe(() => {
        this.router.navigate(['admin/categorias']);
      });
    
  }

}
