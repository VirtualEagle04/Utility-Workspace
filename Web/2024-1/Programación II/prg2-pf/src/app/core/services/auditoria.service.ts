import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Auditoria } from '../models/auditoria';

@Injectable({
  providedIn: 'root'
})
export class AuditoriaService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<Auditoria[]>('http://localhost:8181/auditoria/getAll');
  }
  
  getAuditoriaById(id: number) {
    return this.http.get<Auditoria>(`http://localhost:8181/auditoria/findRecord/${id}`);
  }
  
  save(auditoria: Auditoria) {
    return this.http.post<Auditoria>('http://localhost:8181/auditoria/saveAuditoria', auditoria);
  }
  
  delete(id: number) {
    return this.http.delete<Auditoria>(`http://localhost:8181/auditoria/deleteAuditoria/${id}`);
  }
}
