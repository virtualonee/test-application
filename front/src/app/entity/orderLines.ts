export class orderLine {
    id: bigint;
    goodsId: bigint;
    goodsName: string;
    orderGoods: bigint;
    goodsPrice: bigint;
    count: bigint;
    sum: bigint;
    isCollapsedButton: boolean;
}