import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../environments/environment';
@Injectable({
  providedIn: 'root',
})
export class HttpService {
  constructor(private http: HttpClient) {}
  getPaymentMethods() {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    const options = {headers: headers};
    return this.http.get(`http://localhost:8080/web/paymentMethods`,options);
  }
  makePayment(request: any) {
    return this.http.post(`http://localhost:8080/web/payments`, request);
  }
  paymentDetails(request: any) {
    return this.http.post(`http://localhost:8080/web/paymentDetails`, request);
  }
}