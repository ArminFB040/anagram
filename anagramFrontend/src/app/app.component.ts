import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import {AnagramComponent} from "../anagram/anagram.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [HttpClientModule, RouterModule, AnagramComponent]  // Import any other necessary modules
})
export class AppComponent {
  title = 'anagramFrontend';
}
