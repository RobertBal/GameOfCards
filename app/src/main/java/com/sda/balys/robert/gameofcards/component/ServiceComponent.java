package com.sda.balys.robert.gameofcards.component;

import com.sda.balys.robert.gameofcards.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by RENT on 2017-05-27.
 */
@Singleton
@Component(modules = {ServiceModule.class})
public interface ServiceComponent {
    void inject(MainActivity activity);

}
