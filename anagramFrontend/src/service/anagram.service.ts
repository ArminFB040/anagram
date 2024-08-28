import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AnagramService {

  private apiUrl = 'http://localhost:8080'; // URL to the backend

  constructor(private http: HttpClient) { }

  areAnagrams(text1: string, text2: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.apiUrl}/anagrams/are`, { text1, text2 });
  }

  findAllAnagrams(text: string, candidates: string[]): Observable<string[]> {
    return this.http.post<string[]>(`${this.apiUrl}/anagrams/find`, { text, candidates });
  }
}
