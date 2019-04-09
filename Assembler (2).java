//Code written in Java that converts Mneomonic code to machine code.

import java.util.*;
import java.io.*;
public class Assembler
{
    int i=0,j;
    String str; //input string
    String arr[],arr1[]; //for splitting
    String a,b,code,a1,a2,a3,a4,t,output;
    public void get_data() throws FileNotFoundException,IOException
    {

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bwrite=new BufferedWriter(new FileWriter("d:/machine_code.txt"));
        arr=new String[50];
	arr1=new String[50];
        System.out.println("Enter the Source Code : ");
        Scanner s= new Scanner(System.in);
	File fr=new File("d:/mot.txt"); //Opening the MOT file
        boolean bool=true;
	str =s.nextLine(); //taking input
	while(str.compareTo("END")!=0) //END when "END" is taken as input
        {
	    Scanner sc1= new Scanner(fr);
	    bool=true;
            arr=str.split("[\\,\\ \\(\\)]"); //splitting of the input on basis of ',','(',')' and space

	    if(arr.length==5) //checking for RX MODE
	    {
            	 a=arr[0];
            	a1=arr[1];
            	a2=arr[2];
            	a3=arr[3];
            	a4=arr[4];
            	j=Integer.parseInt(arr[2]); //the content in arr[2] needs to be converted in hexadecimal code
            	b=convert(j); //converting to hexadecimal and b stores the hexadecimal value

            	while(bool)
		{
			bool=true;
                	t=sc1.nextLine(); //reading from mot line by line
	    		arr1=t.split("\\s"); //splitting
			if(arr1[1].equals(arr[0])) //searching for exact match
                	{
				code=arr1[0];
                        	bool=false;
				sc1.close();
                	}
            	}

                StringBuffer sb=new StringBuffer(); 

		//writing the output in machine code format

                sb.append(code);
                sb.append(a1);
                sb.append(a3);
                sb.append(a4);
                sb.append(b);
                output=sb.toString(); //converting sb to string
	        bwrite.write(output);//writing in file in machine code
		bwrite.newLine();//for new line
	        bwrite.flush();
            }
            else
	    if(arr.length==3)//checkinf for RR MODE
            {
	    	 a=arr[0];
            	a1=arr[1];
            	a2=arr[2];
            	while(bool)
	   	{
			bool=true;
                	t=sc1.nextLine(); //reading from mot line by line
	    		arr1=t.split("\\s"); //splitting
			if(arr1[1].equals(arr[0])) //searching for exact match
               		{
				code=arr1[0];
                        	bool=false;
				sc1.close();
                	}
           	}
            
               StringBuilder sb=new StringBuilder();
		
	       //writing the output in machine code format

               sb.append(code);
               sb.append(a1);
               sb.append(a2);
               output=sb.toString();
	       bwrite.write(output);
	       bwrite.write("\n");
	       bwrite.flush();
            }
	   	
	       str=s.nextLine(); //menomonic code input
        }

	bwrite.close();
    }
    
    //Function that takes decimal value as input and converts it to hexadecimal value

    public String convert(int dec)
    {
        String hex=Integer.toHexString(dec);
        return hex;
    }

    //Function for displaying the output

    public void print()throws IOException
    {
	String s;
	BufferedReader bread=new BufferedReader(new FileReader("d:/machine_code.txt"));
	while((s=bread.readLine())!=null)
	{
		System.out.println(s);
	}
    }

    public static void main(String[] args)throws FileNotFoundException,IOException
    {
        Assembler obj=new Assembler();
        obj.get_data();  
	obj.print();
    }
    
}

