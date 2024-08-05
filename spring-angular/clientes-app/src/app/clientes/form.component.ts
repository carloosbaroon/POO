import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { Cliente } from "./cliente";
import { ClienteService } from "./cliente.service";
import { Router } from "@angular/router";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './form.component.html'
})
export class FormComponent {

  public cliente: Cliente = new Cliente();

  constructor(private clienteService: ClienteService,
              private router: Router) {
  }


  public create(): void{
    console.log("Create()");
    console.log(this.cliente)
    this.clienteService.create(this.cliente).subscribe(
      cliente => {
        this.router.navigate(['/clientes'])
        Swal.fire('Nuevo cliente', `Cliente: ${cliente.nombre} creado con exito!`, 'success')
      }
    );
  }

}
