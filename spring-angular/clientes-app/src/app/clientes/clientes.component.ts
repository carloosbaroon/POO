import { Component, OnInit } from '@angular/core';
import { NgForOf } from '@angular/common';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [
    NgForOf
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
