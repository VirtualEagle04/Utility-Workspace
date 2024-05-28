import { Component, OnInit, inject } from '@angular/core';
import { ProductoService } from '../../services/producto.service';
import { ActivatedRoute, RouterModule, Router } from '@angular/router';
import { Producto } from '../../models/producto';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faBagShopping } from '@fortawesome/free-solid-svg-icons';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'app-product-browser',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './product-browser.component.html',
  styleUrl: './product-browser.component.css'
})
export class ProductBrowserComponent implements OnInit{
  private productoService = inject(ProductoService);
  private usuarioService = inject(UsuarioService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  
  productos: Producto[] = []
  usuario?: Usuario;
  
  faBagShopping = faBagShopping;
  
  ngOnInit(): void {
    this.loadAll();
    const id = this.route.snapshot.parent?.paramMap.get('id');
    
    if(id){
      this.usuarioService.getUsuarioById(parseInt(id))
      .subscribe(usuario => {
        this.usuario = usuario;
      })
    }
  }
  
  loadAll() {
    this.productoService.getAll()
      .subscribe(productos => {
        this.productos = productos;
      });
  }
  
  buy(producto: Producto) {
    this.router.navigate([`${this.usuario?.id}/user/${producto.id}/buy`]);
  }
}
