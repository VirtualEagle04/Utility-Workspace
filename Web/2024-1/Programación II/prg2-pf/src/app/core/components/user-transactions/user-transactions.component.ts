import { Component, OnInit, inject } from '@angular/core';
import { TransaccionService } from '../../services/transaccion.service';
import { UsuarioService } from '../../services/usuario.service';
import { Transaccion } from '../../models/transaccion';
import { Usuario } from '../../models/usuario';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-transactions',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './user-transactions.component.html',
  styleUrl: './user-transactions.component.css'
})
export class UserTransactionsComponent implements OnInit{
  private transaccionService = inject(TransaccionService);
  private route = inject(ActivatedRoute);
  private usuarioService = inject(UsuarioService);
  
  transacciones: any[] = [];
  usuario?: Usuario;

  ngOnInit(): void {
    const id = this.route.snapshot.parent?.paramMap.get('id');
    console.log(id)
    if(id){
      this.usuarioService.getUsuarioById(parseInt(id))
      .subscribe(usuario => {
        this.usuario = usuario;
      })
    }
    
    this.loadAll();
  }
  
  loadAll(){
    this.transaccionService.getAll()
      .subscribe((transacciones: Transaccion[]) => {
        
        for(let i = 0; i < transacciones.length; i++) {
          console.log(transacciones[i].usuario);
          if(transacciones[i].usuario === this.usuario?.login) {
            this.transacciones.push(transacciones[i]);
          }
        }
      });
  }
}
