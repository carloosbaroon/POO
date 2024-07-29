import {Component} from '@angular/core';
import {Cliente} from "./cliente";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './clientes.component.html',
})
export class ClientesComponent {

  clientes: Cliente[] = [
    {id: 1, nombre: 'Aleph', apellido: 'Baron', email: 'abaron@email.com', createAt: '2024-29-07'},
    {id: 2, nombre: 'Carlos', apellido: 'Baron', email: 'cbaron@email.com', createAt: '2024-29-07'},
    {id: 3, nombre: 'Test', apellido: 'TestA', email: 'test@email.com', createAt: '1999-19-09'},
    {id: 4, nombre: 'Magma', apellido: 'Lee', email: 'mlee@email.com', createAt: '2024-30-07'},
    {id: 5, nombre: 'Dr James', apellido: 'Gosling', email: 'jgosling@email.com', createAt: '2024-31-07'}
  ];

}
