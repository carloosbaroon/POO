import { Routes } from '@angular/router';
import {DirectiveComponent} from "./directive/directive.component";
import {ClientesComponent} from "./clientes/clientes.component";
import {FormComponent} from "./clientes/form.component";

//Here we'll define our routes and
export const routes: Routes = [
  {path: '', redirectTo: '/clientes', pathMatch: 'full'},
  {path: 'directivas', component: DirectiveComponent},
  {path: 'clientes', component: ClientesComponent},
  {path: 'clientes/form', component: FormComponent},
];
