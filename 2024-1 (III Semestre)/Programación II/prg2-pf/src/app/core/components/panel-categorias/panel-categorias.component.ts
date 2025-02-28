import { Component, OnInit, inject } from '@angular/core';
import { CategoriaService } from '../../services/categoria.service';
import { RouterModule } from '@angular/router';
import { Categoria } from '../../models/categoria';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-categorias',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './panel-categorias.component.html',
  styleUrl: './panel-categorias.component.css'
})
export class PanelCategoriasComponent implements OnInit{
  private categoriaService = inject(CategoriaService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  categorias: Categoria[] = [];
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll(){
    this.categoriaService.getAll()
    .subscribe(categorias => {
      this.categorias = categorias;
    });
  }
  
  delete(categoria: Categoria) {
    this.categoriaService.delete(categoria.id)
    .subscribe(categoria => {
      console.log('Categoría eliminada', categoria);
      this.loadAll();
    })
  }
}
