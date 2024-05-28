import { Component } from '@angular/core';
import { UserHeaderComponent } from './user-header/user-header.component';
import { UserSidebarComponent } from './user-sidebar/user-sidebar.component';
import { UserMainComponent } from './user-main/user-main.component';

@Component({
  selector: 'app-user-dashboard',
  standalone: true,
  imports: [UserHeaderComponent, UserSidebarComponent, UserMainComponent],
  templateUrl: './user-dashboard.component.html',
  styleUrl: './user-dashboard.component.css'
})
export class UserDashboardComponent {

}
