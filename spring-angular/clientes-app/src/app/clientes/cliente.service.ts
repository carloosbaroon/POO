import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from "./cliente";
import { CLIENTES } from "./clientes.json";
import { Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlEndPoint: string = 'http://localhost:8080/api/clientes';

  constructor(private http: HttpClient) {
  }

  getClientes(): Observable <Cliente[]> {
    //return of(CLIENTES);
    return this.http.get<Cliente[]>(this.urlEndPoint);
  }
}
