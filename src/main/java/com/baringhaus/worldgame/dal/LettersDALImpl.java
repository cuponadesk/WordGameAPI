package com.baringhaus.worldgame.dal;

import com.baringhaus.worldgame.model.Letter;
import com.mongodb.*;
import com.mongodb.util.JSON;


import com.baringhaus.worldgame.model.Letters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LettersDALImpl implements LettersDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Letters> getAllLetters() {
		return mongoTemplate.findAll(Letters.class);
	}

	@Override
	public Letter getRandom() {
		/*
		 * Requires the MongoDB Java Driver.
		 * https://mongodb.github.io/mongo-java-driver
		 */
		String command = "[{$project: {letters: 1,characters: {\"$arrayElemAt\": [{$objectToArray: \"$characters\"},{\"$floor\": {$multiply: [{$rand: {}},7]}}]}}}, {$sample: {size: 1}}]";
		String f = "{\"project\":{ \"letters\" : 1}}";

		DBObject dbObject = new BasicDBObject(
				"aggregate", "letters").append(
				"pipeline", JSON.parse(
						"[{$project: {" +
								"_id : 0," +
								"letters: 1," +
								" required: { $arrayElemAt: [ {$objectToArray: \"$characters\"  },  { $floor: {  $multiply: [ { $rand: {}  }, 7 ] } }]}" +
								"}}, " +//end project
						"{$replaceWith: {\n" +
								"  letters : { $map:{ input:{ $range:[ 0,{ $strLenCP:\"$letters\"} ] },  in:{$substrCP:[ \"$letters\", \"$$this\", 1 ] } }},\n" +
								"  required: \"$required.k\",\n" +
								"  words: \"$required.v\"\n" +
								"}}," +
								"{$sample: { size : 1}}] "
				))
				.append("cursor", new BasicDBObject("batchSize", 1)
		);

		CommandResult re = mongoTemplate.executeCommand(dbObject);

		BasicDBObject b =(BasicDBObject) ((BasicDBList) ((DBObject) re.get("cursor")).get("firstBatch")).get(0);
		Letter r = new Letter();
		r.setWords((List<String>) b.get("words"));
		r.setRequired(b.getString("required"));
		r.setLetters((List<String>) b.get("letters"));



		return r;
	}
}
