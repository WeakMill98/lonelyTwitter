package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	// Cannot be changed later
	private static final String FILENAME = "file.sav";

	// Init of edit text and list view
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<Tweet> adapter;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Referring to the Activity's onCreate method, since you extended it
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Find the references to the XML path
		// Includes the text body, the old tweet list view,
		// as well as save and delete buttons
		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);

		// Set a click listener for the saveButton object
		// Save the entry to the file and update the listview
		// Save changes to an instance of the Important Tweet class
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				String text = bodyText.getText().toString();
				ImportantTweet importantTweet = new ImportantTweet();
				try {
					importantTweet.setMessage(text);
				}catch (TooLongTweetException e){}

				tweets.add(importantTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		// Set a button for the clear button
		// when a tweet is selected, if this button is pressed
		// then that tweet will be deleted
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				for(int i = tweets.size()-1 ; i >= 0; i--){
					tweets.remove(tweets.get(i));
				}
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		// The array of the tweets
		// notify change just refreshes the adapter
		//adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	// Creates a normal tweet type
	// Will add instances of new moods to the normal tweet object
	private Tweet CreateTweet(){
		Tweet normalTweet = new NormalTweet("");
		Happiness happiness = new Happiness();
		Sadness sadness = new Sadness();
		Anger anger = new Anger();

		normalTweet.AddMood(happiness);
		normalTweet.AddMood(sadness);
		normalTweet.AddMood(anger);

		return normalTweet;
	}

	// Loads Gson data from the save file
	// Use an object you can instantiate in the TypeToken
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);

			Gson gson = new Gson();
			// cannot use an abstract class with type token
			// needs more than one file inorder to save the files.
			Type typeListTweets = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();
			tweets = gson.fromJson(reader, typeListTweets);

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Save data in the file
	private void saveInFile() {
		try {
			// 0 means write
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter writer = new BufferedWriter(osw);
			Gson gson = new Gson();
			gson.toJson(tweets, osw);
			writer.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}