import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { TipoUsuario } from '../models/tipo-usuario';

@Injectable({
  providedIn: 'root'
})
export class TipoUsuarioService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<TipoUsuario[]>('http://localhost:8181/tipoUsuario/getAll');
  }
  
  getTipoUsuarioById(id: number) {
    return this.http.get<TipoUsuario>(`http://localhost:8181/tipoUsuario/findRecord/${id}`);
  }
  
  save(tipoUsuario: TipoUsuario) {
    return this.http.post<TipoUsuario>('http://localhost:8181/tipoUsuario/saveTipoUsuario', tipoUsuario);
  }
  
  delete(id: number) {
    return this.http.delete<TipoUsuario>(`http://localhost:8181/tipoUsuario/deleteTipoUsuario/${id}`);
  }
}
