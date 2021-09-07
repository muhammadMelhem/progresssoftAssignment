import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Deal } from './deal';

@Injectable({
  providedIn: 'root'
})
export class DealService {


  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/api/deals/';
  }
 

  public findById (id: any): Observable<Deal> {
    return this.http.get<Deal>(`${this.baseUrl}/${id}`);
  }
 


}
