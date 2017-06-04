package genericSerDeser.util;

public class Second {

	 double DoubleValue;
	 double DoubleValue2;
	 long LongValue;
	 long LongValue2;
	 short ShortValue;
	 short ShortValue2;
	 String StringValue = null;
	 
	 public Second()
	{
		 ShortValue=0;
		 ShortValue2=0;
		 LongValue=0;
		 LongValue2=0;
		 DoubleValue=0.0;
		 DoubleValue2=0.0;
		 StringValue = null;
		Logger.writeMessage("Second constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	 
	 public double getDoubleValue() {
		return DoubleValue;
	}

	public void setDoubleValue(double doubleValue) {
		DoubleValue = doubleValue;
	}

	public double getDoubleValue2() {
		return DoubleValue2;
	}

	public void setDoubleValue2(double doubleValue2) {
		DoubleValue2 = doubleValue2;
	}

	public long getLongValue() {
		return LongValue;
	}

	public void setLongValue(long longValue) {
		LongValue = longValue;
	}

	public long getLongValue2() {
		return LongValue2;
	}

	public void setLongValue2(long longValue2) {
		LongValue2 = longValue2;
	}

	public short getShortValue() {
		return ShortValue;
	}

	public void setShortValue(short shortValue) {
		ShortValue = shortValue;
	}

	public short getShortValue2() {
		return ShortValue2;
	}

	public void setShortValue2(short shortValue2) {
		ShortValue2 = shortValue2;
	}

	public String getStringValue() {
		return StringValue;
	}

	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}

	
	
	

	/*@Override
	public int hashCode() {
		int result = 1;
		result = 31 * (BooleanValue ? 7 : 13) + ByteValue + CharValue + Float.floatToIntBits(FloatValue) + IntValue + ((int) (LongValue ^ (LongValue >>> 32))) + ((int) (LongValue2 ^ (LongValue2 >>> 32))) + ShortValue + ShortValue2 ;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		Second secondObj = (Second) obj;
		return (BooleanValue == secondObj.BooleanValue) && (ByteValue == secondObj.ByteValue) && (CharValue == secondObj.CharValue) && (Double.doubleToLongBits(DoubleValue) == Double.doubleToLongBits(secondObj.DoubleValue)) && (Double.doubleToLongBits(DoubleValue2) == Double.doubleToLongBits(secondObj.DoubleValue2)) && (Float.floatToIntBits(FloatValue) == Float.floatToIntBits(secondObj.FloatValue)) && (IntValue == secondObj.IntValue) && (LongValue == secondObj.LongValue) && (LongValue2 == secondObj.LongValue2) && (ShortValue == secondObj.ShortValue) && (ShortValue2 == secondObj.ShortValue2) && StringValue.equals(secondObj.StringValue);
	}*/

	

}