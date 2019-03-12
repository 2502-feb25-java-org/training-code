import java.io.IOException;

class HelloWorld{
//Start point of execution
	public static void main(String ...args)// Main Thread
	{
		int result=0;
		result=add(args);
		System.out.println(result);
		try{
			int argslength=args.length;
			if(argslength>0)
				System.out.println("Hello World !");
			else
				throw new IOException("No CLI commands");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("you are trying to read CLI args which are not passed "+ex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}	
	}
	/*public static int add(int a, int b){		
		return a+b;
	}
	public static int add(int a, int b.int c){		
		return a+b+c;
	}*/
	public static int add(String ...a){
		int result=0;
		for(int i=0; i<a.length; i++)
				result +=Integer.parseInt(a[i]);
		return result;
	}
	
}