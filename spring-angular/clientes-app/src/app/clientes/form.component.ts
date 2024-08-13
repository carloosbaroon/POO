import {Component, OnInit } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { Cliente } from "./cliente";
import { ClienteService } from "./cliente.service";
import { Router, ActivatedRoute } from "@angular/router";
import Swal from 'sweetalert2';
import { CommonModule } from "@angular/common";

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit{

  public cliente: Cliente = new Cliente();

  public errores?: string[];

  constructor(private clienteService: ClienteService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.cargarCliente();
  }

  public cargarCliente(): void {
    console.log("cargarCliente()");
    this.activatedRoute.params.subscribe(params => {
      let id = params['id'];
      if (id) {
        this.clienteService.getCliente(id).subscribe((cliente) => this.cliente = cliente);
      }
    });
  }

  public create(): void {
    console.log("Create()");
    console.log(this.cliente)
    this.clienteService.create(this.cliente).subscribe({
      next: (json: Cliente) => {
        this.router.navigate(['/clientes']);
        Swal.fire('Nuevo cliente', `El cliente ${this.cliente.nombre} ha sido creado con exito`, 'success');
      },
      error: (err: any) => {
        this.errores = err.error.errors as string[];
        console.error(this.errores);
        console.error('Codigo del error desde el backend: ' + err.status);
      }
    });

  }

  public update(): void {
    this.clienteService.update(this.cliente).subscribe({
      next: (json: any) => {  // Adjust the type according to your actual response
        this.router.navigate(['/clientes']);
        Swal.fire('Cliente Actualizado', `${json.mensaje}: ${json.cliente.nombre}`, 'success');
      },
      error: (err: any) => {
        this.errores = err.error.errors as string[];
        console.error(this.errores);
        console.error('Codigo del error desde el backend: ' + err.status);
      }
    });
  }


}
