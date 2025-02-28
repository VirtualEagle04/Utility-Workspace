import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private http = inject(HttpClient);
  
  getAll() {
    return this.http.get<Usuario[]>('http://localhost:8181/usuario/getAll');
  }
  
  getUsuarioById(id: number) {
    return this.http.get<Usuario>(`http://localhost:8181/usuario/findRecord/${id}`);
  }
  
  save(usuario: Usuario) {
    return this.http.post<Usuario>('http://localhost:8181/usuario/saveUsuario', usuario);
  }
  
  delete(id: number) {
    return this.http.delete<Usuario>(`http://localhost:8181/usuario/deleteUsuario/${id}`);
  }
}
