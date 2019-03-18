package com.watermark.app.loggers;

import com.watermark.app.loggers.Color;
import com.watermark.app.loggers.Level;

public class Logger implements ILogger {

	@Override
	public void error(String message) {
		log(Color.RED + "["+ Level.ERROR + "] -> " + message);
		
	}

	@Override
	public void success(String message) {
		log(Color.GREEN + "["+ Level.SUCCESS + "] -> " + message);
		
	}

	@Override
	public void info(String message) {
		log(Color.BLUE + "["+ Level.INFO + "] -> " + message);
		
	}

	@Override
	public void emergency(String message) {
		log(Color.RED + "["+ Level.EMERGENCY + "] -> " + message, true);
		
	}

	@Override
	public void log(String message) {
		System.out.println(message);
		
	}

	@Override
	public void log(String message, Boolean concat) {
		System.out.println(message);
	}

	
}
