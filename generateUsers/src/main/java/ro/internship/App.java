package ro.internship;

import java.io.IOException;

import ro.internship.services.JSONWriter;

public class App 
{
	
	private volatile static int id = 0;
	
	public synchronized static int getNextId() {
		return id++;
	}
	
	public synchronized static int getCurrentId() {
		return id;
	}
	
    public static void main(String[] args) throws IOException {
    	// runs the app until every user is written to the file;
    	while(id < 100) {
    		JSONWriter.writeToJSON();
    	}
    }
}
