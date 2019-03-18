package com.watermark.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.TransformerException;

import com.watermark.app.instruction.Instruction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, TransformerException
    {
    	if(args.length > 0) {
    		List<String> instruction = new ArrayList<String>(Arrays.asList(args));    
    	
    	if(instruction.get(0).contentEquals("file")) {
    		Instruction instuction = new Instruction();
    		instuction.unmarkFile();
    	}else if(instruction.get(0).contentEquals("folder")) {
    		Instruction instuction = new Instruction();
    		instuction.unmarkFolder();
    	}

        

        
    	}
    
    }
}

