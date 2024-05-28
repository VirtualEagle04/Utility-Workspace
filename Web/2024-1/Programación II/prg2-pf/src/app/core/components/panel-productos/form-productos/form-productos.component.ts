import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

import { ProductoService } from '../../../services/producto.service';
import { Producto } from '../../../models/producto';

import { CategoriaService } from '../../../services/categoria.service';
import { Categoria } from '../../../models/categoria';

@Component({
  selector: 'app-form-productos',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './form-productos.component.html',
  styleUrl: './form-productos.component.css'
})
export class FormProductosComponent implements OnInit{
  
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private productoService = inject(ProductoService);
  private categoriaService = inject(CategoriaService);
  
  categorias: Categoria[] = [];
  
  form?: FormGroup;
  producto?: Producto;
  
  ngOnInit(): void {
    this.loadCategorias();
    const id = this.route.snapshot.paramMap.get('id');
    
    //ID existe, porque se llama para modificar
    if(id){
      this.productoService.getProductoById(parseInt(id))
      .subscribe(producto => {
        this.producto = producto;
        this.form = this.fb.group({
          id: [producto.id],
          idCategoria: [producto.idCategoria, Validators.required],
          codigo: [producto.codigo, Validators.required],
          descripcion: [producto.descripcion, Validators.required],
          existencia: [producto.existencia, Validators.required],
          precioVentaActual: [producto.precioVentaActual, Validators.required],
          precioVentaAnterior: [producto.precioVentaAnterior, Validators.required],
          costoVenta: [producto.costoVenta, Validators.required],
          margenUtilidad: [producto.margenUtilidad, Validators.required],
          tieneIva: [producto.tieneIva, Validators.required],
          stockMinimo: [producto.stockMinimo, Validators.required],
          stockMaximo: [producto.stockMaximo, Validators.required],
          estado: [producto.estado, Validators.required]
        });
      })
    } //ID no existe, porque se llama para la creacion
    else {
      this.form = this.fb.group({
        id: [''],
        idCategoria: ['1', Validators.required],
        codigo: ['', Validators.required],
        descripcion: ['', Validators.required],
        existencia: ['1', Validators.required],
        precioVentaActual: ['1000', Validators.required],
        precioVentaAnterior: ['1000', Validators.required],
        costoVenta: ['1000', Validators.required],
        margenUtilidad: ['40', Validators.required],
        tieneIva: ['S', Validators.required],
        stockMinimo: ['1', Validators.required],
        stockMaximo: ['1', Validators.required],
        estado: ['A', Validators.required]
      });
    }
  }
  
  save() {
    if(this.form?.invalid){
      this.form.markAllAsTouched();
      return;
    }
    
    const productoForm = this.form!.value;
    this.productoService.save(productoForm)
      .subscribe(() => {
        this.router.navigate(['/admin/productos']);
      });
    
  }
  
  loadCategorias(){
    this.categoriaService.getAll()
    .subscribe(categorias => {
      this.categorias = categorias;
    })
  }
  
}
