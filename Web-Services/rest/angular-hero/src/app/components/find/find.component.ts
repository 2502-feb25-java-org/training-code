import { Component } from '@angular/core';
import { Hero } from '../../models/hero.model';
import { HeroService } from '../../services/hero.service';
import { ClientMessage } from '../../models/client-message.model';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent {
    title = 'Find Hero';

    constructor(private heroService: HeroService) {}

    //To capture user input
    public hero: Hero = new Hero(0,'','',false);

    //To present received hero
    public heroData: Hero = new Hero(0,'','',false);

    //To message the user
    public clientMessage: ClientMessage = new ClientMessage('');

    public findHero(): void {
      this.heroService.findHero(this.hero)
      .subscribe(
        data => this.heroData = data,
        responseError => {
          this.heroData = null;
          this.clientMessage = responseError.error;
        }
      );
    }
}
