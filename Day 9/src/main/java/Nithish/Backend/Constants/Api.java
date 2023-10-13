package Nithish.Backend.Constants;

import java.util.Arrays;
import java.util.List;

public class Api {
	
    public static final String DEFAULT = "http://localhost:8083";
    public static final String ENTRY = "/api/v1/entry";
    public static final String USER = "/api/v1/user";
    public static final String CONTACT = "/api/v1/contact";
    public static final List<String> HEADERS = Arrays.asList("Authorization", "Content-Type");
    public static final List<String> METHODS = Arrays.asList("GET", "POST", "PUT", "DELETE");
    public static final List<String> ORIGINS = Arrays.asList("http://localhost:3000", "http://localhost:3001", "http://localhost:3002");
}
