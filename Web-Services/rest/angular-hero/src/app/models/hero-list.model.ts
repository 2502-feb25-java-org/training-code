import { Hero } from "./hero.model";

export class HeroList {
    heroList: Hero[];

    constructor(heroList: Hero[]) {
        this.heroList = heroList;
    }
}