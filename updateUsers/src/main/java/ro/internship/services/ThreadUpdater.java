package ro.internship.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import ro.internship.program.App;
import ro.internship.services.*;

public class ThreadUpdater extends FileProcessor implements Runnable {

	public void run() {
		try {
			if(App.getUpdateId() < 10)
				updateJSONUser(App.getRandomIds().get(App.getUpdateId()));
//			System.out.println("works");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
