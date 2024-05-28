import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

import { ProductoService } from '../../../services/producto.service';
import { UsuarioService } from '../../../services/usuario.service';
import { TransaccionService } from '../../../services/transaccion.service';
import { MediosDePagoService } from '../../../services/medios-de-pago.service';
import { EntidadFinancieraService } from '../../../services/entidad-financiera.service';
import { FranquiciaService } from '../../../services/franquicia.service';

import { Producto } from '../../../models/producto';
import { Usuario } from '../../../models/usuario';
import { MediosDePago } from '../../../models/medios-de-pago';
import { EntidadFinanciera } from '../../../models/entidad-financiera';
import { Franquicia } from '../../../models/franquicia';

@Component({
  selector: 'app-buy-product',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './buy-product.component.html',
  styleUrl: './buy-product.component.css'
})
export class BuyProductComponent implements OnInit{
  
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private productoService = inject(ProductoService);
  private usuarioService = inject(UsuarioService);
  private transaccionService = inject(TransaccionService);
  
  private mediosDePagoService = inject(MediosDePagoService);
  private entidadFinancieraService = inject(EntidadFinancieraService);
  private franquiciaService = inject(FranquiciaService);
  
  mediosDePago: MediosDePago[] = [];
  entidadesFinancieras: EntidadFinanciera[] =[];
  franquicias: Franquicia[] = [];
  
  form?: FormGroup;
  producto?: Producto;
  usuario?: Usuario;
  
  ngOnInit(): void {
    const id = this.route.snapshot.parent?.paramMap.get('id');
    const prodId = this.route.snapshot.paramMap.get('prodID');
    this.loadMediosDePago();
    this.loadEntidadesFinancieras();
    this.loadFranquicias();
    
    if(prodId){
      this.productoService.getProductoById(parseInt(prodId))
      .subscribe(producto => {
        this.producto = producto;
        console.log(this.producto.id);
      })
      
    }
    if(id){
      this.usuarioService.getUsuarioById(parseInt(id))
      .subscribe(usuario => {
        this.usuario = usuario;
        this.form = this.fb.group({
          id: ['0'],
          fechaHora: [''],
          usuario: [this.usuario?.login],
          idProducto: [this.producto?.id],
          cantComprada: ['1', Validators.required],
          valorUnitario: [this.producto?.precioVentaActual, Validators.required],
          idTipoPago: ['1', Validators.required],
          idBanco: ['1', Validators.required],
          idFranquicia: ['1', Validators.required],
          numTarjeta: ['', Validators.required],
          estado: ['A']
        });
      })
    }
    
  }
  
  confirm(){
    const transaccionForm = this.form!.value;
    this.transaccionService.save(transaccionForm)
    .subscribe((transaccion) => {
      this.router.navigate([`${this.usuario?.id}/user`])
    })
    
    if(this.form?.invalid){
      this.form.markAllAsTouched();
      return;
    }
  }
  
  cancel(){
    this.router.navigate([`${this.usuario?.id}/user`])
  }
  
  loadMediosDePago(){
    this.mediosDePagoService.getAll()
    .subscribe(mediosDePago => {
      this.mediosDePago = mediosDePago;
    })
  }
  
  loadEntidadesFinancieras(){
    this.entidadFinancieraService.getAll()
    .subscribe(entidadesFinancieras => {
      this.entidadesFinancieras = entidadesFinancieras;
    })
  }
  
  loadFranquicias(){
    this.franquiciaService.getAll()
    .subscribe(franquicias => {
      this.franquicias = franquicias;
    })
  }
  
}
