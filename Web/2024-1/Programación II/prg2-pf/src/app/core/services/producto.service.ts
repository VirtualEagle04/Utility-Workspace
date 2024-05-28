import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<Producto[]>('http://localhost:8181/producto/getAll');
  }
  
  getProductoById(id: number) {
    return this.http.get<Producto>(`http://localhost:8181/producto/findRecord/${id}`);
  }
  
  save(producto: Producto) {
    return this.http.post<Producto>('http://localhost:8181/producto/saveProducto', producto);
  }
  
  delete(id: number) {
    return this.http.delete<Producto>(`http://localhost:8181/producto/deleteProducto/${id}`);
  }
}
