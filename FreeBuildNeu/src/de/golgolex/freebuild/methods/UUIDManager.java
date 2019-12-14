package de.golgolex.freebuild.methods;

import java.util.UUID;

import com.google.common.base.Charsets;

public class UUIDManager {
	
	public static String getUUID(String playername){
	    return 
	    
	      UUID.nameUUIDFromBytes(("OfflinePlayer:" + playername).getBytes(Charsets.UTF_8)).toString();
	  }

}
