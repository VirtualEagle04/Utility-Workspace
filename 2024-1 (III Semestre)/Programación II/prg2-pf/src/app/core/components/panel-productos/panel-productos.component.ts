import { Component, OnInit, inject } from '@angular/core';
import { ProductoService } from '../../services/producto.service';
import { RouterModule } from '@angular/router';
import { Producto } from '../../models/producto';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-productos',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './panel-productos.component.html',
  styleUrl: './panel-productos.component.css'
})
export class PanelProductosComponent implements OnInit{
  private productoService = inject(ProductoService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  productos: Producto[] = []
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll() {
    this.productoService.getAll()
      .subscribe(productos => {
        this.productos = productos;
      });
  }
  
  delete(producto: Producto) {
    this.productoService.delete(producto.id)
    .subscribe(producto => {
      console.log('Producto eliminado', producto);
      this.loadAll();
    })
  }
}
