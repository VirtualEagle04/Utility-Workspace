import { Routes } from '@angular/router';
import { PanelUsuariosComponent } from './core/components/panel-usuarios/panel-usuarios.component';
import { FormUsuariosComponent } from './core/components/panel-usuarios/form-usuarios/form-usuarios.component';

export const routes: Routes = [
    {
        path: '',
        component: PanelUsuariosComponent
    },
    {
        path: 'newUser',
        component: FormUsuariosComponent
    },
    {
        path: ':id/editUser',
        component: FormUsuariosComponent
    }
];
