import { Component } from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-directive',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './directive.component.html',
})
export class DirectiveComponent {

  listaCurso: string[] = ['TypeScript', 'JavaScript', 'Java SE', 'PHP'];

  habilitar: boolean = true;

  setHabilitar(): void {
    this.habilitar = !this.habilitar
  }

}
