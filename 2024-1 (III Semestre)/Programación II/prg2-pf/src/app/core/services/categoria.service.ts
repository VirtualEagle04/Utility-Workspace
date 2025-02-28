import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Categoria } from '../models/categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<Categoria[]>('http://localhost:8181/categoria/getAll');
  }
  
  getCategoriaById(id: number) {
    return this.http.get<Categoria>(`http://localhost:8181/categoria/findRecord/${id}`);
  }
  
  save(categoria: Categoria) {
    return this.http.post<Categoria>('http://localhost:8181/categoria/saveCategoria', categoria);
  }
  
  delete(id: number) {
    return this.http.delete<Categoria>(`http://localhost:8181/categoria/deleteCategoria/${id}`);
  }
}
