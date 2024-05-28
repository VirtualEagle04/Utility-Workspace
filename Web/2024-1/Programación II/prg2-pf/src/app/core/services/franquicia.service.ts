import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Franquicia } from '../models/franquicia';

@Injectable({
  providedIn: 'root'
})
export class FranquiciaService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<Franquicia[]>('http://localhost:8181/franquicia/getAll');
  }
  
  getFranquiciaById(id: number) {
    return this.http.get<Franquicia>(`http://localhost:8181/franquicia/findRecord/${id}`);
  }
  
  save(franquicia: Franquicia) {
    return this.http.post<Franquicia>('http://localhost:8181/franquicia/saveFranquicia', franquicia);
  }
  
  delete(id: number) {
    return this.http.delete<Franquicia>(`http://localhost:8181/franquicia/deleteFranquicia/${id}`);
  }
}
