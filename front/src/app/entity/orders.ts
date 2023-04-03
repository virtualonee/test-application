import { orderLine } from "./orderLines";

export interface Order {
    id: bigint;
    client: string;
    address: string;
    date: Date;
    orderLinesDTOS: orderLine[];
    isCollapsedButton: boolean;
    sum:bigint;

}