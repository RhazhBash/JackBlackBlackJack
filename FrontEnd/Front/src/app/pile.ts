import { ICard } from "./card";

export interface IPile {
    cards: ICard[],
    remaining: string
}