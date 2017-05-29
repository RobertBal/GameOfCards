package com.sda.balys.robert.gameofcards.service;


import com.sda.balys.robert.gameofcards.model.Card;
import com.sda.balys.robert.gameofcards.model.Deck;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by RENT on 2017-05-29.
 */

public class CardService {
    public interface CardAPI{
        //GET NEW DECK
        @GET("new/shuffle")
        Observable<Deck> fetchDeck(@Query("deck_count") int deck_count);

        //GET CARD
        @GET("{deck_id}/draw")
        Observable<Card> fetchCardFromDeckID(@Path("deck_id") String deck_id,
                                             @Query("count") int count);

    }
}
