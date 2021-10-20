interface IImage{
    svg: string;
    png: string;
}
interface ICard{
    code: string;
    image: string;
    images: IImage;
    value: string;
    suit: string;
}

interface IPile {
    remaining: number;
    cards: ICard[];
}

interface IPiles{
    player: IPile;
}
export interface IPilesList{
    success: boolean;
    deck_id: string;
    remaining: number;
    piles: IPiles;
}