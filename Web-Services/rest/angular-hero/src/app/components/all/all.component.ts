import { Component, OnInit } from '@angular/core';
import { HeroService } from '../../services/hero.service';
import { Hero } from '../../models/hero.model';
import { ClientMessage } from '../../models/client-message.model';
import { HeroList } from '../../models/hero-list.model';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {
    title = 'All Heroes';

    ngOnInit() {
      this.findAllHeroes();
    }

    public heroes: HeroList = new HeroList([]);

    public clientMessage: ClientMessage = new ClientMessage('No heroes to display.');

    constructor(private heroService: HeroService) {}

    public findAllHeroes(): void {
      this.heroService.findAllHeroes()
        .subscribe(
          data => this.heroes = data,
          responseError => this.clientMessage = responseError.error
        );
    }
}
