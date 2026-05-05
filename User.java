import java.util.*;
import java.io.*;

public abstract class User implements HasMenu, Serializable {
	protected String userName;
	protected String PIN;

	public void setUserName(String name)
	{
		this.userName = name;
	}
	public String getUserName()
	{
		return this.userName; 
	}

	public void setPIN(String pin)
	{
		this.PIN = pin;
	} 
	public String getPIN()
	{
		return this.PIN;
	}

	public boolean login(String u, String p)
	{
		return (u.equals(this.userName) && p.equals(this.PIN));
	}

	public abstract String getReport();
}
