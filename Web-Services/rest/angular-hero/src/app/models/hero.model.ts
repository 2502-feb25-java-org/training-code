export class Hero {
    id: number;
    name: string;
    superPower: string;
    hasCape: boolean;

    constructor(id: number, name: string, superPower: string, hasCape: boolean) {
        this.id = id;
        this.name = name;
        this.superPower = superPower;
        this.hasCape = hasCape;
    }
}