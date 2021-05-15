package com.baringhaus.worldgame.controller;

import com.baringhaus.worldgame.dal.LettersDAL;
import com.baringhaus.worldgame.dal.LettersRepository;
import com.baringhaus.worldgame.model.Letter;
import com.baringhaus.worldgame.model.Letters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@RestController
public class LettersController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final LettersRepository lettersRepository;

	private final LettersDAL lettersDAL;

	public LettersController(LettersRepository lettersRepository, LettersDAL lettersDAL) {
		this.lettersRepository = lettersRepository;
		this.lettersDAL = lettersDAL;
	}

	@RequestMapping(value = "/letters", method = RequestMethod.GET)
	public List<Letters> getAllLetters() {
		return lettersRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public Letter getRandom() {
		Query query = new Query();
		query.addCriteria(Criteria.where(""));
		return lettersDAL.getRandom();
	}

}
