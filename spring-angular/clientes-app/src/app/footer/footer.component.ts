import {Component} from "@angular/core";

@Component({
  selector: 'footer-component',
  standalone: true,
  templateUrl: 'footer.component.html',
  styleUrls: ['footer.component.css']
})
export class FooterComponent {
  public autor: any = {nombre: 'Aleph', apellido: 'Baron'}
}
