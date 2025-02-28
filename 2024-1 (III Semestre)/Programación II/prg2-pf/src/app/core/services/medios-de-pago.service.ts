import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { MediosDePago } from '../models/medios-de-pago';

@Injectable({
  providedIn: 'root'
})
export class MediosDePagoService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<MediosDePago[]>('http://localhost:8181/mediosDePago/getAll');
  }
  
  getMediosDePagoById(id: number) {
    return this.http.get<MediosDePago>(`http://localhost:8181/mediosDePago/findRecord/${id}`);
  }
  
  save(mediosDePago: MediosDePago) {
    return this.http.post<MediosDePago>('http://localhost:8181/mediosDePago/saveMediosDePago', mediosDePago);
  }
  
  delete(id: number) {
    return this.http.delete<MediosDePago>(`http://localhost:8181/mediosDePago/deleteMediosDePago/${id}`);
  }
}
