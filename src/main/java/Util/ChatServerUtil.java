package Util;

import Util.pojo.ChatCreateUserPOJO;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static Util.ConfigReader.*;

public class ChatServerUtil {
    RequestSpecification reqSpec;
    public  RequestSpecification getRequestSpecification() throws IOException {

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName(getUsername());
        auth.setPassword(getPassword());


        if(reqSpec==null) {
            PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(getUrl())
                    .setAuth(auth)
                    .addHeader("Content-Type", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
        }
        return reqSpec;
    }


    public  ChatCreateUserPOJO getCreateUserPayload(String username,String password,String name,String surname)
    {
        ChatCreateUserPOJO chatCreateUserPOJO = new ChatCreateUserPOJO();
        chatCreateUserPOJO.setName(name);
        chatCreateUserPOJO.setSurname(surname);
        chatCreateUserPOJO.setUsername(username);
        chatCreateUserPOJO.setPassword(password);
        chatCreateUserPOJO.setChat_nickname("am");
        chatCreateUserPOJO.setEmail("amol@gmail.com");

        ArrayList<Integer> dept = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};

        chatCreateUserPOJO.setDepartments(dept);


        ArrayList<Integer> deptGrp = new ArrayList<Integer>() {{
            add(1);

        }};

        chatCreateUserPOJO.setDepartment_groups(deptGrp);

        ArrayList<Integer> usrGrp = new ArrayList<Integer>() {{
            add(1);

        }};

        chatCreateUserPOJO.setUser_groups(usrGrp);

        ArrayList<Integer> deptRead = new ArrayList<Integer>() {{

            add(2);
        }};

        chatCreateUserPOJO.setDepartments_read(deptRead);

        return chatCreateUserPOJO;
    }
}
