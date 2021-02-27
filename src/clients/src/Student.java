package clients.src;

import java.io.Serializable;

public class Student implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = -6477551578383189100L;
    private int mat;
    private String name;
    private String lastName;
    

    /**
     * @return int return the mat
     */
    public int getMat() {
        return mat;
    }

    /**
     * @param mat the mat to set
     */
    public void setMat(int mat) {
        this.mat = mat;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Student(int mat,String name,String lastName){
        this.mat = mat;
        this.name = name;
        this.lastName = lastName;
    }
    public String toString(){
        return mat + "| "+name+"| "+lastName;

    }

    public int hashCode(){
        return mat;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Student student = (Student) o;
        
        if (this.mat != student.getMat()) return false;
        if (name != null ? !name.equals(student.getName()) : student.getName() != null) return false;
        
        return true;
        }
}

