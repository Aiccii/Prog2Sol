package be.kdg.mentoring.week02.security.model;

import java.util.Objects;

public class Account implements Comparable <Account>{
    private final String username;
    private final String password;

    private final String email;

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public int compareTo(Account o) {
        int result = username.compareTo(o.username);
        if(result == 0) {
            result += password.compareTo(o.password);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
