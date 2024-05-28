import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Transaccion } from '../models/transaccion';

@Injectable({
  providedIn: 'root'
})
export class TransaccionService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<Transaccion[]>('http://localhost:8181/transaccion/getAll');
  }
  
  getUsuarioById(id: number) {
    return this.http.get<Transaccion>(`http://localhost:8181/transaccion/findRecord/${id}`);
  }
  
  save(transaccion: Transaccion) {
    return this.http.post<Transaccion>('http://localhost:8181/transaccion/saveTransaccion', transaccion);
  }
  
  delete(id: number) {
    return this.http.delete<Transaccion>(`http://localhost:8181/transaccion/deleteTransaccion/${id}`);
  }
}
