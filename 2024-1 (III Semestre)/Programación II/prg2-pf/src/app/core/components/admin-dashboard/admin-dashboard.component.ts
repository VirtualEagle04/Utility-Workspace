import { Component } from '@angular/core';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AdminMainComponent } from './admin-main/admin-main.component';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [HeaderComponent, SidebarComponent, AdminMainComponent],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent {

}
