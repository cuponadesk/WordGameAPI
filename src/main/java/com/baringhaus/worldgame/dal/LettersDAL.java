package com.baringhaus.worldgame.dal;

import com.baringhaus.worldgame.model.Letter;
import com.baringhaus.worldgame.model.Letters;

import java.util.List;

public interface LettersDAL {

	List<Letters> getAllLetters();

	Letter getRandom();
}
