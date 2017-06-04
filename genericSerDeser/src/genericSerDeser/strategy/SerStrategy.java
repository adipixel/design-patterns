package genericSerDeser.strategy;

import java.util.List;

public interface SerStrategy {

	public List<String>  generateWireFormat(Object obj);
	
	default List<String> serializeObjects(Object obj, SerStrategy strategy)
	{
		return strategy.generateWireFormat(obj);
	}
}

