import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root', //This will the tag in html
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html', //This is the view for this component
  styleUrl: './app.component.css' //This is the style sheet
})

//This is the MAIN component of the app!
export class AppComponent {
  title = 'Bienvenido a Angular';
  curso = 'Curso Spring con Angular';
}
