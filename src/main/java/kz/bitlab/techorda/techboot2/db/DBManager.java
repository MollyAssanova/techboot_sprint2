package kz.bitlab.techorda.techboot2.db;

import java.util.ArrayList;

public class DBManager {
    private static  ArrayList<ApplicationRequest> applicationRequests=new ArrayList<>();
    private static Long id= 3L;
    static{
        applicationRequests.add(new ApplicationRequest(1L, "Moldir Assanova", "Java Developer Course", "Very good", "87474012884", true));
        applicationRequests.add(new ApplicationRequest(2L, "Madina Assanova", "English B1+ Course", "Very good", "87474012771", true));
    }
    public static ArrayList<ApplicationRequest> getApplicationRequests(){
        return applicationRequests;
    }

    public static void addApplicationRequest(ApplicationRequest applicationRequest){
        applicationRequest.setId(id++);
        applicationRequests.add(applicationRequest);
    }

    public static ApplicationRequest getApplicationRequest(int id){
        return applicationRequests.stream().filter(applicationRequest -> applicationRequest.getId()==id).findFirst().orElse(null);
    }
}
