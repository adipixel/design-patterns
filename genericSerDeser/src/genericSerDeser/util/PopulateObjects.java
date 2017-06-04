package genericSerDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


import java.lang.String;

public class PopulateObjects {
	List<Object> objectList = new ArrayList<Object>();
	Map<String,String> dataType = new HashMap<String, String>();

	public Object denserObjects(List<String> objData) 
	{
		Object obj = null;
		try
		{
			String clsName, type, var, value;
			clsName = objData.get(0);
			clsName = clsName.replace(">", "");
			
			Class<?> cls = Class.forName(clsName);
			Class<?>[] signature = new Class<?>[1];
			Object[] params = new Object[1];
			obj = cls.newInstance();
			for(int i=1; i<objData.size();i++)
			{

				String line = objData.get(i);
				Logger.writeMessage("Processing class: "+ clsName + "\tData members: "+line, Logger.DebugLevel.IN_RUN);
				line = line.replace("<", "");
				line = line.replace(">", "");
				line = line.replace(",", "");
				StringTokenizer token = new StringTokenizer(line," =");
				token.nextToken();
				type = token.nextToken();
				token.nextToken();
				var = token.nextToken();
				token.nextToken();

				//value = token.nextToken();
				if(token.hasMoreTokens())
				{
					value = token.nextToken();
				}
				else
				{
					value="";
				}
				if("int".equals(type))
				{
					signature[0] = Integer.TYPE;
					params[0] = Integer.parseInt(value);
				}
				else if("byte".equals(type))
				{
					signature[0] = Byte.TYPE;
					params[0] = Byte.parseByte(value);
				}
				else if("short".equals(type))
				{
					signature[0] = Short.TYPE;
					params[0] = Short.parseShort(value);
				}
				else if("long".equals(type))
				{
					signature[0] = Long.TYPE;
					params[0] = Long.parseLong(value);
				}
				else if("float".equals(type))
				{
					signature[0] = Float.TYPE;
					params[0] = Float.parseFloat(value);
				}
				else if("double".equals(type))
				{
					signature[0] = Double.TYPE;
					params[0] = Double.parseDouble(value);
				}
				else if("boolean".equals(type))
				{
					signature[0] = Boolean.TYPE;
					params[0] = Boolean.parseBoolean(value);
				}
				else if("char".equals(type))
				{
					signature[0] = Character.TYPE;
					params[0] = value.toString().charAt(0);
				}
				else if("String".equals(type))
				{
					signature[0] = String.class;
					params[0] = value.toString();
				}
				else if("Integer".equals(type))
				{
					signature[0] = Integer.class;
					params[0] = new Integer(Integer.parseInt(value));
				}

				String methodName = "set" + var;
				Method meth = cls.getMethod(methodName, signature);
				Object result = meth.invoke(obj, params);
			}

			//store obj in data structure
			objectList.add(obj);
		}
		catch(NumberFormatException nf)
		{
			System.err.println("Invalid format");
			nf.printStackTrace();
		}
		catch(ClassNotFoundException cnf)
		{
			cnf.printStackTrace();
		}
		catch(NoSuchMethodException nsm)
		{
			nsm.printStackTrace();
		}
		catch(SecurityException s)
		{
			s.printStackTrace();
		}
		catch(InstantiationException i)
		{
			i.printStackTrace();
		}
		catch(IllegalArgumentException ia)
		{
			ia.printStackTrace();
		}
		catch(InvocationTargetException it)
		{
			it.printStackTrace();
		}
		catch(IllegalAccessException ia)
		{
			ia.printStackTrace();
		}
		return obj;
	}

	public void printSets()
	{
		System.out.println("Total Number of objects: "+objectList.size());
		
	}

	public List<Object> getObjectList() {
		return objectList;
	}
	
}