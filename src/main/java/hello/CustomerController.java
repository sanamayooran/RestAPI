package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;

import java.util.List;
import java.util.Set;



@RestController
public class CustomerController {

    @RequestMapping(value="api/customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
       
String error = "";
	try
		{
			 //mongo db connection
			 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			 //connect database
			 DB db = mongoClient.getDB( "customerdb" );
			 //get collection
			 DBCollection coll = db.getCollection("customers");
			 //insert a document

			coll.save(customer);
		
		}
		catch(Exception ex){}
      return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
}