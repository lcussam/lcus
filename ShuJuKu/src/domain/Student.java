package domain;

public class Student
{
	int sno;

    String sname;

    int sage;

    String ssex;
    public Student(int sno, String sname, int sage, String ssex)
    {        
    	super();        
    	this.sno = sno;        
    	this.sname = sname;        
    	this.sage = sage;        
    	this.ssex = ssex;    
    }    
    public int getSno() 
    {        
    	return sno;    
    }    
    public void setSno(int sno) 
    {        
    	this.sno = sno;    
    }    
    public String getSname() 
    {        
    	return sname;    
    }    
    public void setSname(String sname) 
    {        
    	this.sname = sname;    
    }    
    public int getSage() 
    {        
    	return sage;    
    }    
    public void setSage(int sage) 
    {        
    	this.sage = sage;    
    }    
    public String getSsex() 
    {        
    	return ssex;    
    }    
    public void setSsex(String ssex) 
    {        
    	this.ssex = ssex;    
    }    
    @Override    
    public String toString() 
    {        
    	return "Student [sno=" + sno + ", sname=" + sname + ", sage=" + sage                + ", ssex=" + ssex + "]";    
    }
}