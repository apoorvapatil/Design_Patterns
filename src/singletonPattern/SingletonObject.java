package singletonPattern;

import java.io.Serializable;

import javax.management.RuntimeErrorException;

public class SingletonObject implements Serializable, Cloneable{
	
	//Create SingletonObject which is static
	//private static SingletonObject singleton=new SingletonObject(); //Eager initialization
	
	private static volatile SingletonObject singleton=null; //Lazy initialization
	
	//Make SingletonObject constructor private
	private SingletonObject(){
		// Solution for violation using REFLECTION
		if(singleton!=null){
			throw new RuntimeException("Cannot create instance please use getInstance instead");
		}
		
		// Else go ahead with creation
		System.out.println("Class loader initialized the constructor");
	}
	
	//Get SingletonObject instance
	//Solution to MULTI-THREADING
	public static SingletonObject getInstance(){
		//Lazy initialization
		/*if(singleton==null){
			synchronized(SingletonObject.class){
				if(singleton==null){
					singleton=new SingletonObject();
				}
			}
			
		}
		return singleton;*/
		return Holder.INSTANCE;
	}
	 static class Holder{
		 static final SingletonObject INSTANCE=new SingletonObject();
	 }
	
	//Print message
	public static void print(){
		System.out.println("Singleton Pattern");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
	
	// Solution for violation using SERIALIZATION-DESERIALIZATION
	private Object readResolve(){
		System.out.println("Read resolve");
		return singleton;
	}
}
