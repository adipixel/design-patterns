package genericSerDeser.util;

public class First {

	 boolean BooleanValue;
	 byte ByteValue;
	 char CharValue;
	 double DoubleValue;
	 float FloatValue;
	 int IntValue;
	 long LongValue;
	 short ShortValue;
	 String StringValue = null;
	
	public First()
	{
		
		ByteValue=0;
		 ShortValue=0;
		 IntValue=0;
		 LongValue=0;
		 FloatValue=(float) 0.0;
		 DoubleValue=0.0;
		 BooleanValue=false;
		 CharValue='\u0000';
		 StringValue = null;
		
		Logger.writeMessage("First constructor", Logger.DebugLevel.CONSTRUCTOR);
		
	}

	public boolean isBooleanValue() {
		return BooleanValue;
	}

	public void setBooleanValue(boolean booleanValue) {
		BooleanValue = booleanValue;
	}

	public byte getByteValue() {
		return ByteValue;
	}

	public void setByteValue(byte byteValue) {
		ByteValue = byteValue;
	}

	public char getCharValue() {
		return CharValue;
	}

	public void setCharValue(char charValue) {
		CharValue = charValue;
	}

	public double getDoubleValue() {
		return DoubleValue;
	}

	public void setDoubleValue(double doubleValue) {
		DoubleValue = doubleValue;
	}

	public float getFloatValue() {
		return FloatValue;
	}

	public void setFloatValue(float floatValue) {
		FloatValue = floatValue;
	}

	public int getIntValue() {
		return IntValue;
	}

	public void setIntValue(int intValue) {
		IntValue = intValue;
	}

	public long getLongValue() {
		return LongValue;
	}

	public void setLongValue(long longValue) {
		LongValue = longValue;
	}

	public short getShortValue() {
		return ShortValue;
	}

	public void setShortValue(short shortValue) {
		ShortValue = shortValue;
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
		result = 31 * (BooleanValue ? 7 : 13) + ByteValue + CharValue + Float.floatToIntBits(FloatValue) + IntValue + ((int) (LongValue ^ (LongValue >>> 32))) +  ShortValue;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		
		First firstObj = (First) obj;
		return (BooleanValue == firstObj.BooleanValue) && (ByteValue == firstObj.ByteValue) && (CharValue == firstObj.CharValue) && (Double.doubleToLongBits(DoubleValue) == Double.doubleToLongBits(firstObj.DoubleValue))  && (Float.floatToIntBits(FloatValue) == Float.floatToIntBits(firstObj.FloatValue)) && (IntValue == firstObj.IntValue) && (LongValue == firstObj.LongValue) && (ShortValue == firstObj.ShortValue) && StringValue.equals(firstObj.StringValue);
	}*/

	
	
	

}