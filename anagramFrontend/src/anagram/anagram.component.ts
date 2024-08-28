import { Component } from '@angular/core';
import {AnagramService} from "../service/anagram.service";
import {FormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-anagram',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf
  ],
  templateUrl: './anagram.component.html',
  styleUrl: './anagram.component.css'
})
export class AnagramComponent {
  text1: string = '';
  text2: string = '';
  result: boolean | null = null;
  candidateText: string = '';
  candidates: string[] = [];
  foundAnagrams: string[] = [];

  constructor(private anagramService: AnagramService) {}

  checkAnagrams(): void {
    this.anagramService.areAnagrams(this.text1, this.text2).subscribe(
      (response: boolean) => {
        this.result = response;
      },
      error => console.error('Error:', error)
    );
  }

  findAnagrams(): void {
    this.anagramService.findAllAnagrams(this.candidateText, this.candidates).subscribe(
      (response: string[]) => {
        this.foundAnagrams = response;
      },
      error => console.error('Error:', error)
    );
  }
}
