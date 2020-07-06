package ro.internship.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import ro.internship.program.App;

public class ThreadUpdater extends FileProcessor implements Runnable {

	public void run() {
		try {
			if(App.getUpdateId() < 10) 
				updateJSONUser(App.getRandomIds().get(App.getUpdateId()));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
}
