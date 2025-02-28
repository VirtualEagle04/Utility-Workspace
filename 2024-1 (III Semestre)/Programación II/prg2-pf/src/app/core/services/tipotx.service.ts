import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Tipotx } from '../models/tipotx';

@Injectable({
  providedIn: 'root'
})
export class TipotxService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<Tipotx[]>('http://localhost:8181/tipotx/getAll');
  }
  
  getTipotxById(id: number) {
    return this.http.get<Tipotx>(`http://localhost:8181/tipotx/findRecord/${id}`);
  }
  
  save(tipotx: Tipotx) {
    return this.http.post<Tipotx>('http://localhost:8181/tipotx/saveTipotx', tipotx);
  }
  
  delete(id: number) {
    return this.http.delete<Tipotx>(`http://localhost:8181/tipotx/deleteTipotx/${id}`);
  }
}
