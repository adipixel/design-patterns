package genericSerDeser.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import genericSerDeser.strategy.SerStrategy;

public class DPML implements SerStrategy {

	List<String> outStr = new ArrayList<String>();
	
	public DPML()
	{
		Logger.writeMessage("DPML constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	
	@Override
	public List<String> generateWireFormat(Object obj) {
		
		try
		{
			Class objClass= obj.getClass();
			outStr.add("<fqn:"+objClass.getName()+">");
			Field[] fieldList =  objClass.getDeclaredFields();
			for (int j=0; j<fieldList.length; j++)
			{
				Class fieldClass = fieldList[j].getType();
			    String fieldName = fieldList[j].getName();
			    Object fieldObject = fieldList[j].get(obj);
			    String fclass = fieldClass.getName();
			    if(fieldName.equals("StringValue"))
			    {
			    	fclass = fclass.substring(10);
			    }
			    			    
			    outStr.add("<type=" + fclass + ", var=" + fieldName + ", value=" + fieldObject + ">");
			}
			outStr.add("</fqn:"+objClass.getName()+">");

			Logger.writeMessage("Serializing object "+ objClass.getName(), Logger.DebugLevel.IN_RESULTS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return outStr;

	}

	
}
