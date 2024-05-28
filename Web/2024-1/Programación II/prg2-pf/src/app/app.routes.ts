import { Routes } from '@angular/router';

import { PanelAuditoriasComponent } from './core/components/panel-auditorias/panel-auditorias.component';

import { PanelCategoriasComponent } from './core/components/panel-categorias/panel-categorias.component';
import { FormCategoriasComponent } from './core/components/panel-categorias/form-categorias/form-categorias.component';

import { PanelEntidadesFinancierasComponent } from './core/components/panel-entidades-financieras/panel-entidades-financieras.component';
import { FormEntidadesFinancierasComponent } from './core/components/panel-entidades-financieras/form-entidades-financieras/form-entidades-financieras.component';

import { PanelFranquiciasComponent } from './core/components/panel-franquicias/panel-franquicias.component';
import { FormFranquiciasComponent } from './core/components/panel-franquicias/form-franquicias/form-franquicias.component';

import { PanelMediosDePagoComponent } from './core/components/panel-medios-de-pago/panel-medios-de-pago.component'; 
import { FormMediosDePagoComponent } from './core/components/panel-medios-de-pago/form-medios-de-pago/form-medios-de-pago.component';

import { PanelParametrosComponent } from './core/components/panel-parametros/panel-parametros.component';
import { FormParametrosComponent } from './core/components/panel-parametros/form-parametros/form-parametros.component';

import { PanelProductosComponent } from './core/components/panel-productos/panel-productos.component';
import { FormProductosComponent } from './core/components/panel-productos/form-productos/form-productos.component';

import { PanelTiposUsuariosComponent } from './core/components/panel-tipos-usuarios/panel-tipos-usuarios.component';
import { FormTiposUsuarioComponent } from './core/components/panel-tipos-usuarios/form-tipos-usuario/form-tipos-usuario.component';

import { PanelTipostxComponent } from './core/components/panel-tipostx/panel-tipostx.component';
import { FormTipostxComponent } from './core/components/panel-tipostx/form-tipostx/form-tipostx.component';

import { PanelTransaccionesComponent } from './core/components/panel-transacciones/panel-transacciones.component';

import { PanelUsuariosComponent } from './core/components/panel-usuarios/panel-usuarios.component';
import { FormUsuariosComponent } from './core/components/panel-usuarios/form-usuarios/form-usuarios.component';

import { LoginComponent } from './core/components/login/login.component';
import { SignupComponent } from './core/components/signup/signup.component';

import { AdminDashboardComponent } from './core/components/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './core/components/user-dashboard/user-dashboard.component';
import { UserProfileComponent } from './core/components/user-profile/user-profile.component';
import { ProductBrowserComponent } from './core/components/product-browser/product-browser.component';
import { UserTransactionsComponent } from './core/components/user-transactions/user-transactions.component';
import { BuyProductComponent } from './core/components/product-browser/buy-product/buy-product.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: SignupComponent
    },
    {
        path: 'admin',
        component: AdminDashboardComponent,
        children: [
            //AUDITORIAS
            {
                path: 'auditorias',
                component: PanelAuditoriasComponent
            },
            //CATEGORIAS
            {
                path: 'categorias',
                component: PanelCategoriasComponent
            },
            {
                path: 'categorias/formC',
                component: FormCategoriasComponent
            },
            {
                path: 'categorias/:id/editC',
                component: FormCategoriasComponent
            },
            //ENTIDADES FINANCIERAS
            {
                path: 'entidadesFinancieras',
                component: PanelEntidadesFinancierasComponent
            },
            {
                path: 'entidadesFinancieras/formEF',
                component: FormEntidadesFinancierasComponent
            },
            {
                path: 'entidadesFinancieras/:id/editEF',
                component: FormEntidadesFinancierasComponent  
            },
            //FRANQUICIAS
            {
                path: 'franquicias',
                component: PanelFranquiciasComponent
            },
            {
                path: 'franquicias/formFra',
                component: FormFranquiciasComponent
            },
            {
                path: 'franquicias/:id/editFra',
                component: FormFranquiciasComponent  
            },
            //MEDIOS DE PAGO
            {
                path: 'mediosDePago',
                component: PanelMediosDePagoComponent
            },
            {
                path: 'mediosDePago/formMP',
                component: FormMediosDePagoComponent
            },
            {
                path: 'mediosDePago/:id/editMP',
                component: FormMediosDePagoComponent  
            },
            //PARAMETROS
            {
                path: 'parametros',
                component: PanelParametrosComponent
            },
            {
                path: 'parametros/formPar',
                component: FormParametrosComponent
            },
            {
                path: 'parametros/:id/editPar',
                component: FormParametrosComponent
            },
            //PRODUCTOS
            {
                path: 'productos',
                component: PanelProductosComponent
            },
            {
                path: 'productos/formProd',
                component: FormProductosComponent
            },
            {
                path: 'productos/:id/editProd' ,
                component: FormProductosComponent 
            },
            //TIPOS DE USUARIOS
            {
                path: 'tiposUsuario',
                component: PanelTiposUsuariosComponent
            },
            {
                path: 'tiposUsuario/formTU',
                component: FormTiposUsuarioComponent
            },
            {
                path: 'tiposUsuario/:id/editTU',
                component: FormTiposUsuarioComponent
            },
            //TIPOS DE TRANSACCIONES
            {
                path: 'tiposTx',
                component: PanelTipostxComponent
            },
            {
                path: 'tiposTx/formTX',
                component: FormTipostxComponent
            },
            {
                path: 'tiposTx/:id/editTX',
                component: FormTipostxComponent
            },
            //TRANSACCIONES
            {
                path: 'transacciones',
                component: PanelTransaccionesComponent
            },
            //USUARIOS
            {
                path: 'usuarios',
                component: PanelUsuariosComponent
            },
            {
                path: 'usuarios/formU',
                component: FormUsuariosComponent
            },
            {
                path: 'usuarios/:id/editU',
                component: FormUsuariosComponent
            }
        ]
    },
    {
        path: ':id/user',
        component: UserDashboardComponent,
        children: [
            {
                path: 'profile',
                component: UserProfileComponent
            },
            {
                path: 'browse',
                component: ProductBrowserComponent    
            },
            {
                path: 'transactions',
                component: UserTransactionsComponent
            },
            {
                path: ':prodID/buy',
                component: BuyProductComponent
            }
        ]
    }
];
