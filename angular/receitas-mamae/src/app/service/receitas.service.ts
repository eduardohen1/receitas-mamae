import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReceitasService {

  private apiURL = 'http://localhost:8080/api/receitas';

  constructor(private http : HttpClient) { }

  buscarReceitas(): Observable<any[]> {
    const url = `${this.apiURL}`;
    return this.http.get<any[]>(url);
  }
}
