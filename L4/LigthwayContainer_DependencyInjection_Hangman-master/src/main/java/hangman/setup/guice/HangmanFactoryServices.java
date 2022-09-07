/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.setup.guice;

import java.util.Dictionary;

/**
 *
 * @author 2106913
 */

import hangman.model.French;
import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.OriginalScore;
import hangman.model.dictionary.HangmanDictionary;
import hangman.model.dictionary.FrenchDictionaryDataSource;
import hangman.view.HangmanColoridoPanel;
import hangman.view.HangmanNoviolentoPanel;
import hangman.view.HangmanPanel;

public class HangmanFactoryServices extends com.google.inject.AbstractModule {

    @Override
    protected void configure() {
    	bind(Language.class).to(French.class);
    	bind(HangmanDictionary.class).to(FrenchDictionaryDataSource.class);
    	bind(HangmanPanel.class).to(HangmanColoridoPanel.class);
    	bind(GameScore.class).to(OriginalScore.class);
    	
    }

}
