package main;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface CreatedBy { 
	String author(); 
	String date(); //default "14.05.13"; 
}

