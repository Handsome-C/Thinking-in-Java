package cyc.exception;
class DynamicFieldsException extends Exception
{}
public class DynamicFields {
private Object[][]fields;

public DynamicFields(int initialSize)
{
    fields =new Object[initialSize][2];
    for(int i=0;i<initialSize;i++)
        fields[i]=new Object[]{null,null};
}
public String toString()
{
    StringBuffer result=new StringBuffer();
    for (Object[] o:fields
         ) {
        result.append(o[0]);
        result.append(": ").append(o[1]).append("\n");
    }
    return result.toString();
}

private int hasField(String id)
{
    int i;
    for(i=0;i<fields.length;i++)
        if(fields[i][0]==id)
            return i;
    return -1;
}
private int getFieldNumber(String id) throws NoSuchFieldException
{
     int fieldNum=hasField(id);
     if(fieldNum==-1)
         throw new NoSuchFieldException();
     return fieldNum;
}
private int makeField(String id)
{
      for(int i=0;i<fields.length;i++)
      {
          if(fields[i][0]==null)
          {
              fields[i][0]=id;
              return i;
          }
      }
      Object[][] temp=new Object[fields.length+1][2];
      for(int i=0;i<fields.length;i++)
          temp[i]=fields[i];
      temp[fields.length+1]=new Object[]{null,null};
      fields=temp;
      return makeField(id);
}
public Object getField(String id) throws NoSuchFieldException
{
    return fields[getFieldNumber(id)][1];
}

public Object setField(String id,Object value) throws DynamicFieldsException
{
    if(value==null)
    {
        DynamicFieldsException dfe=new DynamicFieldsException();
        dfe.initCause(new NullPointerException());
        throw dfe;
    }
    int fieldNumber =hasField(id);
    if(fieldNumber == -1)
        fieldNumber =makeField(id);
    Object result=null;
    try
    {
        result=getField(id);
    }
    catch(NoSuchFieldException e)
    {
        throw new RuntimeException(e);
    }
    fields[fieldNumber][1]=value;
    return result;
}
public static void main(String[]args)
{
    DynamicFields df=new DynamicFields(3);
    System.out.println(df);
    try
    {
        df.setField("d","A value of d");
        df.setField("number",47);
        df.setField("number2",48);
        System.out.println(df);
        df.setField("d","A new value for d");
        System.out.println("df"+df);
        System.out.println("df.getField(\"d\") "+df.getField("d"));
        Object field =df.setField("d",null);
    }
    catch(NoSuchFieldException e)
    {
        e.printStackTrace(System.out);
    }
    catch(DynamicFieldsException e)
    {
        e.printStackTrace(System.out);
    }
}

}
