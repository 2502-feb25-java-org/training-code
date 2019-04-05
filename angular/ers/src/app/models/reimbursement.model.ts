import { User } from "./user.model";
import { Type } from "./type.model";
import { Status } from "./status.model";

export class Reimbursement{
    id: number;
    amount: number;
    author: User;
    resolver: User;
    type: Type;
    description: string;
    status: Status;
}