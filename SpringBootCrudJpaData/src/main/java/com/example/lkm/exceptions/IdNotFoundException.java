package com.example.lkm.exceptions;

@SuppressWarnings("serial")
public class IdNotFoundException extends Exception{
	public IdNotFoundException() {
	super("Id does not exist ");
	}
}
