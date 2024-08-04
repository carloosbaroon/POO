import { Component, OnInit } from '@angular/core';
import { NgForOf } from '@angular/common';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [
    NgForOf,
    RouterLink
  ],
  templateUrl: './clientes.component.html',
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[] = [];

  constructor(private clienteService: ClienteService) {}

  ngOnInit(): void {
    this.clienteService.getClientes().subscribe(
      clientes => this.clientes = clientes
    );
  }

}
