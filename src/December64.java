import java.io.*;
import java.util.List;

public class December64 implements Serializable {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;


        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Person(){}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.mother);
            out.writeObject(this.father);
            out.writeObject(this.firstName);
            out.writeObject(this.lastName);
            out.writeObject(this.age);
            out.writeObject(this.children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
                mother=(Person)in.readObject();
                father=(Person)in.readObject();
                firstName = (String) in.readObject();
                lastName = (String) in.readObject();
                age = in.readInt();
                children = (List<Person>) in.readObject();
        }
    }

}
