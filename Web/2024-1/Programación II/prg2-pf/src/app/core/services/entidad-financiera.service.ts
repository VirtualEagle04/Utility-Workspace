import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { EntidadFinanciera } from '../models/entidad-financiera';

@Injectable({
  providedIn: 'root'
})
export class EntidadFinancieraService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<EntidadFinanciera[]>('http://localhost:8181/entidadFinanciera/getAll');
  }
  
  getEntidadFinancieraById(id: number) {
    return this.http.get<EntidadFinanciera>(`http://localhost:8181/entidadFinanciera/findRecord/${id}`);
  }
  
  save(entidadFinanciera: EntidadFinanciera) {
    return this.http.post<EntidadFinanciera>('http://localhost:8181/entidadFinanciera/saveEntidadFinanciera', entidadFinanciera);
  }
  
  delete(id: number) {
    return this.http.delete<EntidadFinanciera>(`http://localhost:8181/entidadFinanciera/deleteEntidadFinanciera/${id}`);
  }
}
