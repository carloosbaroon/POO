import { Component, OnInit } from '@angular/core';
import {NgForOf, NgIf} from '@angular/common';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { RouterLink } from "@angular/router";
import Swal from "sweetalert2";

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [
    NgForOf,
    RouterLink,
    NgIf
  ],
  templateUrl: './clientes.component.html',
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[] = [];

  constructor(private clienteService: ClienteService) {
  }

  ngOnInit(): void {
    this.clienteService.getClientes().subscribe(
      clientes => this.clientes = clientes
    );
  }

  delete(cliente: Cliente): void {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: "btn btn-success",
        cancelButton: "btn btn-danger"
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: "¿Estás seguro?",
      text: `¿Seguro que deseas eliminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: "Sí, eliminar!",
      cancelButtonText: "No, cancelar!",
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed && cliente.id !== undefined) { // Check if cliente.id is defined
        this.clienteService.delete(cliente.id).subscribe(() => {
          this.clientes = this.clientes.filter(cli => cli !== cliente)
          swalWithBootstrapButtons.fire({
            title: "Eliminado!",
            text: `El cliente ${cliente.nombre} ${cliente.apellido} ha sido eliminado.`,
            icon: "success"
          });
        });
      }
    });
  }
}
