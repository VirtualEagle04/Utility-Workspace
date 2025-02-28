import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faBell } from '@fortawesome/free-regular-svg-icons';
import { faLayerGroup } from '@fortawesome/free-solid-svg-icons';
import { faBuildingColumns } from '@fortawesome/free-solid-svg-icons';
import { faBagShopping } from '@fortawesome/free-solid-svg-icons';
import { faCoins } from '@fortawesome/free-solid-svg-icons';
import { faCode } from '@fortawesome/free-solid-svg-icons';
import { faCartShopping } from '@fortawesome/free-solid-svg-icons';
import { faUsers } from '@fortawesome/free-solid-svg-icons';
import { faUser } from '@fortawesome/free-regular-svg-icons';
import { faCreditCard } from '@fortawesome/free-regular-svg-icons';
import { faArrowsTurnToDots } from '@fortawesome/free-solid-svg-icons';

import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterModule, FontAwesomeModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

  faBell = faBell;
  faLayerGroup = faLayerGroup;
  faBuildingColumns = faBuildingColumns;
  faBagShopping = faBagShopping;
  faCoins = faCoins;
  faCode = faCode;
  faCartShopping = faCartShopping;
  faUsers = faUsers;
  faUser = faUser;
  faCreditCard = faCreditCard;
  faArrowsTurnToDots = faArrowsTurnToDots;
}
