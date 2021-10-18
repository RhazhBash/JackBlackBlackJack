import { IPile } from "./pile";

export interface IPiles{
    success: boolean,
    deck_id: string,
    remaining: string,
    piles: IPile[]
}