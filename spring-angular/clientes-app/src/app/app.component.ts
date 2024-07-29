import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import {FooterComponent} from "./footer/footer.component";
import {DirectiveComponent} from "./directive/directive.component";
import {ClientesComponent} from "./clientes/clientes.component";

@Component({
  selector: 'app-root', // This will be the tag in html
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FooterComponent, DirectiveComponent, ClientesComponent,],
  templateUrl: './app.component.html', // This is the view for this component
  styleUrls: ['./app.component.css'] // This is the style sheet
})

// This is the MAIN component of the app!
export class AppComponent {
  title = 'Bienvenido a Angular';
  curso = 'Curso Spring con Angular';
}
