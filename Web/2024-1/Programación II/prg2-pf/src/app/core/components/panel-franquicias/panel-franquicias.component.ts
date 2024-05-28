import { Component, OnInit, inject } from '@angular/core';
import { FranquiciaService } from '../../services/franquicia.service';
import { RouterModule } from '@angular/router';
import { Franquicia } from '../../models/franquicia';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-panel-franquicias',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './panel-franquicias.component.html',
  styleUrl: './panel-franquicias.component.css'
})
export class PanelFranquiciasComponent implements OnInit{
  private franquiciaService = inject(FranquiciaService);
  
  faPenToSquare = faPenToSquare;
  faTrash = faTrash;
  faPlus = faPlus;
  
  franquicias: Franquicia[] = [];
  
  ngOnInit(): void {
    this.loadAll();
  }
  
  loadAll(){
    this.franquiciaService.getAll()
    .subscribe(franquicias => {
      this.franquicias = franquicias;
    });
  }
  
  delete(franquicia: Franquicia) {
    this.franquiciaService.delete(franquicia.id)
    .subscribe(franquicia => {
      console.log('Franquicia eliminada', franquicia);
      this.loadAll();
    })
  }
  
}
