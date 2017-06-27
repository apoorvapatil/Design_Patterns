package singletonPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.stream.FileImageInputStream;

public class SingletonMain {

	public static void main(String[] args) throws Exception{
		
		//The constructor SingletonObject() is not visible
		//SingletonObject obj=new SingletonObject();
		
		SingletonObject obj1=SingletonObject.getInstance();
		SingletonObject obj2=SingletonObject.getInstance();
		print("obj1",obj1);
		print("obj2",obj2);
		
		// REFLECTION
		/*Class clazz=Class.forName("singletonPattern.SingletonObject");
		Constructor<SingletonObject> cton=clazz.getDeclaredConstructor();
		cton.setAccessible(true);
		SingletonObject obj3=cton.newInstance();
		print("obj3",obj3);*/
		
		
		// SERIALIZATION-DESERIALIZATION
		/*ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("s2.ser"));
		oos.writeObject(obj2);
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("s2.ser"));
		SingletonObject obj3=(SingletonObject) ois.readObject();
		print("obj3",obj3);
		
		// CLONE
		SingletonObject obj3=(SingletonObject) obj2.clone();
		print("obj3",obj3);*/
		
		// MULTI-THREADING
		ExecutorService svc=Executors.newFixedThreadPool(2);
		svc.submit(SingletonMain::useThread);
		svc.submit(SingletonMain::useThread);
		svc.shutdown();
	}
	private static void print(String string, SingletonObject obj1) {
		System.out.println(string+" "+obj1.hashCode());
		
	}
	private static void useThread(){
		SingletonObject obj4=SingletonObject.getInstance();
		print("obj4",obj4);
	}

}
