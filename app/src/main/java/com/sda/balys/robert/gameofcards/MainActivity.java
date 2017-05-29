package com.sda.balys.robert.gameofcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.sda.balys.robert.gameofcards.component.DaggerServiceComponent;
import com.sda.balys.robert.gameofcards.component.ServiceComponent;
import com.sda.balys.robert.gameofcards.model.Card;
import com.sda.balys.robert.gameofcards.model.Deck;
import com.sda.balys.robert.gameofcards.module.ServiceModule;
import com.sda.balys.robert.gameofcards.service.CardService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.appSpinner)
    Spinner spinner;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;

    private int itemSelect;
    private String deck_id;
    ServiceComponent serviceComponent;
    String url = "https://deckofcardsapi.com/api/deck/";
    private CardService.CardAPI cardApi;
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        injectServiceComponent();
        configureSpinner();
    }

    private void configureSpinner() {
        Integer[] items = new Integer[]{1,2,3,4,5};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,items);
        spinner.setAdapter(adapter);
    }



    private void chosseFromSpiner(){

    }

    @OnClick(R.id.button3)
    public void clickOnButton3(){
        fetchCardFromDeckID(3);
    }

    @OnClick(R.id.button2)
    public void clicOnButton(){
      itemSelect =  spinner.getSelectedItemPosition();
        itemSelect= (int) spinner.getItemAtPosition(itemSelect);
        Toast.makeText(this,itemSelect+"dupa",Toast.LENGTH_SHORT).show();
        fetchDeck(itemSelect);

    }

    private void injectServiceComponent(){
        serviceComponent = DaggerServiceComponent.builder()
                .serviceModule(new ServiceModule(url))
                .build();
        serviceComponent.inject(this);
        cardApi = retrofit.create(CardService.CardAPI.class);
    }
    public void fetchDeck(final int count){
        cardApi.fetchDeck(count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Deck>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Deck deck) {
                    deck_id = deck.getDeck_id();

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("Message",String.valueOf(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void fetchCardFromDeckID(int count){
        cardApi.fetchCardFromDeckID(deck_id,count).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Card>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Card card) {


            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
