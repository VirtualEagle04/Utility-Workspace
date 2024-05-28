import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private http = inject(HttpClient);

  login(usuarioToCheck: Usuario) {
    return this.http.post<Usuario>('http://localhost:8181/usuario/login', usuarioToCheck)
  }
  
  signup(usuarioToRegister: Usuario) {
    return this.http.post<Usuario>('http://localhost:8181/usuario/signup', usuarioToRegister);
  }
}
