package be.kdg.mentoring.week02.security;

import be.kdg.mentoring.week02.security.model.Account;
import be.kdg.mentoring.week02.security.model.AuthenticationManger;
import be.kdg.mentoring.week02.security.model.CollectionAuthenticationManager;

import java.util.*;

public class SecurityMain {
    public static void main(String[] args) {
        AuthenticationManger authenticationManger = new CollectionAuthenticationManager();

        boolean authenticated = authenticationManger.authenticate("Username", "Password");

        System.out.println("This should not work! " + authenticated);

        authenticationManger.register("Username", "Password");

        authenticated = authenticationManger.authenticate("Username", "Password");

        System.out.println("This should  work! " + authenticated);

        for (int i = 10; i > 0; i--) {
            authenticationManger.register("User-" + i, "Password" + i);
        }
        Collection<Account> users = authenticationManger.getUsers();
        System.out.println(users);



        List<Account> myNewList= new ArrayList<>(users) ;

        Set<Account> myNewSet = new HashSet(users);
        Account myAccount = new Account("Username", null, null);

        myNewList.add(myAccount);
        boolean added = myNewSet.add(myAccount);

        System.out.println(myNewList);
        System.out.println(myNewSet);


        ArrayList<Account> usersCopy = new ArrayList<>(users);
        Collections.reverse(usersCopy);

        System.out.println(usersCopy);

//        List<String> list = new ArrayList<>(Arrays.asList("String1", "String2"));
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("String1", "String2"));

        System.out.println(list);

        list.add("String3");
        System.out.println(list);

        list = Collections.unmodifiableList(list);



//        list.add("String4");
//        System.out.println(list);


        List<String> listOfStrings = List.of("String1", "String2");
        System.out.println(listOfStrings);
        System.out.println(listOfStrings.getClass().getName());
    }
}
