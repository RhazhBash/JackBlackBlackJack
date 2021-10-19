import { ICard } from "./card";


export interface theDeck{
    success: boolean,
    cards:ICard[]
    deck_id: string,
    
    remaining: number
}