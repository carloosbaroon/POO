import {Component} from '@angular/core';
import {NgForOf} from "@angular/common";
import {Cliente} from "./cliente";
import {CLIENTES} from "./clientes.json";

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './clientes.component.html',
})
export class ClientesComponent {

  clientes: Cliente[] = [];

  constructor() {}

  ngOnInit(): void {
    this.clientes = CLIENTES;
  }

}
