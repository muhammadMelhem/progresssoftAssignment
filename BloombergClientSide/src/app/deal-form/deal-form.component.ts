import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Deal } from '../deal';
import { DealService } from '../deal.service';
   
@Component({
  selector: 'app-deal-form',
  templateUrl: './deal-form.component.html',
  styleUrls: ['./deal-form.component.css']
})
export class DealFormComponent {

 public deal: Deal;
  

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
     private dealService: DealService) {
    this.deal = new Deal();
  }

  onSubmit() {
    this.dealService.findById(this.deal.id).subscribe(result => 
       console.log( this.deal=result)
       );
 
}
}