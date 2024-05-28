import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Parametro } from '../models/parametro';

@Injectable({
  providedIn: 'root'
})
export class ParametroService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<Parametro[]>('http://localhost:8181/parametro/getAll');
  }
  
  getParametroById(id: number) {
    return this.http.get<Parametro>(`http://localhost:8181/parametro/findRecord/${id}`);
  }
  
  save(parametro: Parametro) {
    return this.http.post<Parametro>('http://localhost:8181/parametro/saveParametro', parametro);
  }
  
  delete(id: number) {
    return this.http.delete<Parametro>(`http://localhost:8181/parametro/deleteParametro/${id}`);
  }
}
