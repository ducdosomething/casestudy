package model;

public class LibrarianAccount extends Account {
    private int iD;
    private  int age;
    private  String gender;

    public LibrarianAccount(String username, String password, int iD, int age, String gender) {
        super(username, password);
        this.iD = iD;
        this.age = age;
        this.gender = gender;
    }


    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "LibrarianAccount.txt{" +
                "id=" + iD +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
